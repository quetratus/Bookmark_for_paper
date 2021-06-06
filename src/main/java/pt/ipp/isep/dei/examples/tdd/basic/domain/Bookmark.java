package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.net.URL;

public class Bookmark {
    private final URL url;
    private String tags;
    Integer rating;


    // Currently  used for experimenting around
    public Bookmark(URL url, String tags, Integer rating) throws MalformedURLException  {
        this.url = url;
        this.tags = tags;
        this.rating = rating;
    }


}
