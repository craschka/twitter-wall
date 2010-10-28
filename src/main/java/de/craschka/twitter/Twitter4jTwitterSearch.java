package de.craschka.twitter;

import de.craschka.twitter.api.Author;
import de.craschka.twitter.api.Content;
import de.craschka.twitter.api.Tweet;
import de.craschka.twitter.api.TwitterSearch;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

public class Twitter4jTwitterSearch implements TwitterSearch{
    @Override
    public List<Tweet> search(String criteria) {
        List<Tweet> tweets = new ArrayList<Tweet>();
        Twitter twitter = new TwitterFactory().getInstance();
        Query query = new Query();
        query.setQuery(criteria);
        QueryResult result = null;
        try {
            result = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        if (result != null){
            for (twitter4j.Tweet tweet : result.getTweets()) {
                tweets.add(new Tweet(new Content(tweet.getText()),new Author(tweet.getFromUser())));
            }
        }
        return tweetsh;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
