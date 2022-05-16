package by.sasnouski.multithread.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Terminal {

    private static final Logger logger = LogManager.getLogger();

    private final int terminalId;

    private final LogisticsBase base;

    public Terminal(int terminalId, LogisticsBase base) {

        this.terminalId = terminalId;
        this.base = base;
    }

    public void serveTruck(Truck truck) {

        Random random = new Random();

        truck.setTruckState(Truck.TruckState.LOADED);

        logger.log(Level.INFO, String.format("Terminal %d started processing " +
                "the truck %d", terminalId, truck.getTruckId()));

        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(600));

        } catch (InterruptedException e) {

            logger.log(Level.ERROR, "Thread was interrupted while sleeping", e);
            Thread.currentThread().interrupt();
        }


        base.addCargo(truck.isLoadedTruck() ? truck.getCargoWeight() : -truck.getCargoWeight());

        truck.setTruckState(Truck.TruckState.FINISHED);

        logger.info(String.format("Berth %d has finished processing " +
                "a ship %d", terminalId, truck.getTruckId()));

    }

    public int getTerminalId() {
        return terminalId;
    }
}