package de.craschka.twitter.api;

public class Tweet {
    public final Author author;
    public final Content content;
    public final String userImageURL;

    public Tweet(Content content, Author author, String userImageURL) {
        this.content = content;
        this.author = author;
        this.userImageURL = userImageURL;
    }

     public Tweet(String content, String author, String userImageUrl){
         this.content = new Content(content);
         this.author = new Author(author);
         this.userImageURL = userImageUrl;
    }

    public Author getAuthor() {
        return author;
    }

    public Content getContent() {
        return content;
    }

    public String getUserImageURL() {
        return userImageURL;
    }
}
