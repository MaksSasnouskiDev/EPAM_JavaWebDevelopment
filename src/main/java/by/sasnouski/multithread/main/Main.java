package by.sasnouski.multithread.main;

import by.sasnouski.multithread.entity.Truck;
import by.sasnouski.multithread.exception.BaseMultithreadException;
import by.sasnouski.multithread.parser.TruckParser;
import by.sasnouski.multithread.reader.TruckReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String filePath = "src/main/resources/TrucksData.txt";

    public static void main(String[] args) throws BaseMultithreadException {

        List<String> trucksData=null;
        List<Truck> trucks;

        ExecutorService execSrvc;

        ArrayList<Future<String>>futureList=new ArrayList<>();

        TruckReader reader = new TruckReader();
        TruckParser parser = new TruckParser();


        try {
            trucksData=reader.readData(filePath);
        } catch (BaseMultithreadException e) {
            logger.log(Level.FATAL, "Error while reading file: " + filePath);
        }

        if(trucksData!=null) {
            trucks = parser.parseTrucks(trucksData);
        }else{
            logger.log(Level.FATAL, "Error while parsing file: " + filePath);
            throw new BaseMultithreadException("Error while parsing file: " + filePath);
        }


        try {
            execSrvc= Executors.newFixedThreadPool(trucks.size());

            for (Truck truck : trucks) {
                futureList.add(execSrvc.submit(truck));
            }
            execSrvc.shutdown();

            for (Future<String> future : futureList) {
                logger.log(Level.INFO, future.get());
            }
        }catch (InterruptedException e){
            logger.log(Level.ERROR,"The thread was interrupted.",e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            logger.log(Level.ERROR,"Execution exception ", e);
            throw new BaseMultithreadException("Execution exception ", e);
        }
    }

}