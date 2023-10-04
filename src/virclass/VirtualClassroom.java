package virclass;

import java.util.Scanner;

class VirtualClassroom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Classroom virtualClassroom = null;

        while (true) {
            System.out.println("Virtual Classroom Menu:");
            System.out.println("1. Create Classroom");
            System.out.println("2. Add Student");
            System.out.println("3. Schedule Assignment");
            System.out.println("4. Submit Assignment");
            System.out.println("5. Display Class Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the classroom: ");
                    String className = scanner.next();
                    virtualClassroom = new Classroom(className);
                    System.out.println("Classroom ["+className+"] has been created.");
                    break;

                case 2:
                    if (virtualClassroom != null) {
                        System.out.print("Enter the name of the student: ");
                        String studentName = scanner.next();
                        virtualClassroom.addStudent(new Student(studentName));
                        System.out.println("Student ["+studentName+"] has been enrolled in  ["+virtualClassroom.getClassName()+"]");
                    } else {
                        System.out.println("Please create a classroom first.");
                    }
                    break;

                case 3:
                    if (virtualClassroom != null) {
                        System.out.print("Enter the title of the assignment: ");
                        String assignmentTitle = scanner.next();
                        System.out.print("Enter the content of the assignment: ");
                        String assignmentContent = scanner.next();
                        virtualClassroom.scheduleAssignment(new Assignment(assignmentTitle, assignmentContent));
                        System.out.println("Assignment for ["+virtualClassroom.getClassName()+"] has been scheduled: ");
                    } else {
                        System.out.println("Please create a classroom first.");
                    }
                    break;

                case 4:
                    if (virtualClassroom != null) {
                        System.out.print("Enter the name of the student submitting the assignment: ");
                        String studentName = scanner.next();
                        Student student = virtualClassroom.getStudentByName(studentName);
                        if (student != null) {
                            System.out.print("Enter the title of the assignment to submit: ");
                            String assignmentTitle = scanner.next();
                            Assignment assignment = virtualClassroom.getAssignmentByTitle(assignmentTitle);
                            if (assignment != null) {
                                student.submitAssignment(assignment);
                            } else {
                                System.out.println("Assignment not found.");
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                    } else {
                        System.out.println("Please create a classroom first.");
                    }
                    break;

                case 5:
                    if (virtualClassroom != null) {
                        virtualClassroom.displayClassInfo();
                    } else {
                        System.out.println("Please create a classroom first.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the virtual classroom.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
