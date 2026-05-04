# GradeBook Summary

Welcome. This is a small Java project for the CS 3354 255 final exam coding task.

The project already compiles and runs. Your job is to complete one TODO method in `GradeBook.java`:

```java
public CourseSummary buildSummary()
```

You should expect to write fewer than 20 lines of code. You do not need to redesign the project or change the other classes.

## What the Project Does

This project creates a simple grade book for a course. It stores a list of `Student` objects, prints the roster, and then prints a course summary.

Right now, the roster works correctly, but the summary still shows placeholder values because `buildSummary()` has not been fully implemented yet.

## Your Task

Open `GradeBook.java` and implement `buildSummary()` so that it returns a `CourseSummary` containing:

- the number of students
- the average score
- the highest score
- the number of passing students

A passing score is `60.0` or higher.

For an empty grade book, return:

```java
new CourseSummary(0, 0.0, 0.0, 0)
```

## A Small Hint

You will probably want to loop through the list of students, read each student's score, and keep track of the values needed for the summary.

The `Student` class already has helpful methods such as:

```java
getScore()
isPassing()
```

## Compile and Run

From this folder, compile the project:

```bash
javac *.java
```

Then run it:

```bash
java Main
```

After your method is implemented, the summary output should show the correct student count, average score, highest score, and number of passing students.

## Canvas Submission

Paste your implementation of `buildSummary()` into the answer box on Canvas.
