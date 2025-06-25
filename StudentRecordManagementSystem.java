import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentRecordManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("---Student Record Management System---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    public static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, marks);
        studentList.add(s);
        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("All Student Records:");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    public static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        boolean found = false;

        for (Student s : studentList) {
            if (s.id == id) {
                System.out.print("Enter new name: ");
                s.name = sc.nextLine();
                System.out.print("Enter new marks: ");
                s.marks = sc.nextDouble();
                found = true;
                System.out.println("Student updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = studentList.removeIf(s -> s.id == id);

        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}

