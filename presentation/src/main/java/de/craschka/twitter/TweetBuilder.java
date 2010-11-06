package de.craschka.twitter;

import de.craschka.twitter.api.*;

public class TweetBuilder {
    private TweetBuilder(){}
    
    public static Tweet_ create(){
        return new Tweet_();
    }

    static class Tweet_ {
        private Tweet_(){}
        
        protected Tweet__ withContent(String content){
            return new Tweet__(content);
        }

        class Tweet__ {
            private String content;

            private Tweet__(String content) {
                this.content = content;
            }

            public Tweet___ andAuthor(String author){
                return new Tweet___(new Content(content),new Author(author));
            }
        }

        class Tweet___  {
            private final Content content;
            private final Author author;

            public Tweet___(Content content, Author author) {
                this.content = content;
                this.author = author;
            }

            public Tweet withImage(String imageURL){
                return new Tweet(content,author,imageURL);
            }
        }
    }
}
