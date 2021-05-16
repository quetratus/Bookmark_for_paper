package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

        result = new BookmarksHandler().addTagtoBookmark(url, tag);

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
        result = new BookmarksHandler().addTagtoBookmark(url, tag);

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

        Integer bookmarkRating = bookmark.rating;


        assertEquals(5, bookmarkRating);
        // starts at 1 thats why it's 5;
        assertEquals(5, bookmarks.getBookmarksRating(url));
    }

    @Test
    public void searchBookmarksByKeyword(String keyword) throws MalformedURLException {
        //Arrange
        keyword = "search";
       // List<String> foundBookmarks = new ArrayList<>();
        List<String> expectedfoundBookmarks = new ArrayList<>();
        URL url = new URL("http://www.google.com");
        URL url1 = new URL("http://www.bing.com");
        URL url2 = new URL("http://www.facebook.com");

        bookmarks.addTagtoBookmark(url, "search");
        bookmarks.addTagtoBookmark(url1, "search");
        bookmarks.addTagtoBookmark(url2, "social media");

        //Act
        List<String> foundBookmarks = bookmarks.searchBookmarksByKeyword(keyword);
        expectedfoundBookmarks.add("http://www.google.com");
        expectedfoundBookmarks.add("http://www.bing.com");

        //Assert
        assertEquals(expectedfoundBookmarks, foundBookmarks);
    }


    @Test
    public void getNumberOfSecureBooksmarks() throws MalformedURLException {

        // Arrange
        URL url = new URL("http://www.yahoo.com/");
        URL urlsecure = new URL("https://mail.yahoo.com");

        bookmarks.addBookmark(url);
        bookmarks.addBookmark(urlsecure);

        int numberSecureURL = bookmarks.getSecureUrl();

        assertEquals(1, numberSecureURL);

    }

    @Disabled
    @Test
    public void getNumberOfZeroSecureBooksmarks() throws MalformedURLException {

        // Arrange
        URL url = new URL("http://www.google.com");

        bookmarks.addBookmark(url);
        bookmarks.addBookmark(url);
        bookmarks.addBookmark(url);

    //    int bookmarkSecure = new BookmarksHandler().getSecureUrl();

      //  assertEquals(0, bookmarkSecure);
    }
}


