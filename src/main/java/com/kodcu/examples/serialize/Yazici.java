package com.kodcu.examples.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Yazici {

    public static void main(String[] args) {

        Calisan efe = new Calisan("Efe", 15, "Male");
        Calisan mehmet = new Calisan("Mehmet", 45, "Male");

        try {
            FileOutputStream f = new FileOutputStream(new File("nesneler.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(efe);
            o.writeObject(mehmet);


            f.close();
            o.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

    }

}