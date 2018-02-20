package com.kodcu.examples.venus.trycatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadV5 {

    // try-with-resources with a catch clause

    // Ders cok net : Her zaman try - resource kullanalim

    static String firstLineOfFile(String path, String defaultVal) {

        try (BufferedReader br = new BufferedReader(

                new FileReader(path))) {

            return br.readLine();

        } catch (IOException e) {

            return defaultVal;

        }

    }

}
