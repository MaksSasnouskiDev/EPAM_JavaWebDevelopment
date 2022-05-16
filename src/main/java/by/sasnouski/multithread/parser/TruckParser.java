package by.sasnouski.multithread.parser;

import by.sasnouski.multithread.entity.Truck;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TruckParser {

    private static final Logger logger = LogManager.getLogger();

    private static final String TRUCK_DATA_SPLITTER = ",\\s*";
    private static final String EQUALS_SIGN = "=";
    private static final String NUMBER_PATTERN = "\\d+";

    private static final String TRUE_PATTERN = "true";

    private static final int ATTR_AMOUNT = 5;


    public List<Truck> parseTrucks(List<String> inputData) {

        List<Truck> truckList = new ArrayList<>();

        for (String string : inputData) {

            Truck truck;

            int id;
            int truckTonnage;
            int cargoWeight;
            boolean isLoadedTruck;
            boolean isFragileCargo;

            List<String> truckAttrs = new ArrayList<>(List.of(string.split(TRUCK_DATA_SPLITTER)));

            if (truckAttrs.size() != ATTR_AMOUNT) {

                logger.log(Level.ERROR, "Error while parsing truck instance.");
                truck = new Truck(0, 0, 0, false, false);

            } else {
                id = defineInteger(truckAttrs.get(0));
                truckTonnage = defineInteger(truckAttrs.get(1));
                cargoWeight = defineInteger(truckAttrs.get(2));
                isLoadedTruck = defineBoolean(truckAttrs.get(3));
                isFragileCargo = defineBoolean(truckAttrs.get(4));

                truck = new Truck(id, truckTonnage, cargoWeight, isLoadedTruck, isFragileCargo);
            }

            truckList.add(truck);
        }

        return truckList;
    }


    public int defineInteger(String inputString) {

        int resultNmb;
        String numberStr = "";
        String s;

        String[] strings = inputString.split(EQUALS_SIGN);

        s = strings[1];

        Pattern p = Pattern.compile(NUMBER_PATTERN);
        Matcher m = p.matcher(s);


        if (m.find()) {
            numberStr = m.group();
        }

        try {
            resultNmb = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            logger.log(Level.ERROR, "Error while parsing data: " + inputString);
            resultNmb = -1;
        }

        return resultNmb;
    }


    public boolean defineBoolean(String inputString) {

        boolean resultBool = false;
        String s;

        String[] strings = inputString.split(EQUALS_SIGN);

        s = strings[1];

        Pattern p = Pattern.compile(TRUE_PATTERN);
        Matcher m = p.matcher(s);

        if (m.find()) {
            resultBool = true;
        }

        return resultBool;
    }
}