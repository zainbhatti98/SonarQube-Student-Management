import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    static List<String> names = new ArrayList<>();
    static List<Integer> marks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int unusedCounter = 0; // Intentional issue: unused variable

        while (true) {
            System.out.println("\n1. Add student");
            System.out.println("2. Show all students");
            System.out.println("3. Average marks");
            System.out.println("4. Highest marks");
            System.out.println("5. Search student");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int x;
            try {
                x = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                // Intentional issue: exception is swallowed
                continue;
            }

            if (x == 1) {
                System.out.print("Student name: ");
                String a = sc.nextLine(); // Intentional issue: poor variable name
                System.out.print("Marks (0-100): ");
                int b;
                try {
                    b = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    continue;
                }
                names.add(a);
                marks.add(b);
                System.out.println("Student added.");
            } else if (x == 2) {
                displayAll();
            } else if (x == 3) {
                int total = 0;
                for (int i = 0; i < marks.size(); i++) {
                    total = total + marks.get(i);
                }
                if (marks.size() > 0) {
                    System.out.println("Average: " + (total / marks.size()));
                } else {
                    System.out.println("No marks available.");
                }
            } else if (x == 4) {
                int highest = -1;
                for (int i = 0; i < marks.size(); i++) {
                    if (marks.get(i) > highest) {
                        highest = marks.get(i);
                    }
                }
                if (highest >= 0) {
                    System.out.println("Highest marks: " + highest);
                } else {
                    System.out.println("No marks available.");
                }
            } else if (x == 5) {
                System.out.print("Enter student name to search: ");
                String searchName = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equalsIgnoreCase(searchName)) {
                        // Intentional issue: duplicated student-display statements
                        System.out.println("Student name: " + names.get(i));
                        System.out.println("Student marks: " + marks.get(i));
                        System.out.println("Result: " + (marks.get(i) >= 50 ? "Pass" : "Fail"));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
            } else if (x == 0) {
                System.out.println("Goodbye.");
                sc.close();
                return;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    static void displayAll() {
        if (names.size() == 0) {
            System.out.println("No students available.");
        }
        for (int i = 0; i < names.size(); i++) {
            // Intentional issue: repeated display logic and hard-coded pass mark
            System.out.println("Student name: " + names.get(i));
            System.out.println("Student marks: " + marks.get(i));
            System.out.println("Result: " + (marks.get(i) >= 50 ? "Pass" : "Fail"));
        }
    }
}
