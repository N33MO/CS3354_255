/*
 * Spring 2026 CS 3354 Object-Oriented Programming & Design
 * Final Exam - gradebook-summary project
 *
 * Course assessment material. Do not redistribute or post publicly
 * without instructor permission.
 */

public class Student {
    private final String name;
    private final double score;

    public Student(String name, double score) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be blank.");
        }
        if (score < 0.0 || score > 100.0) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public boolean isPassing() {
        return score >= 60.0;
    }

    public String getLetterGrade() {
        if (score >= 90.0) {
            return "A";
        }
        if (score >= 80.0) {
            return "B";
        }
        if (score >= 70.0) {
            return "C";
        }
        if (score >= 60.0) {
            return "D";
        }
        return "F";
    }
}
