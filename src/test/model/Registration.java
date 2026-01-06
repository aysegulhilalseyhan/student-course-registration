package model;

import java.time.LocalDate;

public class Registration {

    private Student student;
    private Course course;
    private LocalDate registrationDate;

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.registrationDate = LocalDate.now();
    }
}

