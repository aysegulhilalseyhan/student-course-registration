package interfaces;

import model.Course;

public interface Registrable {
    boolean register(Course course);
    boolean drop(Course course);
}
