/*
 * Spring 2026 CS 3354 Object-Oriented Programming & Design
 * Final Exam - gradebook-summary project
 *
 * Course assessment material. Do not redistribute or post publicly
 * without instructor permission.
 */

public interface ReportPrinter {
    void printRoster(GradeBook gradeBook);

    void printSummary(CourseSummary summary);
}
