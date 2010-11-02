package de.craschka.twitter;

import de.craschka.twitter.api.Tweet;

import java.util.List;

public interface TwitterBeanController {
    void updateTweets();

    void newSearch();

    String getCriteria();

    void setCriteria(String criteria);

    List<Tweet> getTweets();

    String getColors();
}
