package de.craschka.twitter.api;

public class TextContentItem implements ContentItem{
    public TextContentItem(String content) {
        this.content = content;
    }

    public final String content;

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean isLink() {
        return false;
    }
}
