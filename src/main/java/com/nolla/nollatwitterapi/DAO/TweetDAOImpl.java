package com.nolla.nollatwitterapi.DAO;

import com.nolla.nollatwitterapi.Model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.util.*;

@Repository
public class TweetDAOImpl implements TweetDAO {
    //columns
    private static final String TWEET_ID = "twt_id";
    private static final String USR_ID = "usr_id";
    private static final String UPDATED_TWT = "updated_twt";
    private static final String LIKES_TWT = "likes_twt";
    private static final String CONTENT_TWT = "content_twt";
    private static final String CREATED_TWT = "created_twt";

    //queries
    private static final String FIND_BY_TWT_ID = "SELECT * FROM tweets WHERE twt_id = (:twt_id)";
    private static final String FIND_BY_USR_ID = "SELECT * FROM tweets WHERE usr_id = (:usr_id)";
    private static final String FIND_ALL = "SELECT * FROM tweets";
    private static final String UPDATE = "INSERT INTO tweets (usr_id, content_twt) " + "VALUES (:usr_id, :content_twt)";
    private static final String DELETE = "DELETE FROM tweets WHERE twt_id = :twt_id";


    //mappers
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final RowMapper<Tweet> TWEET_ROW_MAPPER = ((rs, rowNum) ->
            new Tweet(rs.getLong(TWEET_ID),
                    rs.getLong(USR_ID),
                    rs.getTimestamp(UPDATED_TWT).toLocalDateTime(),
                    rs.getTimestamp(CREATED_TWT).toLocalDateTime(),
                    rs.getLong(LIKES_TWT),
                    rs.getArray(CONTENT_TWT)

            )
    );


    @Autowired
    public TweetDAOImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Tweet> findById(Long tweetId) {
        return namedParameterJdbcTemplate.query(FIND_BY_TWT_ID, new MapSqlParameterSource(TWEET_ID, tweetId), TWEET_ROW_MAPPER).stream().findFirst();

    }

    public List<Tweet> findByUser(Long userId){
        return namedParameterJdbcTemplate.query(FIND_BY_USR_ID, new MapSqlParameterSource(USR_ID, userId), TWEET_ROW_MAPPER);
    }

    public List<Tweet> findAll(Array content_twt){
        return namedParameterJdbcTemplate.query(FIND_ALL, TWEET_ROW_MAPPER);
}

    public void save(Long userId, Array content_twt){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue(USR_ID, userId).addValue(CONTENT_TWT, content_twt);
        namedParameterJdbcTemplate.update(UPDATE,parameterSource);

    }

    public void delete(Long tweetId){
        namedParameterJdbcTemplate.update(DELETE, new MapSqlParameterSource(TWEET_ID, tweetId));

    }
}