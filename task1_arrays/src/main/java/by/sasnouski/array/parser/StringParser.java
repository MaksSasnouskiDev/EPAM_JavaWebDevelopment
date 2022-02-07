package by.sasnouski.array.parser;

import java.util.*;

import by.sasnouski.array.reader.ReadDataFromFile;
import by.sasnouski.array.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringParser {
    private static final Logger logger = LogManager.getLogger(StringParser.class);

    public static Double[][] createNumbersArray() {
        ArrayList<String> listOfLines = ReadDataFromFile.readData();
        Double[][] resultArrays;
        boolean isValidString;

        //Парсим и валидируем исходные строки.
        for (int i = 0; i < listOfLines.size(); i++) {
            String tempString = listOfLines.get(i);
            tempString = tempString.replaceAll("[\\p{Punct}&&[^.-]]|\\r|\\n", " ");
            isValidString = Validator.isValidString(tempString);
            if (!isValidString) {
                logger.error("Строка текста \"" + tempString + "\" не является массивом чисел.");
                tempString = "";
                listOfLines.set(i, tempString);
            } else {
                listOfLines.set(i, tempString);
            }
        }
        listOfLines.removeIf(String::isBlank);
        resultArrays = new Double[listOfLines.size()][];

        //Разбиваем исходные строки, преобразуем строки в массив чисел.
        for (int i = 0; i < listOfLines.size(); i++) {
            ArrayList<String> tempStringList = new ArrayList<>(List.of(listOfLines.get(i).split("[ +]")));

            for (int j = 0; j < tempStringList.size(); j++) {
                if (tempStringList.get(j).isBlank()) {
                    tempStringList.set(j, null);
                }
            }
            tempStringList.removeIf(Objects::isNull);

            ArrayList<Double> tempDoubleList = new ArrayList<>(tempStringList.size());
            for (String s : tempStringList) {
                Double dbl = Double.parseDouble(s);
                tempDoubleList.add(dbl);
            }
            resultArrays[i] = new Double[tempDoubleList.size()];
            for (int j = 0; j < resultArrays[i].length; j++) {
                resultArrays[i][j] = tempDoubleList.get(j);
            }
        }
        for (Double[] arr : resultArrays) {
            System.out.println(Arrays.toString(arr));
        }
        return resultArrays;
    }
}