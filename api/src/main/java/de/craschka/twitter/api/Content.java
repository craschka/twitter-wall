package de.craschka.twitter.api;

import java.util.List;

public class Content {
    public final String content;

    public Content(String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
