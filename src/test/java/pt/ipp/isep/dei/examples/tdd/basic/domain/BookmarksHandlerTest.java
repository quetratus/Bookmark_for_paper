package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarksHandlerTest {

    BookmarksHandler bookmarks = new BookmarksHandler();

    @Test
    public void addValidURL() throws MalformedURLException {

        // Arrange
        URL url = new URL("http://www.google.com");
        Boolean expectedResult = true;
        Boolean result;

        // Act
        // Bookmark bookmark = new Bookmark(url);
        result = new BookmarksHandler().addBookmark(url);
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void addASingleTagToAURL()  {
        // Arrange
        URL url= null;
        try {
            url = new URL("http://www.google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String tag = new String("search");
        String expectedResult = "search";
        String result;

        // Act

        result = new BookmarksHandler().addTagToBookmark(url, tag);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void addMultipleTagsToAURL()  {
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
        result = new BookmarksHandler().addTagToBookmark(url, tag);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void addMultipleBookmarks()  {
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
        // Act

        result = bookmarks.addTagToBookmark(url, tag);
        try {
            url = new URL("http://www.google.com/search?2");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        result = bookmarks.addTagToBookmark(url, tag);

        try {
            url = new URL("http://www.google.com/search?3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        result = bookmarks.addTagToBookmark(url, tag);
        result = bookmarks.addTagToBookmark(url, tag);
        result = bookmarks.addTagToBookmark(url, tag);

        // Assert
        assertEquals(expectedResult, result);

        assertEquals(3, bookmarks.numBookmarks());
    }

    @Test
    public void getUpdatedValueofBookmarkHash() throws MalformedURLException {

        // Arrange
        URL url = null;
        try {
            url = new URL("http://www.google.com/search?1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        bookmarks.addBookmark(url); // 1
        bookmarks.addBookmark(url); // 2
        bookmarks.addBookmark(url); // 3
        bookmarks.addBookmark(url); // 4
        bookmarks.addBookmark(url); // 5

        Bookmark bookmark = bookmarks.getBookmark(url);

        int bookmarkRating = bookmark.rating;


        assertEquals(5, bookmarkRating);
        // starts at 1 thats why it's 5;
        assertEquals(5, bookmarks.getBookmarksRating(url));
    }

    @Test
    public void searchBookmarksByKeyword() throws MalformedURLException {
        //Arrange
        String keyword = "search";
        URL url = new URL("http://www.google.com");
        URL url1 = new URL("http://www.bing.com");
        URL url2 = new URL("http://www.facebook.com");
        List<String> foundBookmarks;


        bookmarks.addTagToBookmark(url, "search");
        bookmarks.addTagToBookmark(url1, "search");
        bookmarks.addTagToBookmark(url2, "social media");
        //List<String> expectedfoundBookmarks = new ArrayList<>(Arrays.asList("http://www.bing.com", "http://www.google.com"));

        //Act
        foundBookmarks = bookmarks.searchBookmarksByKeyword(keyword);


        //Assert
        assertTrue(foundBookmarks.contains("http://www.google.com"));
        assertTrue(foundBookmarks.contains("http://www.bing.com"));    }

    @Test
    public void searchBookmarksByKeywordZeroResult() throws MalformedURLException {
        //Arrange
        String keyword = "search";
        List<String> foundBookmarks;
        URL url = new URL("http://www.google.com");
        URL url1 = new URL("http://www.bing.com");
        URL url2 = new URL("http://www.facebook.com");

        bookmarks.addTagToBookmark(url, "google");
        bookmarks.addTagToBookmark(url1, "bing");
        bookmarks.addTagToBookmark(url2, "social media");

        //Act
        foundBookmarks = bookmarks.searchBookmarksByKeyword(keyword);

        //Assert
        assertTrue(foundBookmarks.isEmpty());
    }

    @Test
    public void searchBookmarksByKeywordZeroEntries()  {
        //Arrange
        String keyword = "search";
        List<String> foundBookmarks;
        //List<String> expectedfoundBookmarks = new ArrayList<>();

        //Act
        foundBookmarks = bookmarks.searchBookmarksByKeyword(keyword);


        //Assert
        assertTrue(foundBookmarks.isEmpty());
    }


    @Test
    public void getNumberOfSecureBooksmarks() throws MalformedURLException {

        // Arrange
        URL url = new URL("http://www.yahoo.com/");
        URL urlsecure = new URL("https://mail.yahoo.com");
        URL urlsecure1 = new URL("https://www.google.com");


        bookmarks.addBookmark(url);
        bookmarks.addBookmark(urlsecure);
        bookmarks.addTagToBookmark(urlsecure1, "test");

        //Act
        int numberSecureURL = bookmarks.getSecureUrl();

        //Assert
        assertEquals(2, numberSecureURL);

    }

    @Test
    public void getNumberOfZeroSecureBooksmarks() throws MalformedURLException {

        // Arrange
        URL url = new URL("http://www.google.com");
        URL url1 = new URL("http://www.yahoo.com");
        URL url2 = new URL("http://www.orf.at");

        bookmarks.addBookmark(url);
        bookmarks.addBookmark(url1);
        bookmarks.addBookmark(url2);

        int bookmarkSecure = bookmarks.getSecureUrl();

        assertEquals(0, bookmarkSecure);
    }

    @Test
    public void removeTagFromSelectedBookmark() throws MalformedURLException {
        //Arrange
        URL url = new URL("http://www.google.com");
        URL url1 = new URL("http://www.googlemaps.com");
        bookmarks.addTagToBookmark(url, "google");
        bookmarks.addTagToBookmark(url1, "google");
        String expectedWithTag = "google";

        //Act
        bookmarks.removeTagFromBookmark(url, "google");
        String noTag = bookmarks.getTag(url);
        String withTag = bookmarks.getTag(url1);

        //Assert
        assertNull(noTag);
        assertEquals(expectedWithTag, withTag);
    }

    @Test
    public void tagToRemoveDoesNotExist() throws MalformedURLException {
        //Arrange
        URL url = new URL("http://www.google.com");
        bookmarks.addTagToBookmark(url, "google");

        //Assert
        assertThrows(NoSuchElementException.class, () -> bookmarks.removeTagFromBookmark(url, "yahoo"));
    }

    @Test
    public void removeExistingBookmark() throws MalformedURLException {
        //Arrange
        URL url = new URL("http://www.google.com");
        URL url1 = new URL("http://www.yahoo.com");

        bookmarks.addBookmark(url);
        bookmarks.addBookmark(url1);

        //Action
        bookmarks.removeBookmark(url);

        assertFalse(bookmarks.getAllBookmarks().contains(url));
        assertTrue(bookmarks.getAllBookmarks().contains(url1));

    }

    @Test
    public void removeNonExistingBookmark() throws MalformedURLException {
        //Arrange
        URL url = new URL("http://www.google.com");
        URL url1 = new URL("http://www.yahoo.com");

        bookmarks.addBookmark(url);

        //Assert
        assertThrows(NoSuchElementException.class, () -> bookmarks.removeBookmark(url1));
    }

    @Test
    public void removeBookmarkFromEmptyList() throws MalformedURLException {
        //Arrange
        URL url = new URL("http://www.google.com");


        //Assert
        assertThrows(NoSuchElementException.class, () -> bookmarks.removeBookmark(url));
        assertTrue(bookmarks.getAllBookmarks().isEmpty());
    }

}


