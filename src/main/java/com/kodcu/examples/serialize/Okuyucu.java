package com.kodcu.examples.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Okuyucu {

    public static void main(String[] args) throws Exception{

        FileInputStream fi = new FileInputStream(new File("nesneler.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        Calisan efe = (Calisan) oi.readObject();
        Calisan mehmet = (Calisan) oi.readObject();

        System.out.println(efe.toString());
        System.out.println(mehemt.toString());

        oi.close();
        fi.close();
    }
}
