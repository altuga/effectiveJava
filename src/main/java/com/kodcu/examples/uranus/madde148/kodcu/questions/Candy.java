
package com.kodcu.examples.uranus.madde148.kodcu.questions;


public class Candy {


    public static void main(String[] args) {
        double para = 1.00;
        int alinanSekersayisi = 0;
        for (double fiyat = .10; para >= fiyat; fiyat += .10) {
            para -= fiyat;
            alinanSekersayisi++;
        }
        System.out.println(alinanSekersayisi + " seker alindi.");
        System.out.println("Para ustu:  " + para + " TL");

        //System.out.println(1.8 - 0.83);
    }
}
