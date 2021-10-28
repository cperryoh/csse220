package fileIO;

import exceptions.MissingGradeException;
import exceptions.NegativeGradeException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Person {
    String first;
    String last;
    String grade;
    String email;
    double average;
    public Person(String first, String last, String email) {
        this.first = first;
        this.last = last;
        this.email = email;
        try {
            average=GradeFileReader.readGradeFile("grades/"+email+".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MissingGradeException e) {
            e.printPlace();
        } catch (NegativeGradeException e) {
            e.printPlace();
        }
    }
    public int getAverage(){
        return 0;
    }
    @Override
    public String toString() {
        //last,first,email,average,letterGrade
        return  last+","+first+","+email+","+getAverage()+","+grade;
    }
}
