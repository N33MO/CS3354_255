package module6.math;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MathUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEven_returnsTrueForEvenNumbers(int number) {
        // Arrange
        int input = number;

        // Act
        boolean result = MathUtils.isEven(input);

        // Assert
        assertTrue(result, input + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsEven_returnsFalseForOddNumbers(int number) {
        // Arrange
        int input = number;

        // Act
        boolean result = MathUtils.isEven(input);

        // Assert
        assertFalse(result, input + " should be odd");
    }
}
