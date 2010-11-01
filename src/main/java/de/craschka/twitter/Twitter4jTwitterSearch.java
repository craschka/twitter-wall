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
        Query query = new Query();
        query.setQuery(criteria);
        if (sinceId!= null){
            query.setSinceId(sinceId);
        }
        QueryResult result = null;
        try {
            result = twitter.search(query);
            savedSinces.put(result.getQuery(),result.getMaxId());
        } catch (TwitterException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        if (result != null){
            for (twitter4j.Tweet tweet : result.getTweets()) {
                tweets.add(new Tweet(new Content(tweet.getText()),new Author(tweet.getFromUser())));
            }
        }
        return tweets;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
