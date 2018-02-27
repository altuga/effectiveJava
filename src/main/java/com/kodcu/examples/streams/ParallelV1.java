package com.kodcu.examples.streams;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;



public class ParallelV1 {

    final static BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) {



        // ilk 20 asal sayiyi ekrana basiyoruz
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))

                .filter(mersenne -> mersenne.isProbablePrime(50))

                .limit(20)

                .forEach(System.out::println);

    }



    static Stream<BigInteger> primes() {
            // siradaki olasi asal sayiyi veriyor
            return Stream.iterate(TWO, BigInteger::nextProbablePrime);

    }
}
