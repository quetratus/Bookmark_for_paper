package pt.ipp.isep.dei.examples.tdd.basic.domain;


import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
//import static jdk.nashorn.internal.objects.NativeMath.round;
public class BookmarkTest {

    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a BookmarkTest class method and takes place before any @Test is executed");
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a BookmarkTest class method and takes place after all @Test are executed");
    }

    @BeforeEach
    public void setUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place before each @Test is executed");
    }

    @AfterEach
    public void tearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place after each @Test is executed");
    }
/*
    @Test
    @Disabled
    public void failingTest() {
        fail("a disabled failing test");
    }

    /**
     * Test to ensure two positive numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange: one positive number (three) and another positive number (two).<p>
     * Act: sum both numbers (three and two).<p>
     * Assert: the result is five.
     */

    @Test
    public void addValidURL() throws MalformedURLException {

         // Arrange
        URL url= new URL("http://www.google.com");
        Boolean expectedResult = true;
        Boolean result;

        // Act

        result = new BookmarksHandler().addBookmark(url);
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void addInvalidURL() throws MalformedURLException {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        try {
            URL url = new URL("http://www.google.com");
            Boolean expectedResult = true;
            Boolean result;

            // Act
            result = new BookmarksHandler().addBookmark(url);

            // Assert
            assertEquals(expectedResult, result);
        } catch (MalformedURLException e) {
        }
    }
    /**
     *This ssems to do the job, but with the closure, breaks the usual pattern
     */
    @Test
    public void addInvalidURLrevisited()  {


        Assertions.assertThrows(MalformedURLException.class, () -> {
            new BookmarksHandler().addBookmark(new URL("h//www.google.com"));
        });
    }

    @Test
    public void addASingleTagToAURL()  {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        URL url= null;
        try {
            url = new URL("http://www.google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String tag = new String("search");
        String expectedResult = "search";
       String result  ;

        // Act

        result = new BookmarksHandler().addTagtoBookmark(url, tag);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void addMultipleTagsToAURL()  {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        URL url= null;
        try {
            url = new URL("http://www.google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String tag = new String("search, read, execute");
        String expectedResult = "search, read, execute";
        String result  ;

        // Act

        result = new BookmarksHandler().addTagtoBookmark(url, tag);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void addMultipleBookmarks()  {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        URL url= null;
        try {
            url = new URL("http://www.google.com/search?1");
        } catch (MalformedURLException e) {
            fail();
            //e.printStackTrace();
        }

        String tag = new String("search, read, execute");
        String expectedResult = "search, read, execute";
        String result  ;
        BookmarksHandler bookmarks = new BookmarksHandler();
        // Act

        result = bookmarks.addTagtoBookmark(url, tag);
        try {
            url = new URL("http://www.google.com/search?2");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        result = bookmarks.addTagtoBookmark(url, tag);

        try {
            url = new URL("http://www.google.com/search?3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        result = bookmarks.addTagtoBookmark(url, tag);
        result = bookmarks.addTagtoBookmark(url, tag);
        result = bookmarks.addTagtoBookmark(url, tag);

        // Assert
        assertEquals(expectedResult, result);

        assertEquals(3, bookmarks.numBookmarks());
    }

    @Test
    public void getUpdatedValueofBookmarkHash() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        URL url = null;
        try {
            url = new URL("http://www.google.com/search?1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BookmarksHandler bookmarks = new BookmarksHandler();

        bookmarks.addBookmark(url); // 1
        bookmarks.addBookmark(url); // 2
        bookmarks.addBookmark(url); // 3
        bookmarks.addBookmark(url); // 4
        bookmarks.addBookmark(url); // 5

        Bookmark bookmark = bookmarks.getBookmark(url);

        Integer bookmarkRating = bookmark.rating;


        assertEquals(5, bookmarkRating);
        // starts at 1 thats why it's 5;
        assertEquals(5, bookmarks.getBookmarksRating(url));


    }
    @Disabled
    @Test
    public void getNumberOfSecureBooksmarks() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        URL url = null;
        URL urlsecure= null;

        try {
            urlsecure = new URL("https://www.google.com");
            url = new URL("http://www.google.com");
        } catch (MalformedURLException e) {
           fail();
        }
        BookmarksHandler bookmarks = new BookmarksHandler();

        bookmarks.addBookmark(url);
        bookmarks.addBookmark(urlsecure);
        bookmarks.addBookmark(url);
        bookmarks.addBookmark(url);
        bookmarks.addBookmark(urlsecure);

        Bookmark bookmark = bookmarks.getBookmark(urlsecure);
        int bookmarkSecure = bookmark.getSecureUrl();


        assertEquals(1, bookmarkSecure);

    }

    @Test
    public void getNumberOfZeroSecureBooksmarks() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        URL url = null;
        URL urlsecure= null;

        try {
            url = new URL("http://www.google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BookmarksHandler bookmarks = new BookmarksHandler();

        bookmarks.addBookmark(url);
        bookmarks.addBookmark(url);
        bookmarks.addBookmark(url);

        Bookmark bookmark = bookmarks.getBookmark(url);
        int bookmarkSecure = bookmark.getSecureUrl();


        assertEquals(0, bookmarkSecure);

    }
}



