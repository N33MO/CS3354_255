/*
 * Spring 2026 CS 3354 Object-Oriented Programming & Design
 * Final Exam - gradebook-summary project
 *
 * Course assessment material. Do not redistribute or post publicly
 * without instructor permission.
 */

public class ConsoleReportPrinter implements ReportPrinter {
    @Override
    public void printRoster(GradeBook gradeBook) {
        System.out.println("Course: " + gradeBook.getCourseName());
        System.out.println("Roster:");

        for (Student student : gradeBook.getStudents()) {
            System.out.printf(
                "- %s: %.1f (%s)%n",
                student.getName(),
                student.getScore(),
                student.getLetterGrade()
            );
        }
    }

    @Override
    public void printSummary(CourseSummary summary) {
        System.out.println();
        System.out.println("Summary:");
        System.out.println("Student count: " + summary.getStudentCount());
        System.out.printf("Average score: %.2f%n", summary.getAverageScore());
        System.out.printf("Highest score: %.1f%n", summary.getHighestScore());
        System.out.println("Passing students: " + summary.getPassingCount());
    }
}
