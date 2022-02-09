package by.sasnouski.array.parser;

import java.util.*;
import by.sasnouski.array.reader.ReadDataFromFile;
import by.sasnouski.array.validator.Validator;
import org.apache.logging.log4j.*;

public class StringParser {

    static Logger logger = LogManager.getLogger(StringParser.class);

    public static Double[][] createNumbersArray() {

        ArrayList<String> listOfLinesFromSrcFile = ReadDataFromFile.readData();
        List<List<Double>> listOfArrays = new ArrayList<>();
        Double[][] resultArrays;

        //Парсим и валидируем исходные строки, преобразуем их в Лист числовых массивов.
        for (int i = 0; i < listOfLinesFromSrcFile.size(); i++) {
            ArrayList<Double> tempDoubleList;
            boolean isValidString;
            String tempString = listOfLinesFromSrcFile.get(i);

            tempString = tempString.replaceAll("[\\p{Punct}&&[^.-]]|\\r|\\n", " ");

            isValidString = Validator.isValidString(tempString);

            if (isValidString) {
                ArrayList<String> tempStringList = new ArrayList<>(List.of(tempString.split("[\\s+]")));
                for (int j = 0; j < tempStringList.size(); j++) {
                    if (tempStringList.get(j).isBlank()) {
                        tempStringList.set(j, null);
                    }
                }
                tempStringList.removeIf(Objects::isNull);
                tempDoubleList = new ArrayList<>(tempStringList.size());

                for (String s : tempStringList) {
                    isValidString = Validator.isValidNumber(s);
                    if (isValidString) {
                        Double dbl = Double.parseDouble(s);
                        tempDoubleList.add(dbl);
                    } else {
                        logger.log(Level.WARN, "Строка текста \"" + tempString +
                                "\" не является массивом чисел.");
                        tempDoubleList=null;
                        break;
                    }
                }
            } else {
                logger.log(Level.WARN, "Строка текста \"" + tempString +
                        "\" не является массивом чисел.");
                tempDoubleList=null;
            }
            if (tempDoubleList != null) {
                listOfArrays.add(tempDoubleList);
            }
        }

        resultArrays = new Double[listOfArrays.size()][];

        //Преобразуем полученный Лист числовых массивов в итоговый двумерный массив
        for (int i = 0; i < resultArrays.length; i++) {
            resultArrays[i] = new Double[listOfArrays.get(i).size()];
            for (int j = 0; j < resultArrays[i].length; j++) {
                resultArrays[i][j] = listOfArrays.get(i).get(j);
            }
        }
        return resultArrays;
    }
}