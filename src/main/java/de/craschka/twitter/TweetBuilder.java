package de.craschka.twitter;

import de.craschka.twitter.api.Author;
import de.craschka.twitter.api.Content;
import de.craschka.twitter.api.Tweet;

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

            public Tweet andAuthor(String author){
                return new Tweet(new Content(content),new Author(author));
            }
        }
    }
}
