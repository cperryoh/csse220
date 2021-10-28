package fileIO;

import exceptions.MissingGradeException;
import exceptions.NegativeGradeException;

import java.io.FileNotFoundException;

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
            average = GradeFileReader.readGradeFile("grades/" + email + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MissingGradeException e) {
            e.printPlace();
        } catch (NegativeGradeException e) {
            e.printPlace();
        }
    }

    public int getAverage() {
        return 0;
    }

    /**
     * *NOTE: A letter grade is calculated as follows:
     * 90.0 < A < 100.0
     * 80.0 < B < 90.0
     * 70.0 < C < 80.0
     * 60.0 < D < 70.0
     * F < 60.0
     */
    public void setAverage(double average) {
        this.average = average;
        if(average>90){
            grade="A";
        }else if(average>80){
            grade="B";
        }else if(average>70){
            grade="C";
        }else if(average>60){
            grade="D";
        }else{
            grade="F";
        }
    }

    @Override
    public String toString() {
        //last,first,email,average,letterGrade
        return last + "," + first + "," + email + "," + getAverage() + "," + grade;
    }
}
