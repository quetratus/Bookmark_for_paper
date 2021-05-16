package pt.ipp.isep.dei.examples.tdd.basic.domain;


//import static jdk.nashorn.internal.objects.NativeMath.round;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Bookmark class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class BookmarksHandler {

    //URL[] bookmark = new URL[]{ };
    Bookmark bookmark;
    URL url;
    String tag;
    HashMap<URL, String> bookmarks = new HashMap<URL, String>();
    HashMap<URL, Integer> bookmarksRating = new HashMap<URL, Integer>(); // Maybe this way is more like tdd? to have two hashmaps here
    HashMap<URL, Bookmark> bookmarksHashMap = new HashMap<URL, Bookmark>(); // bit unpractical

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
        String storedTag = bookmarks.get(url);
        return storedTag;
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
        for (Map.Entry<URL, String> entry : bookmarks.entrySet()) {
            if (entry.getValue().contains(keyword)) {
                foundBookmarks.add(entry.getValue());
            } else System.out.println("No result found");
        }
        return foundBookmarks;
    }


    public int getSecureUrl(){
        Map<Object, Object> result = bookmarks.entrySet()
                .stream()
                .filter(map -> map.getKey().toString().contains("http://www.yahoo.com/"))//filter by value
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return result.size(); }
}


/*
         //create a set holding all keys in the hashtable
        Iterator<Map.Entry<URL, String>> iterator = bookmarks.entrySet().iterator();
        int count = 0;
        String str = "https";
        while (iterator.hasNext()) {
            Map.Entry<URL, String> entry = iterator.next();
            for (entry.getValue().startsWith(str)) {
                secureURLs.put(entry);}
            if (entry.getValue().startsWith(str)) {
                count++;
            } else {
                count = 0;
            }
        }return count;}
*/
