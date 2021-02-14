package org.sahil.unique.number.main;

import org.sahil.unique.number.generator.UniqueNumberGenerator;

import java.util.Set;

public class UniqueNumberApplication {

    public static void main(String[] args) {
        Set<String> uniquePin = UniqueNumberGenerator.generate1000UniqueNumber();
        uniquePin.forEach(System.out::println);
    }
}
