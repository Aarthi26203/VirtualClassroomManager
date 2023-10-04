package virclass;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Classroom {
    private String className;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public Student getStudentByName(String studentName) {
        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                return student;
            }
        }
        return null;
    }

    public Assignment getAssignmentByTitle(String assignmentTitle) {
        for (Assignment assignment : assignments) {
            if (assignment.getTitle().equals(assignmentTitle)) {
                return assignment;
            }
        }
        return null;
    }

    public void displayClassInfo() {
        System.out.println("Class: " + className);
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
        System.out.println("Assignments:");
        for (Assignment assignment : assignments) {
            System.out.println("- " + assignment.getTitle());
        }
    }
}