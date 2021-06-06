package pt.ipp.isep.dei.examples.tdd.basic.domain;
import org.junit.jupiter.api.*;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {

    @BeforeAll
    public static void classSetUp() {
    }

    @AfterAll
    public static void classTearDown() {

    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void addInvalidURL() throws MalformedURLException {

        // Arrange
        try {
            URL url = new URL("http://www.google.com");
            Boolean expectedResult = true;
            Boolean result;

            // Act
            //Bookmark bookmark = new Bookmark(url);
            result = new BookmarksHandler().addBookmark(url);

            // Assert
            assertEquals(expectedResult, result);
        } catch (MalformedURLException e) {
        }
    }

    /**
     * This ssems to do the job, but with the closure, breaks the usual pattern
     */
    @Test
    public void invalidURLThrowsException() {
        Exception exception = assertThrows(MalformedURLException.class, () -> new URL("h://www.google.com"));
        assertTrue(exception.getMessage().contains("unknown protocol"));
    }

}

