package by.sasnouski.multithread.reader;

import by.sasnouski.multithread.exception.BaseMultithreadException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TruckReader {

    private final static Logger logger = LogManager.getLogger();

    public List<String> readData(String filePath) throws BaseMultithreadException {

        List<String> trucksData = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(reader)) {

            while (br.ready()) {
                String line = br.readLine();
                trucksData.add(line);
            }
        } catch (IOException e) {
            logger.log(Level.FATAL, "Error while reading file: " + filePath);
            throw new BaseMultithreadException("Error while reading file: " + filePath, e);
        }

        return trucksData;
    }
}