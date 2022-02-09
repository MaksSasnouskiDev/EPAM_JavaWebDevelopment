package by.sasnouski.array.exception;


public class ReadingFileException extends Exception {
    public ReadingFileException() {
    }

    public ReadingFileException(String message) {
        super(message);
    }

    public ReadingFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadingFileException(Throwable cause) {
        super(cause);
    }
}