package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void register_addsCourseAndPreventsDuplicateByCode() {
        Student s = new Student("1", "Aysegul");

        Course c1 = new Course("CENL405", "Networks", 5);
        Course c2 = new Course("CENL405", "Different title", 999);

        assertTrue(s.register(c1));
        assertFalse(s.register(c2));
        assertEquals(1, s.getRegisteredCourses().size());
    }

    @Test
    void drop_removesCourseIfExists() {
        Student s = new Student("1", "Aysegul");
        Course c = new Course("EENL210", "Signals", 4);

        s.register(c);
        assertTrue(s.drop(c));
        assertTrue(s.getRegisteredCourses().isEmpty());
    }

    @Test
void drop_returnsFalseWhenCourseNotRegistered() {
    Student s = new Student("1", "Aysegul");
    assertFalse(s.drop(new Course("X", "X", 1)));
}


    @Test
    void calculateTuition_is1000PerRegisteredCourse() {
        Student s = new Student("1", "Aysegul");
        s.register(new Course("C1", "T1", 3));
        s.register(new Course("C2", "T2", 4));

        assertEquals(2000.0, s.calculateTuition());
    }
}
