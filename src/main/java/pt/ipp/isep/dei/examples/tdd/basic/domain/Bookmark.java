package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class Bookmark {
    private URL url;
    private String tags;
    Integer rating;
    private int noSecureUrl;


    // Currently  used for experimenting around
    public Bookmark(URL url, String tags, Integer rating) throws MalformedURLException  {
        this.url = url;
        this.tags = tags;
        this.rating = rating;
    }



}
