package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void register_shouldPreventDuplicates() {
        Student s = new Student("S1", "Aysegul");
        Course c = new Course("CS101", "Computer Science", 5);

        assertTrue(s.register(c));
        assertFalse(s.register(c)); 
        assertEquals(1, s.getRegisteredCourses().size());
    }

    @Test
    void drop_shouldRemoveCourse() {
        Student s = new Student("S1", "Aysegul");
        Course c = new Course("CS101", "Computer Science", 5);

        s.register(c);
        assertTrue(s.drop(c));
        assertEquals(0, s.getRegisteredCourses().size());
    }
}

