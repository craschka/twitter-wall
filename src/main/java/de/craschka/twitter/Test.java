package de.craschka.twitter;

import de.craschka.twitter.api.*;
import de.craschka.twitter.api.Tweet;
import twitter4j.*;

public class Test {
    public static void main2(String[] args) {
        Twitter t = new TwitterFactory().getInstance();
        try {
            Query query = new Query("love");
            query.setRpp(40);
            query.setPage(1);
            query.setSinceId(29270687512L);
            QueryResult q = t.search(query);
            System.out.println(q.toString());
            q.getSinceId();
        } catch (TwitterException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static void main(String[] args) {
        TwitterSearch t = new Twitter4jTwitterSearch();
        for (Tweet tweet : t.searchOnlyNew("love")) {
            System.out.println(tweet.content);
        }
        System.out.println("second try");
        for (Tweet tweet : t.search()) {
            System.out.println(tweet.content);
        }
        System.out.println("third try");
        for (Tweet tweet : t.search()) {
            System.out.println(tweet.content);
        }
        System.out.println("fourth try");
        for (Tweet tweet : t.search()) {
            System.out.println(tweet.content);
        }
    }
}
