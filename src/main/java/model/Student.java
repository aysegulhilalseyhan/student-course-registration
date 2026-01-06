package model;

import interfaces.Registrable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Registrable {

    protected String id;
    protected String name;
    protected Set<Course> registeredCourses = new HashSet<>();

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean register(Course course) {
        return registeredCourses.add(course); 
    }

    @Override
    public boolean drop(Course course) {
        return registeredCourses.remove(course);
    }

    public double calculateTuition() {
        return registeredCourses.size() * 1000;
    }
}
