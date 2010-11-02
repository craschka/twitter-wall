package de.craschka.twitter;

import de.craschka.twitter.api.Tweet;
import de.craschka.twitter.api.TwitterSearch;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static de.craschka.twitter.utils.PrivateAccessors.setPrivateField;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class When_TwitterBean_is_created {
    private TwitterBean sut;
    private TwitterSearch mockTwitterSearch;
    private Tweet tweet = mock(Tweet.class);

    @Before
    public void setUp(){
        sut = new TwitterBean();
        mockTwitterSearch = mock(TwitterSearch.class);
        when(mockTwitterSearch.search("#archos10")).thenReturn(get20Tweets());
        //when(mockTwitterSearch.search()).thenReturn(get20Tweets());
        setPrivateField(sut,"twitterSearch",mockTwitterSearch);
    }

    @Test
    public void first_search_should_ask_for_default_query(){
        sut.getTweets();

        verify(mockTwitterSearch).search("#archos10");
    }

    @Test
    public void search_should_always_return_maximum_nine_values(){
        List<Tweet> tweets = sut.getTweets();

        assertThat(tweets.size(),is(equalTo(9)));
    }

    @Test
    public void update_should_run_the_same_search(){
        sut.updateTweets();

        verify(mockTwitterSearch).search();
    }

    private List<Tweet> get20Tweets() {
        List<Tweet> tweets = new ArrayList<Tweet>(20);

        for (int i=1;i<=20;i++){
            tweets.add(tweet);
        }
        return tweets;
    }
}
