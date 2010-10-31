package de.craschka.twitter;

import java.util.List;

import de.craschka.twitter.api.Tweet;
import de.craschka.twitter.api.TwitterSearch;

public class Test {

	public static void main(String[] args) {
		TwitterSearch ts = new Twitter4jTwitterSearch();
		List<Tweet> tweets = ts.search("#netos");

	}

}
