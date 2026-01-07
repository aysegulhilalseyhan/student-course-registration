package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraduateStudentTest {

    @Test
    void calculateTuition_is1500PerRegisteredCourse() {
        GraduateStudent gs = new GraduateStudent("2", "Hilal");
        gs.register(new Course("C1", "T1", 3));
        gs.register(new Course("C2", "T2", 4));

        assertEquals(3000.0, gs.calculateTuition());
    }
}
