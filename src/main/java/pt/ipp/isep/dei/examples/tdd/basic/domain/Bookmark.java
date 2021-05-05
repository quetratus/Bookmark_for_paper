package pt.ipp.isep.dei.examples.tdd.basic.domain;


//import static jdk.nashorn.internal.objects.NativeMath.round;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Bookmark class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Bookmark {

    //URL[] bookmark = new URL[]{ };
    List<URL> bookmark = new ArrayList<URL>();

    public Boolean addBookmark(URL url) {

        bookmark.add(url);

        return true;
    }


}
