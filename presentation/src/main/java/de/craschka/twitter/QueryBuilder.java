package de.craschka.twitter;

import twitter4j.Query;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class QueryBuilder {
    private static final int RETURN_PER_PAGE = 9;

    public static Query create(String criteria){
        return create(criteria, null);
    }

    public static Query create(String criteria, Long sinceId){
        Query query = new Query();
        query.setQuery(criteria);
        query.setRpp(RETURN_PER_PAGE);
        query.setPage(1);
        if (sinceId!= null){
            query.setSinceId(sinceId);
        }
        return query;
    }
}
