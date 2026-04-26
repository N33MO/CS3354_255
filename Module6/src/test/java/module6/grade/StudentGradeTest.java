package module6.grade;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit 6 tests for StudentGrade.
 *
 * This class is useful for demonstrating:
 * - basic @Test methods
 * - assertEquals() for return values
 * - boundary testing
 * - exception testing
 */
class StudentGradeTest {
    private static final double DELTA = 0.0001;

    @Test
    void constructor_shouldStoreStudentNameScoreAndLetterGrade() {
        // Arrange
        StudentGrade student = null;
        assertNull(student);

        student = new StudentGrade("Jordan", 92.5);
        assertNotNull(student);

        // Act
        String name = student.getName();
        double score = student.getScore();
        String letterGrade = student.getLetterGrade();

        // Assert
        assertAll(
            () -> assertNotNull(name),
            () -> assertEquals("Jordan", name),
            () -> assertFalse(name.isBlank()),
            () -> assertEquals(92.5, score, DELTA),
            () -> assertEquals("A", letterGrade)
        );
    }

    @Test
    void constructor_shouldThrowExceptionWhenNameIsNull() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StudentGrade(null, 85.0)
        );

        assertEquals("Student name cannot be null or blank.", exception.getMessage());
    }

    @Test
    void constructor_shouldThrowExceptionWhenNameIsBlank() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StudentGrade("   ", 85.0)
        );

        assertEquals("Student name cannot be null or blank.", exception.getMessage());
    }

    @Test
    void constructor_shouldThrowExceptionWhenScoreIsBelowZero() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StudentGrade("Jordan", -1.0)
        );

        assertEquals("Score must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void constructor_shouldThrowExceptionWhenScoreIsAbove100() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StudentGrade("Jordan", 101.0)
        );

        assertEquals("Score must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void isPassing_shouldReturnTrueForScoreAtOrAbove60() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 60.0);

        // Act and Assert
        assertTrue(student.isPassing());
    }

    @Test
    void isPassing_shouldReturnFalseForScoreBelow60() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 59.99);

        // Act and Assert
        assertFalse(student.isPassing());
    }

    @Test
    void getLetterGrade_shouldReturnAFor90AndAbove() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 92.5);

        // Act and Assert
        assertAll(
            () -> assertEquals("A", student.getLetterGrade(90.0)),
            () -> assertEquals("A", student.getLetterGrade(95.5)),
            () -> assertEquals("A", student.getLetterGrade(100.0))
        );
    }

    @Test
    void getLetterGrade_shouldReturnBFor80To89Point99() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 85.0);

        // Act and Assert
        assertAll(
            () -> assertEquals("B", student.getLetterGrade(80.0)),
            () -> assertEquals("B", student.getLetterGrade(89.99))
        );
    }

    @Test
    void getLetterGrade_shouldReturnCFor70To79Point99() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 75.0);

        // Act and Assert
        assertAll(
            () -> assertEquals("C", student.getLetterGrade(70.0)),
            () -> assertEquals("C", student.getLetterGrade(79.99))
        );
    }

    @Test
    void getLetterGrade_shouldReturnDFor60To69Point99() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 65.0);

        // Act and Assert
        assertAll(
            () -> assertEquals("D", student.getLetterGrade(60.0)),
            () -> assertEquals("D", student.getLetterGrade(69.99))
        );
    }

    @Test
    void getLetterGrade_shouldReturnFForBelow60() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 55.0);

        // Act
        String grade = student.getLetterGrade(59.99);

        // Assert
        assertAll(
            () -> assertEquals("F", grade),
            () -> assertTrue(grade.equals("F"))
        );
    }

    @Test
    void getLetterGrade_shouldThrowExceptionWhenScoreIsBelowZero() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 85.0);

        // Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.getLetterGrade(-1.0)
        );

        assertEquals("Score must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void getLetterGrade_shouldThrowExceptionWhenScoreIsAbove100() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 85.0);

        // Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.getLetterGrade(101.0)
        );

        assertEquals("Score must be between 0 and 100.", exception.getMessage());
    }
}
