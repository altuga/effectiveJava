package com.kodcu.examples.streams;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;


public class ParallelV2 {

    final static BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) {



        long result = pi(1_000_0000);
        System.out.println("Result : " + result );

    }


    /**
     *
     * @param n limit
     * @return number of primes
     */
    static long pi(long n) {

        return LongStream.rangeClosed(2, n)

                .mapToObj(BigInteger::valueOf)

                .filter(i -> i.isProbablePrime(50))

                .count();

    }
}
