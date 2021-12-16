package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        readCat("kitty");
    }
    public static Cat readCat(String fileName) throws FileNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream(fileName+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Cat e = (Cat) in.readObject();
            in.close();
            fileIn.close();
            System.out.println(e);
            return e;
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
        throw new FileNotFoundException();
    }
    public static void serializeCat(String name, int age){
        try {
            Cat e = new Cat(name,age);
            FileOutputStream fileOut =
                    new FileOutputStream(name+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
