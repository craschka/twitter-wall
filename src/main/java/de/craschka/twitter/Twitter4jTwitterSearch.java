package de.craschka.twitter;

import de.craschka.twitter.api.Author;
import de.craschka.twitter.api.Content;
import de.craschka.twitter.api.Tweet;
import de.craschka.twitter.api.TwitterSearch;
import twitter4j.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter4jTwitterSearch implements TwitterSearch{

    private Map<String,Long> savedSinces = new HashMap<String,Long>();
    private String lastQuery;

    private static final int MAX_RETURN_VALUES = 9;

    @Override
    public List<Tweet> search(String criteria) {
        return search(criteria,null);
    }

    @Override
    public List<Tweet> searchOnlyNew(String criteria) {
        return search(criteria,savedSinces.get(criteria));
    }

    @Override
    public List<Tweet> search() {
        if (lastQuery == null || lastQuery.length()==0){
            throw new IllegalArgumentException("no previous search found");
        }
        return searchOnlyNew(lastQuery);
    }

    private List<Tweet> search(String criteria,Long sinceId){
        lastQuery = criteria;
        List<Tweet> tweets = new ArrayList<Tweet>();
        Twitter twitter = new TwitterFactory().getInstance();

        QueryResult result = null;
        try {
            result = twitter.search(QueryBuilder.create(criteria,sinceId));
            savedSinces.put(result.getQuery(),result.getMaxId());
        } catch (TwitterException e) {
            e.printStackTrace();  
        }

        if (result != null){
            for (twitter4j.Tweet tweet : result.getTweets()) {
                tweets.add(TweetBuilder.create().withContent(tweet.getText()).andAuthor(tweet.getFromUser()));
            }
        }
        return tweets;  
    }
}
