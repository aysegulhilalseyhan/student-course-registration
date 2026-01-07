package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    @Test
    void constructor_createsInstructor() {
        assertNotNull(new Instructor("I1", "Dr. Smith"));
    }
}
