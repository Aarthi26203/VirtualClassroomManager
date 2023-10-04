package virclass;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Assignment> submittedAssignments;

    public Student(String name) {
        this.name = name;
        this.submittedAssignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void submitAssignment(Assignment assignment) {
        submittedAssignments.add(assignment);
        System.out.println(name + " submitted assignment: " + assignment.getTitle());
    }

    public List<Assignment> getSubmittedAssignments() {
        return submittedAssignments;
    }
}