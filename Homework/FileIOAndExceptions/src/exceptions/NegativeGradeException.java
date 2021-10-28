package exceptions;

  //you will need to write a NegativeGradeException class
  //BE CAREFUL, you will need fields and methods to access
  //those fields, and exception classes work just about
  //like any other class other than the fact that they're.
  //thrown

public class NegativeGradeException extends Throwable {
    int index;
    int line;
    String file;
    public NegativeGradeException(int index, int line,String file){
        this.file=file;
        this.index=index;
        this.line=line;
    }
    public void printPlace(){
        System.err.println("Negative grade Line: "+line+" Index: "+index+" File: "+file);
    }
}