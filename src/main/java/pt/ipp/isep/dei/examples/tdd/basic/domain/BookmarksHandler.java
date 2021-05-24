package pt.ipp.isep.dei.examples.tdd.basic.domain;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static java.util.Map.*;

/**
 * Bookmark class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class BookmarksHandler {

    Bookmark bookmark;
    URL url;
    String tag;
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

    public String addTagtoBookmark(URL url, String tag) {
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
            Set entryset = bookmarks.entrySet();
            Iterator it = entryset.iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                entry.getValue();
                if (entry.getValue().equals(keyword)) {
                    foundBookmarks.add(entry.getKey().toString());
                }
            }
        }
        else {
            return Collections.emptyList();
        }
        return foundBookmarks;
    }

/**
    public int getSecureUrl(){
        Map<Object, Object> result = bookmarks.entrySet()
                .stream()
                .filter(map -> map.getKey().toString().contains("http://www.yahoo.com/"))//filter by value
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return result.size(); }
}
 */

    public int getSecureUrl() {
        ArrayList<Entry> secureURLsList = new ArrayList<>();
        Set entryset = bookmarks.entrySet();
        Iterator it = entryset.iterator();
        while (it.hasNext()) {
            Entry me = (Entry)it.next();
            me.getKey();
            if (me.getKey().toString().contains("https")) {
               secureURLsList.add(me);
            }
            }
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

}