package exceptions;

	//you will need to write a MissingGradeException class
  //BE CAREFUL, you will need fields and methods to access
  //those fields, and exception classes work just about
  //like any other class other than the fact that they're 
  //thrown

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MissingGradeException extends Throwable {
    int index;
    int line;
    String file;
    public MissingGradeException(int index, int line,String file){
        this.file=file;
        this.index=index;
        this.line=line;
        printPlace();
    }
    public String getFileTxt(){
        try {
            Scanner scn = new Scanner(new File(file));
            String out = "";
            while(scn.hasNext()){
                out+=scn.nextLine()+'\n';
            }
            scn.close();
            return out;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }

    }

    public int getIndex() {
        return index;
    }

    public int getLine() {
        return line;
    }

    public void printPlace(){
        System.err.println("Missing grade Line: "+line+" Index: "+index+" File: "+file+"\n");
        //System.err.println(getFileTxt());
    }
}