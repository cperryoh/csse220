package exceptions;

public class EmptyFileExpectation extends Throwable{
    EmptyFileExpectation(String fileName){
        System.out.println("File is empty, "+fileName);
    }
}
