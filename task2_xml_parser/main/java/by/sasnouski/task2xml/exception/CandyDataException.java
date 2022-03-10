package by.sasnouski.task2xml.exception;

public class CandyDataException extends Exception{

    public CandyDataException() {
        super();
    }

    public CandyDataException(String message) {
        super(message);
    }

    public CandyDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public CandyDataException(Throwable cause) {
        super(cause);
    }
}
