package by.sasnouski.text_handling.main;

import by.sasnouski.text_handling.exception.FileReadingException;
import by.sasnouski.text_handling.reader.TextReader;

public class Main1 {
    public static void main(String[] args) throws FileReadingException {
        String s;
        TextReader obj=new TextReader();
        s=obj.readText("src/main/resources/text.txt");
        System.out.println(s);
    }
}