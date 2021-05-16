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

    public Bookmark(URL url) throws MalformedURLException {
        new Bookmark(url, tags, rating);
    }

    // Currently  used for experimenting around
    public Bookmark(URL url, String tags, Integer rating) throws MalformedURLException  {
        this.url = url;
        this.tags = tags;
        this.rating = rating;
    }

    /**
    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
*/
    public int getSecureUrl(){ return noSecureUrl; }


}
