package com.nolla.nollatwitterapi.DAO;
import java.util.*;
import com.nolla.nollatwitterapi.Model.Tweet;
import java.sql.Array;
public interface TweetDAO {
    Optional<Tweet> findById(Long tweetId);
    List<Tweet> findByUser(Long userId);
    List<Tweet> findAll(Array content_twt);
    void save(Long userId, Array content_twt);
    void delete(Long tweetId);
}
