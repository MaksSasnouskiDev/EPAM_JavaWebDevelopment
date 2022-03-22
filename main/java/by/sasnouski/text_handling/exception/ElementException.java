package by.sasnouski.text_handling.exception;

public class ElementException extends Exception {

    public ElementException() {
        super();
    }

    public ElementException(String message) {
        super(message);
    }

    public ElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementException(Throwable cause) {
        super(cause);
    }
}