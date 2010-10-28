package de.craschka.twitter.api;

public class Tweet {
    public final Author author;
    public final Content content;

    public Tweet(Content content, Author author) {
        this.content = content;
        this.author = author;
    }
}
