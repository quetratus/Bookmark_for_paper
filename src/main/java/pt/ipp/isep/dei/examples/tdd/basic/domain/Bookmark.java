package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.URL;

public class Bookmark {
    URL url;
    String tags;
    Integer rating;
    // Currently  used for experimenting around
    public Bookmark(URL url, String tags, Integer rating) {
        this.url = url;
        this.tags = tags;
        this.rating = rating;
    }
    public Bookmark() {

    }

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
}
