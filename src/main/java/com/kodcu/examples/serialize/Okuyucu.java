package com.kodcu.examples.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Okuyucu {

    public static void main(String[] args) throws Exception{

        FileInputStream fi = new FileInputStream(new File("nesneler.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        Calisan pr1 = (Calisan) oi.readObject();
        Calisan pr2 = (Calisan) oi.readObject();

        System.out.println(pr1.toString());
        System.out.println(pr2.toString());

        oi.close();
        fi.close();
    }
}
