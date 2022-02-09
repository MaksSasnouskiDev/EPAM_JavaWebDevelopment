package by.sasnouski.array.reader;

import org.apache.logging.log4j.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadDataFromFile {
    static Logger logger = LogManager.getLogger(ReadDataFromFile.class);

    public static ArrayList<String> readData() {

        ArrayList<String> listOfLines = new ArrayList<>();
        try (FileReader reader = new FileReader("src/main/resources/DataFile.txt");
             BufferedReader br = new BufferedReader(reader)) {

            /*Создаём Лист из строк файла, каждую строку помещаем в Список как
             *  отдельный элемент*/
            while (br.ready()) {
                StringBuilder sb = new StringBuilder();
                char tempChar;
                do {
                    tempChar = (char) br.read();
                    sb.append(tempChar);
                    if (!br.ready()) {
                        break;
                    }
                } while (tempChar != '\r');

                if (!sb.toString().isBlank()) {
                    listOfLines.add(sb.toString());
                }
            }
        } catch (IOException e) {
            logger.log(Level.FATAL, "Error while reading file!\n", e);
            System.exit(-1);
        }
        return listOfLines;
    }
}