import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void addBook() {
        Library library = new Library(new ArrayList<String>());
        library.addBook("1984");
        assertTrue(library.listBooks().contains("1984"));
    }

    @Test
    public void removeBook() {
        Library library = new Library(new ArrayList<String>());
        library.addBook("1984");
        library.removeBook("1984");
        assertFalse(library.listBooks().contains("1984"));
    }

    @Test
    public void listBooks() {
        Library library = new Library(new ArrayList<String>());
        library.addBook("1984");
        library.addBook("To Kill a Mockingbird");
        assertTrue(library.listBooks().contains("1984"));
        assertTrue(library.listBooks().contains("To Kill a Mockingbird"));
    }
}