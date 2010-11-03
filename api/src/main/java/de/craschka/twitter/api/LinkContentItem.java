package de.craschka.twitter.api;

public class LinkContentItem implements ContentItem{
    public LinkContentItem(String link) {
        this.link = link;
    }

    public final String link;

    @Override
    public String toString(){
        return link;
    }


    @Override
    public boolean isLink() {
        return true;
    }
}
