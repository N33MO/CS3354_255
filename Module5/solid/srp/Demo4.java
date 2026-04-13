package Module5.solid.srp;

public class Demo4 {
    
}

// BEFORE
class StudentRecord {

    public double calculateGPA() {
        return grades.stream()
            .mapToDouble(Grade::getScore).average().orElse(0.0);
    }

    public void saveToDatabase() {
        db.save(this);
    }

    public void printTranscript() {
        System.out.println("Student: " + name + ", GPA: " + calculateGPA());
    }

    public void sendNotification() {
        emailClient.send(email, "Your transcript is ready.");
    }
}

// AFTER
// owned by: academics
class StudentRecord {
    public double calculateGPA() {
    return grades.stream()
        .mapToDouble(Grade::getScore).average().orElse(0.0);
    }
}
// owned by: IT/DBA
class StudentRepository {
    public void save(StudentRecord student) {
        db.save(student);
    }
}
// owned by: registrar
class TranscriptPrinter {
    public void print(
        StudentRecord s) {
        System.out.println(
            "Student: " + s.getName()+ ", GPA: " + s.calculateGPA()
        );
    }
}
// owned by: communications
class NotificationService {
    public void notify(StudentRecord s) {
        emailClient.send(s.getEmail(),"Your transcript is ready.");
    }
}