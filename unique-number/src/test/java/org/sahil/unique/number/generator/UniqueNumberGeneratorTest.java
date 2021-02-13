package org.sahil.unique.number.generator;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueNumberGeneratorTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void test_1000_unique_numbers() {
        Set<String> actual = UniqueNumberGenerator.generate1000UniqueNumber();

        assertThat(actual.size()).isEqualTo(1000);

        for (String randomNumber : actual) {
            try {
                assertTrue(is4DigitNumber(randomNumber));
                assertFalse(hasConsecutiveNumberSequence(randomNumber));
                assertFalse(hasSameNumberSequence(randomNumber));
            } catch (Throwable t) {
                collector.addError(t);
            }
        }
    }

    private boolean hasConsecutiveNumberSequence(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) + 1 == s.charAt(i + 1)) {
                logger.error("{} has Consecutive Number Sequence ", s);
                return true;
            }
        }
        return false;
    }

    private boolean hasSameNumberSequence(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                logger.error("{} has Same Number Sequence ", s);
                return true;
            }
        }
        return false;
    }

    private boolean is4DigitNumber(String s) {
        return s.length() == 4;
    }

}