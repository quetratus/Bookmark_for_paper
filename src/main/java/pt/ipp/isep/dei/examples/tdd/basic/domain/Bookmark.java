package pt.ipp.isep.dei.examples.tdd.basic.domain;


//import static jdk.nashorn.internal.objects.NativeMath.round;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Bookmark class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Bookmark {

    //URL[] bookmark = new URL[]{ };
    URL url;
    String tag;
    HashMap<URL, String> bookmarks = new HashMap<URL, String>();



    public Boolean addBookmark(URL url) {

        bookmarks.put(url, null);

        return true;
    }


    public String addTagtoBookmark(URL url, String tag) {

        bookmarks.put(url, tag);
  String storedTag  = bookmarks.get(url);
        return storedTag;
    }
}
