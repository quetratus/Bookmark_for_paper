package pt.ipp.isep.dei.examples.tdd.basic.domain;


//import static jdk.nashorn.internal.objects.NativeMath.round;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    public Boolean addBookmark(URL url) {
        // this would overwrite the tags if existent I guess..
        bookmarks.put(url, null);

        // if using BookmarksClass and HashMap was the case
        if(bookmarksHashMap.containsKey(url)) {
            bookmark = bookmarksHashMap.get(url);
            bookmark.rating +=1;
           bookmarksHashMap.put(url, bookmark);
        } else {
            bookmarksHashMap.put(url, new Bookmark(url, null, 1));
        }

        // with Rating as an extra hash map
        bookmarksRating.merge(url,1,Integer::sum);

        return true;
    }


    public String addTagtoBookmark(URL url, String tag) {

        bookmarks.put(url, tag);
         String storedTag  = bookmarks.get(url);
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

    public int getSecureUrl(){
        Map<Object, Object> result = bookmarks.entrySet()
                .stream()
                .filter(map -> map.getValue().startsWith("https://")) //filter by value
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        return result.size(); };
}
