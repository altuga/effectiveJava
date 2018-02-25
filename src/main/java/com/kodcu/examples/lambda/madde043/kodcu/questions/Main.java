package com.kodcu.examples.lambda.madde043.kodcu.questions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        // TODO use Streams in Java 8

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

       // TODO convert to List of Integer and print


        List<Instant> listOfDates = new ArrayList<>();
        listOfDates.add(Instant.parse("2017-10-23T10:12:35Z"));
        listOfDates.add(Instant.parse("2017-11-23T10:12:35Z"));
        listOfDates.add(Instant.parse("2018-12-23T10:12:35Z"));

        // TODO print smaller then now


        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("HELLO");
        listOfNames.add("AFRICA");
        listOfNames.add("hoW are you do'in");

        // TODO convert to lowercase






    }
}
