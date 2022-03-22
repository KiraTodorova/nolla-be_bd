package com.nolla.nollatwitterapi.DAO;
import com.nolla.nollatwitterapi.Model.Model_ver2;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DAO_ver2 {

final String INSERT_QUERY = "INSERT INTO tweets_ver2(content_twt) VALUES (:tweet)";
final String SELECT_QUERY = "SELECT * FROM tweets_ver2 ORDER BY created_twt DESC LIMIT 5";
final String DELETE_QUERY = "DELETE FROM tweets_ver2 WHERE twt_id = (:twt_id)";
final String SELECT_LIKE_QUERY = "UPDATE tweets_ver2 SET twt_like = (SELECT twt_like FROM tweets_ver2 WHERE twt_id = (:twt_id)) + 1 WHERE twt_id = (:twt_id)";

public DAO_ver2(NamedParameterJdbcTemplate template) { this.template = template;}

private final NamedParameterJdbcTemplate template;

public String addTweet (String message){

    System.out.println("Message received: " + message);
    Map<String, Object> paramMap = new HashMap();
    paramMap.put("tweet", message);
    template.update(INSERT_QUERY, paramMap);
    return "ok";
}

public List<Model_ver2> getTweets(){

    System.out.println("Messages");
    return template.query(SELECT_QUERY, BeanPropertyRowMapper.newInstance(Model_ver2.class));
}

    public int deleteTweet( Long twt_id) {
    System.out.println("Tweet deleted by ID: " + twt_id);
    Map<String, Object> paramMap = new HashMap();
    paramMap.put("twt_id", twt_id);
     return   template.update(DELETE_QUERY, paramMap);
}

    public int likeTweet(Long twt_id) {
        System.out.println("Tweet  liked by 1 with ID: " + twt_id);
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("twt_id", twt_id);
        return template.update(SELECT_LIKE_QUERY, paramMap);
    }
}
