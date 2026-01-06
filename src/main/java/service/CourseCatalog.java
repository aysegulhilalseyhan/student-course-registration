package service;

import model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {

    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public Course findByCode(String code) {
        for (Course c : courses) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
