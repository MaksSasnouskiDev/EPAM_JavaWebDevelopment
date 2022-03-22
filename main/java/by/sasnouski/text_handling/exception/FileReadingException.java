package by.sasnouski.text_handling.exception;

public class FileReadingException extends Exception {

    public FileReadingException() {
        super();
    }

    public FileReadingException(String message) {
        super(message);
    }

    public FileReadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileReadingException(Throwable cause) {
        super(cause);
    }
}