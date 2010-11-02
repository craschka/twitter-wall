package de.craschka.twitter;

import de.craschka.twitter.api.Tweet;
import de.craschka.twitter.api.TwitterSearch;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named("twitter")
public class TwitterBean implements Serializable, TwitterBeanController {
    @EJB
    private transient TwitterSearch twitterSearch;

    private String criteria;
    private List<Tweet> tweets;
    private int counter = 1;
    private String[] colors = new String[]{"red","green","blue","red","red","red","red","red","red"};

    @Override
    public void updateTweets(){
        if (tweets == null){
            tweets = new ArrayList<Tweet>(9);            
        }
        List<Tweet> searchedTweets = twitterSearch.search();
        tweets.addAll(0, searchedTweets);
        tweets = tweets.subList(0,Math.min(searchedTweets.size(),9));
    }

    @Override
    public void newSearch(){
        tweets.clear();
        tweets.addAll(twitterSearch.search(criteria!=null||criteria.length()==0?criteria:"#archos10"));
    }

    @Override
    public String getCriteria() {
        return criteria;
    }

    @Override
    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    @Override
    public List<Tweet> getTweets(){
        if (tweets == null){
            List<Tweet> searchedTweets = twitterSearch.search(criteria != null ? criteria : "#archos10");
            tweets = searchedTweets.subList(0,Math.min(searchedTweets.size(),9));
        }
        return tweets;
    }


    @Override
    public String getColors(){
        System.out.println(colors[counter]);
        return colors[counter++ % 9];
    }

  
}
