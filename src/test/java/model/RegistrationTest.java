package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest {

    @Test
    void constructor_createsRegistration() {
        Student s = new Student("1", "Aysegul");
        Course c = new Course("CENL405", "Computer Network & Security", 5);
        Registration r = new Registration(s, c);
        assertNotNull(r);
    }
}
