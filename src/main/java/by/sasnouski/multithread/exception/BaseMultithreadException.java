package by.sasnouski.multithread.exception;

public class BaseMultithreadException extends Exception{
    public BaseMultithreadException(){
    }
    public BaseMultithreadException(String message){
        super(message);
    }
    public BaseMultithreadException(Throwable cause){
        super(cause);
    }
    public BaseMultithreadException(String message, Throwable cause){
        super(message, cause);
    }
}