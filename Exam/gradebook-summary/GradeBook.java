/*
 * Spring 2026 CS 3354 Object-Oriented Programming & Design
 * Final Exam - gradebook-summary project
 *
 * Course assessment material. Do not redistribute or post publicly
 * without instructor permission.
 */

import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    private final String courseName;
    private final List<Student> students;

    public GradeBook(String courseName) {
        if (courseName == null || courseName.isBlank()) {
            throw new IllegalArgumentException("Course name cannot be blank.");
        }
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        students.add(student);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public CourseSummary buildSummary() {
        // TODO: Implement this method.
        //
        // The returned CourseSummary should contain:
        // - the number of students
        // - the average score
        // - the highest score
        // - the number of passing students
        //
        // For an empty grade book, return:
        // new CourseSummary(0, 0.0, 0.0, 0)
        return new CourseSummary(0, 0.0, 0.0, 0);
    }
}
