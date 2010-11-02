package de.craschka.twitter.api;

import java.util.List;

public interface TwitterSearch {
    List<Tweet> search(String criteria);
    List<Tweet> searchOnlyNew(String criteria);
    List<Tweet> search();
}
