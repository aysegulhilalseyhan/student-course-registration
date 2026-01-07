package service;

import model.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseCatalogTest {

    @Test
    void addCourse_increasesCatalogSize() {
        CourseCatalog catalog = new CourseCatalog();
        catalog.addCourse(new Course("CEN101", "Intro", 3));
        assertEquals(1, catalog.getCourses().size());
    }

    @Test
void removeCourse_decreasesCatalogSize() {
    CourseCatalog catalog = new CourseCatalog();
    Course c = new Course("CEN101", "Intro", 3);
    catalog.addCourse(c);
    catalog.removeCourse(c);
    assertEquals(0, catalog.getCourses().size());
}

    @Test
    void findByCode_returnsCorrectCourse() {
        CourseCatalog catalog = new CourseCatalog();
        catalog.addCourse(new Course("CEN101", "Intro", 3));
        catalog.addCourse(new Course("CEN102", "OOP", 4));

        Course found = catalog.findByCode("CEN102");
        assertNotNull(found);
        assertEquals("CEN102", found.getCode());
    }

    @Test
    void findByCode_returnsNullWhenNotFound() {
        CourseCatalog catalog = new CourseCatalog();
        assertNull(catalog.findByCode("XXX"));
    }
}
