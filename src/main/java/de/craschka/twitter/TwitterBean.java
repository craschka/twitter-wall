package de.craschka.twitter;

import de.craschka.twitter.api.Tweet;
import de.craschka.twitter.api.TwitterSearch;

import javax.inject.Inject;
import java.util.List;

public class TwitterBean {
    @Inject
    private TwitterSearch twitterSearch;

    public List<Tweet> getTweets(){
        return twitterSearch.search("#netos");
    }
}
