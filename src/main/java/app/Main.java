package app;

import model.Course;
import model.GraduateStudent;
import model.Student;
import service.CourseCatalog;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        CourseCatalog catalog = new CourseCatalog();
        catalog.addCourse(new Course("CENL405", "Computer Network & Security", 5));
        catalog.addCourse(new Course("EENL210", "Signals and Systems", 4));
        catalog.addCourse(new Course("OOP101", "Object Oriented Programming", 6));

       
        Student student = createStudent(sc);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt(sc);

            switch (choice) {
                case 1 -> {
                    System.out.println("\n--- Course Catalog ---");
                    catalog.getCourses().forEach(c ->
                            System.out.println(c.getCode() + " - " + c.getCredits() + " credits")
                    );
                }
                case 2 -> {
                    System.out.print("Enter course code to register: ");
                    String code = sc.nextLine().trim();
                    Course course = catalog.findByCode(code);

                    if (course == null) {
                        System.out.println("Course not found.");
                    } else {
                        boolean added = student.register(course);
                        System.out.println(added ? "Registered successfully." : "Already registered (duplicate prevented).");
                    }
                }
                case 3 -> {
                    System.out.print("Enter course code to drop: ");
                    String code = sc.nextLine().trim();
                    Course course = catalog.findByCode(code);

                    if (course == null) {
                        System.out.println("Course not found.");
                    } else {
                        boolean removed = student.drop(course);
                        System.out.println(removed ? "Dropped successfully." : "You were not registered to this course.");
                    }
                }
                case 4 -> {
                    System.out.println("\n--- Registered Courses ---");
                    if (student.getRegisteredCourses().isEmpty()) {
                        System.out.println("(none)");
                    } else {
                        student.getRegisteredCourses().forEach(c ->
                                System.out.println(c.getCode() + " - " + c.getCredits() + " credits")
                        );
                    }
                }
                case 5 -> System.out.println("Tuition: " + student.calculateTuition());
                case 0 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice.");
            }

            System.out.println();
        }

        sc.close();
    }

    private static Student createStudent(Scanner sc) {
        System.out.println("1) Student");
        System.out.println("2) GraduateStudent");
        System.out.print("Choose student type: ");
        int type = readInt(sc);

        System.out.print("Enter student id: ");
        String id = sc.nextLine().trim();

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        if (type == 2) {
            return new GraduateStudent(id, name);
        }
        return new Student(id, name);
    }

    private static void printMenu() {
        System.out.println("===== Student Course Registration =====");
        System.out.println("1) View course catalog");
        System.out.println("2) Register a course");
        System.out.println("3) Drop a course");
        System.out.println("4) View registered courses");
        System.out.println("5) Calculate tuition");
        System.out.println("0) Exit");
        System.out.print("Select: ");
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }
}
