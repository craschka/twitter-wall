package de.craschka.twitter;

import de.craschka.twitter.api.Tweet;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class When_TwitterSearch_only_new_is_called_direct_after {
    private Twitter4jTwitterSearch sut;
    private List<Tweet> tweets;

    @Before
    public void setUp(){
        sut = new Twitter4jTwitterSearch();

        sut.search("#archos10");
        
        tweets = sut.searchOnlyNew("#archos10");
    }

    @Test
    public void nothing_should_be_returned(){
        tweets = sut.searchOnlyNew("#archos10");
        assertThat(tweets.size(),is(equalTo(0)));
    }

    @Test
    public void nothing_should_be_returned_on_last_query(){
        tweets = sut.search();
        assertThat(tweets.size(),is(equalTo(0)));
    }
}
