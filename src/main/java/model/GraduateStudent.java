package model;

public class GraduateStudent extends Student {

    public GraduateStudent(String id, String name) {
        super(id, name);
    }

    @Override
    public double calculateTuition() {
        return registeredCourses.size() * 1500;
    }
}
