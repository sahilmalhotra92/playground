package org.sahil.unique.number.generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class UniqueNumberGenerator {

    private UniqueNumberGenerator() {
    }

    static Random random = new Random();

    /**
     * Generates 1000 unique 4 digit numbers with different consecutive digit, without any sequence
     *
     * @return
     */
    public static Set<String> generate1000UniqueNumber() {
        Set<String> randomNumber = new HashSet<>();
        while (randomNumber.size() != 1000) {
            randomNumber.add(generateRandomNumberWithNoSameNumberSequenceAndNoConsecutiveSequence());
        }
        return randomNumber;
    }

    /**
     * Generates unique 4 digit numbers with different consecutive digit, without any sequence
     * @return
     */
    private static String generateRandomNumberWithNoSameNumberSequenceAndNoConsecutiveSequence() {
        String randomNumber = randomNumber();
        while (hasConsecutiveNumberSequenceOrSameNumberSequence(randomNumber)) {
            randomNumber = randomNumber();
        }
        return randomNumber;
    }

    /**
     * Generate random 4 digit number
     * @return
     */
    private static String randomNumber() {
        return String.format("%04d", random.nextInt(10000));
    }

    /**
     * Checks the number has different consecutive digit and is without any sequence
     * @param randomNumber
     * @return
     */
    private static boolean hasConsecutiveNumberSequenceOrSameNumberSequence(String randomNumber) {
        for (int i = 0; i < randomNumber.length() - 1; i++) {
            if (randomNumber.charAt(i) + 1 == randomNumber.charAt(i + 1)) {
                return true;
            }
            if (randomNumber.charAt(i) == randomNumber.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

}
