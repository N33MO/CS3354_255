/*
 * Spring 2026 CS 3354 Object-Oriented Programming & Design
 * Final Exam - gradebook-summary project
 *
 * Course assessment material. Do not redistribute or post publicly
 * without instructor permission.
 */

public class CourseSummary {
    private final int studentCount;
    private final double averageScore;
    private final double highestScore;
    private final int passingCount;

    public CourseSummary(int studentCount, double averageScore, double highestScore, int passingCount) {
        this.studentCount = studentCount;
        this.averageScore = averageScore;
        this.highestScore = highestScore;
        this.passingCount = passingCount;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public double getHighestScore() {
        return highestScore;
    }

    public int getPassingCount() {
        return passingCount;
    }
}
