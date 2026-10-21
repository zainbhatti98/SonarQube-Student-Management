import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static final int PASS_MARKS = 50;
    private static final int MIN_MARKS = 0;
    private static final int MAX_MARKS = 100;

    private static final List<String> names = new ArrayList<>();
    private static final List<Integer> marks = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();
                int choice = readInteger(scanner, "Choose: ");
                switch (choice) {
                    case 1 -> addStudent(scanner);
                    case 2 -> displayAll();
                    case 3 -> showAverage();
                    case 4 -> showHighest();
                    case 5 -> searchStudent(scanner);
                    case 0 -> {
                        System.out.println("Goodbye.");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add student");
        System.out.println("2. Show all students");
        System.out.println("3. Average marks");
        System.out.println("4. Highest marks");
        System.out.println("5. Search student");
        System.out.println("0. Exit");
    }

    private static int readInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Student name: ");
        String studentName = scanner.nextLine().trim();
        if (studentName.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        int studentMarks = readInteger(scanner, "Marks (0-100): ");
        if (studentMarks < MIN_MARKS || studentMarks > MAX_MARKS) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        names.add(studentName);
        marks.add(studentMarks);
        System.out.println("Student added.");
    }

    private static void displayAll() {
        if (names.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (int index = 0; index < names.size(); index++) {
            displayStudent(index);
        }
    }

    private static void displayStudent(int index) {
        System.out.println("Student name: " + names.get(index));
        System.out.println("Student marks: " + marks.get(index));
        String result = marks.get(index) >= PASS_MARKS ? "Pass" : "Fail";
        System.out.println("Result: " + result);
    }

    private static void showAverage() {
        if (marks.isEmpty()) {
            System.out.println("No marks available.");
            return;
        }

        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        double average = (double) total / marks.size();
        System.out.printf("Average: %.2f%n", average);
    }

    private static void showHighest() {
        if (marks.isEmpty()) {
            System.out.println("No marks available.");
            return;
        }

        int highest = marks.get(0);
        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        System.out.println("Highest marks: " + highest);
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student name to search: ");
        String searchName = scanner.nextLine().trim();

        for (int index = 0; index < names.size(); index++) {
            if (names.get(index).equalsIgnoreCase(searchName)) {
                displayStudent(index);
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
