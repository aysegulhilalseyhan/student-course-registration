package app;

import model.*;
import service.CourseCatalog;

public class Main {

    public static void main(String[] args) {

        Course math = new Course("MATH101", "Mathematics", 4);
        Course cs = new Course("CS101", "Computer Science", 5);

        CourseCatalog catalog = new CourseCatalog();
        catalog.addCourse(math);
        catalog.addCourse(cs);

        Student student = new GraduateStudent("1", "Aysegul");
        student.register(math);
        student.register(cs);

        System.out.println("Tuition: " + student.calculateTuition());
    }
}
