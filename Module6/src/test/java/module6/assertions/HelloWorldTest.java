package module6.assertions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HelloWorldTest {

    @Test
    void testAssertArrayEquals_matchesEqualArrays() {
        char[] expected = {'J', 'u', 'p', 'i', 't', 'e', 'r'};
        char[] actual = "Jupiter".toCharArray();

        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    void testAssertTrue_validatesExpectedConditions() {
        assertTrue(5 > 4, "5 is greater than 4");
        assertTrue(null == null, "null is equal to null");
    }

    @Test
    void testAssertSame_distinguishesObjectReferences() {
        HelloWorld tester1 = new HelloWorld();
        HelloWorld tester2 = new HelloWorld();

        assertSame(tester1, tester1);
        assertNotSame(tester1, tester2);
    }

    @Test
    void testAssertNotNull_acceptsInstantiatedObject() {
        HelloWorld tester = new HelloWorld();

        assertNotNull(tester, "The tester should not be null");
    }

    @Test
    void testAssertNull_acceptsNullReference() {
        HelloWorld tester = null;

        assertNull(tester, "The tester should be null");
    }

    @Disabled("Intentional failure example kept for classroom discussion")
    @Test
    void testFail_demonstratesIntentionalFailure() {
        fail("Intentional failure example");
    }

    @Test
    void testAssertAll_groupsMultipleAssertions() {
        HelloWorld tester1 = new HelloWorld();

        assertAll(
            "heading",
            () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
            () -> assertEquals("java", "JAVA".toLowerCase()),
            () -> assertSame(tester1, tester1, "Object references should match")
        );
    }

    @Test
    void testAssertIterableEquals_matchesEquivalentLists() {
        Iterable<String> al = new ArrayList<>(Arrays.asList("Java", "Junit", "Test"));
        Iterable<String> ll = new LinkedList<>(Arrays.asList("Java", "Junit", "Test"));

        assertIterableEquals(al, ll);
    }

    @Test
    void testAssertNotEquals_rejectsDifferentValues() {
        Integer value = 5;

        assertNotEquals(0, value, "The result cannot be 0");
    }

    @Test
    void testAssertThrows_catchesNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("One"));
    }

    @Test
    void testAssertTimeout_completesWithinExpectedDuration() {
        assertTimeout(Duration.ofSeconds(2), () -> Thread.sleep(1000));
    }
}
