package de.craschka.twitter;

import de.craschka.twitter.api.Tweet;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class When_TwitterSearch_is_called_with_criteria {
    private Twitter4jTwitterSearch sut;
    private List<Tweet> tweets;

    @Before
    public void setUp(){
        sut = new Twitter4jTwitterSearch();

        tweets = sut.search("test");
    }

    @Test
    public void the_result_should_be_non_empty(){
        assertThat(tweets.size(),is(greaterThan(0)));
    }
}
