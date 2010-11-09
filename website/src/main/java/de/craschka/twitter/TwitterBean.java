package de.craschka.twitter;

import de.craschka.twitter.api.Tweet;
import de.craschka.twitter.api.TwitterSearch;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named("twitter")
public class TwitterBean implements Serializable {
    @EJB
    private transient TwitterSearch twitterSearch;

    private String criteria;
    private List<Tweet> tweets;
    private int counter = 1;
    private String[] colors = new String[]{"red","green","blue","red","red","red","red","red","red"};

    public void updateTweets(){
        if (tweets == null){
            tweets = new ArrayList<Tweet>(9);            
        }
        List<Tweet> searchedTweets = twitterSearch.search();
        System.out.println("found "+searchedTweets.size() + " new tweets");
        tweets.addAll(0, searchedTweets);
        tweets = firstNineElements(tweets);
    }

    public void newSearch(){
        tweets.clear();
        tweets.addAll(twitterSearch.search(criteria!=null||criteria.length()==0?criteria:"#archos10"));
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public List<Tweet> getTweets(){
        if (tweets == null){
            List<Tweet> searchedTweets = twitterSearch.search(criteria != null ? criteria : "#archos10");
            tweets = firstNineElements(searchedTweets);
        }
        return tweets;
    }

    private List<Tweet> firstNineElements(List<Tweet> searchedTweets) {
        List<Tweet> tweets = new ArrayList<Tweet>(9);
        for (int i=0;i<Math.min(searchedTweets.size(),9);i++){
            tweets.add(searchedTweets.get(i));
        }
        return tweets;
    }

    public String getColors(){
        System.out.println(colors[counter]);
        return colors[counter++ % 9];
    }

  
}
