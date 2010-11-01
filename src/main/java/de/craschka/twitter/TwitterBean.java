package de.craschka.twitter;

import de.craschka.twitter.api.Tweet;
import de.craschka.twitter.api.TwitterSearch;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class TwitterBean implements Serializable {
    @Inject
    private transient TwitterSearch twitterSearch;

    private String criteria;
    private List<Tweet> tweets;

    public void updateTweets(){
        tweets.addAll(0,twitterSearch.search());
        tweets = tweets.subList(0,9);
    }

    public void newSearch(){
        tweets.clear();
        tweets.addAll(twitterSearch.search(criteria!=null?criteria:"#netos"));
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public List<Tweet> getTweets(){
        if (tweets == null){
            tweets = twitterSearch.search(criteria!=null?criteria:"#netos");
        }
        return tweets;
    }

  
}
