package exception;

public class InvalidData extends Exception {

    public InvalidData(String errorMessage){
        super(errorMessage);
    }
}
