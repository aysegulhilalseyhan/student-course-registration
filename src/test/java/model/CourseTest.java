package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void constructor_setsFields() {
        Course c = new Course("CENL405", "Computer Network & Security", 5);
        assertEquals("CENL405", c.getCode());
        assertEquals(5, c.getCredits());
    }

    @Test
    void equals_comparesByCodeOnly() {
        Course c1 = new Course("CENL405", "Title A", 5);
        Course c2 = new Course("CENL405", "Title B", 99);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void equals_returnsFalseForDifferentCode() {
        assertNotEquals(new Course("A", "A", 1), new Course("B", "B", 1));
    }
}
