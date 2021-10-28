package exceptions;

public class EmptyFileExpectation extends Throwable{
    public EmptyFileExpectation(String fileName){
        System.err.println("File is empty, "+fileName);
    }
}
