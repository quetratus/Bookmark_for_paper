package pt.ipp.isep.dei.examples.tdd.basic.domain;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

/**
 * Bookmark class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class BookmarksHandler {

    Bookmark bookmark;
    URL url;
    HashMap<URL, String> bookmarks = new HashMap<>();
    HashMap<URL, Integer> bookmarksRating = new HashMap<>(); // Maybe this way is more like tdd? to have two hashmaps here
    HashMap<URL, Bookmark> bookmarksHashMap = new HashMap<>(); // bit unpractical

    public Boolean addBookmark(URL url) throws MalformedURLException {
        // this would overwrite the tags if existent I guess..
        bookmarks.put(url, null);

        // if using BookmarksClass and HashMap was the case
        if (bookmarksHashMap.containsKey(url)) {
            bookmark = bookmarksHashMap.get(url);
            bookmark.rating += 1;
            bookmarksHashMap.put(url, bookmark);
        } else {
            bookmarksHashMap.put(url, new Bookmark(this.url, null, 1));
        }

        // with Rating as an extra hash map
        bookmarksRating.merge(url, 1, Integer::sum);

        return true;
    }

    public String addTagToBookmark(URL url, String tag) {
        bookmarks.put(url, tag);
        return bookmarks.get(url);
    }

    public Integer numBookmarks() {
        return bookmarks.size();
    }

    public Bookmark getBookmark(URL url) {
        return bookmarksHashMap.get(url);
    }

    public Integer getBookmarksRating(URL url) {
        return bookmarksRating.get(url);
    }

    public List<String> searchBookmarksByKeyword(String keyword) {
        List<String> foundBookmarks = new ArrayList<>();
        if (!bookmarks.isEmpty()) {
            Set<Entry<URL, String>> entryset = bookmarks.entrySet();
            for (Entry<URL, String> urlStringEntry : entryset) {
                @SuppressWarnings("rawtypes") Entry entry = urlStringEntry;
                if (entry.getValue().equals(keyword)) {
                    foundBookmarks.add(entry.getKey().toString()); }
            }
        }
        else { return Collections.emptyList(); }
        return foundBookmarks;
    }

    public int getSecureUrl() {
        @SuppressWarnings("rawtypes") ArrayList<Entry> secureURLsList = new ArrayList<>();
        Set<Entry<URL, String>> entryset = bookmarks.entrySet();
        for (Entry<URL, String> urlStringEntry : entryset) {
            if (urlStringEntry.getKey().toString().contains("https")) {
                secureURLsList.add(urlStringEntry); } }
        return secureURLsList.size();
    }

    public void removeTagFromBookmark(URL url, String tag) {
        if (bookmarks.containsKey(url) && bookmarks.containsValue(tag)) {
            bookmarks.put(url, null);
        } else
            throw new NoSuchElementException();
    }

    public String getTag (URL url) {
        return bookmarks.get(url);
    }

    public void removeBookmark(URL url) {
        if (bookmarks.containsKey(url)) {
            bookmarks.remove(url);
        } else
            throw new NoSuchElementException();
    }

    public List<URL> getAllBookmarks() {
        List<URL> allBookmarks = new ArrayList<>();
        for (Map.Entry<URL, String> entry : bookmarks.entrySet())
            allBookmarks.add(entry.getKey());
        return allBookmarks;
    }
}
