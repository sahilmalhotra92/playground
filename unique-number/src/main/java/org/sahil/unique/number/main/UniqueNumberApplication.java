package org.sahil.unique.number.main;

import org.sahil.unique.number.generator.UniqueNumberGenerator;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

public class UniqueNumberApplication {

    public static void main(String[] args) {
        Instant start = Instant.now();
        Set<String> uniquePin = UniqueNumberGenerator.generate1000UniqueNumber();
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
        uniquePin.forEach(System.out::println);
    }
}
