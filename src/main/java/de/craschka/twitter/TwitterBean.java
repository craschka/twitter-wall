package de.craschka.twitter;

import de.craschka.twitter.api.Tweet;
import de.craschka.twitter.api.TwitterSearch;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class TwitterBean {
    @Inject
    private TwitterSearch twitterSearch;

    private String criteria;

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public List<Tweet> getTweets(){
        return twitterSearch.search(criteria!=null?criteria:"#netos");
    }

  
}
