package service;

import model.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseCatalogTest {

    @Test
    void findByCode_shouldReturnCourse() {
        CourseCatalog catalog = new CourseCatalog();
        catalog.addCourse(new Course("CS101", "Computer Science", 5));

        Course found = catalog.findByCode("CS101");

        assertNotNull(found);
        assertEquals("CS101", found.getCode());
    }

    @Test
    void findByCode_shouldReturnNullWhenMissing() {
        CourseCatalog catalog = new CourseCatalog();
        assertNull(catalog.findByCode("NOPE"));
    }
}
