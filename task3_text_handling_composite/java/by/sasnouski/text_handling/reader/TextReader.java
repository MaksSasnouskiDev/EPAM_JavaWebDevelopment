package by.sasnouski.text_handling.reader;

import by.sasnouski.text_handling.exception.FileReadingException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TextReader {
    private final Logger logger = LogManager.getLogger();

    public String readText(String filePath) throws FileReadingException {

        String resultString;
        Reader reader = null;
        StringBuilder sb;

        try {
            reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
            sb = new StringBuilder();

            while (br.ready()) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while reading file", e);
            throw new FileReadingException("Error while reading file: " + filePath);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                logger.log(Level.ERROR, "Error while reading file", e);
            }
        }
        resultString = sb.toString();

        return resultString;
    }
}