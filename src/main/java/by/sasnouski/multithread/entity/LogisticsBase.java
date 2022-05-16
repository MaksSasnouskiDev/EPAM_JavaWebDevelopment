package by.sasnouski.multithread.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LogisticsBase {
    private static final Logger logger = LogManager.getLogger();

    public static final int BASE_CAPACITY = 5_000;
    public static final int TERMINALS_AMOUNT = 3;

    private static LogisticsBase baseInstance;

    private static final ReentrantLock baseCreatorLock = new ReentrantLock();
    private static final AtomicBoolean isCreatedBase = new AtomicBoolean(false);

    private ReentrantLock lock = new ReentrantLock();
    private final Deque<Terminal> freeTerminals = new ArrayDeque<>();
    private final Deque<Condition> waitingQueue = new ArrayDeque<>();

    private final ReentrantLock baseCapacityLock = new ReentrantLock();

    private Condition waitForUploadedCapacity = baseCapacityLock.newCondition();
    private Condition waitForDownloadedCapacity = baseCapacityLock.newCondition();
    private int capacity;


    private LogisticsBase() {

        for (int i = 0; i < TERMINALS_AMOUNT; i++) {
            Terminal terminal = new Terminal(i + 1, this);

            freeTerminals.add(terminal);
        }
    }


    public static LogisticsBase getBaseInstance() {

        if (!isCreatedBase.get()) {

            try {
                baseCreatorLock.lock();

                if (baseInstance == null) {
                    baseInstance = new LogisticsBase();
                    isCreatedBase.set(true);
                }
            } finally {
                baseCreatorLock.unlock();
            }
        }
        return baseInstance;
    }

    public Terminal acquireTerminal(boolean fragileGoods) {
        Terminal terminal = null;
        try {
            lock.lock();
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(800) + 50);

            Condition condition = lock.newCondition();

            if (freeTerminals.isEmpty()) {
                waitingQueue.addLast(condition);
                condition.await();
            }
            terminal = freeTerminals.removeFirst();

        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "Thread " + Thread.currentThread().getName() + " was interrupted", e);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
        return terminal;
    }

    public void releaseTerminal(Terminal terminal) {

        Condition condition = null;
        lock.lock();
        try {
            freeTerminals.addLast(terminal);
            TimeUnit.MILLISECONDS.sleep(500);

            logger.log(Level.INFO, "Terminal " + terminal.getTerminalId() + " was released");
            condition = waitingQueue.pollFirst();

        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "The thread was interrupted", e);
            Thread.currentThread().interrupt();

        } finally {
            if (condition != null) {
                condition.signal();
            }
            lock.unlock();
        }
    }


    public void addCargo(int inptCapacity) {

        baseCapacityLock.lock();

        try {
            while (this.capacity + inptCapacity > BASE_CAPACITY) {
                waitForDownloadedCapacity.await();
            }
            while (this.capacity + inptCapacity < 0) {
                waitForUploadedCapacity.await();
            }

            this.capacity += inptCapacity;

            if (inptCapacity > 0) {
                waitForUploadedCapacity.signal();
            } else if (inptCapacity < 0) {
                waitForDownloadedCapacity.signal();
            }
        } catch (InterruptedException e) {
            logger.error("The current thread is interrupted", e);
            Thread.currentThread().interrupt();
        } finally {
            baseCapacityLock.unlock();
        }
    }
}