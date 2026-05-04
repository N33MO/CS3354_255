/*
 * Spring 2026 CS 3354 Object-Oriented Programming & Design
 * Final Exam - gradebook-summary project
 *
 * Course assessment material. Do not redistribute or post publicly
 * without instructor permission.
 */

public class Main {
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook("CS 3354");
        gradeBook.addStudent(new Student("Nova Byte", 92.5));
        gradeBook.addStudent(new Student("Pixel Loop", 88.0));
        gradeBook.addStudent(new Student("Cedar Stack", 59.5));
        gradeBook.addStudent(new Student("Delta Vector", 73.0));
        gradeBook.addStudent(new Student("Echo Lambda", 100.0));

        ReportPrinter printer = new ConsoleReportPrinter();
        printer.printRoster(gradeBook);
        printer.printSummary(gradeBook.buildSummary());
    }
}
