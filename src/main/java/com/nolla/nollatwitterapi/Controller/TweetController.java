package com.nolla.nollatwitterapi.Controller;
import com.nolla.nollatwitterapi.DAO.DAO_ver2;
import com.nolla.nollatwitterapi.Model.Model_ver2;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class TweetController {
    private DAO_ver2 tweetDao;

    @Autowired
    public TweetController(DAO_ver2 tweetDao){
        this.tweetDao = tweetDao;
    }


    @GetMapping("/fetchTweet")
    public Model_ver2 getTweets(String content_twt) throws ExecutionException, InterruptedException {
        return tweetDao.getTweets(content_twt);
    }

    @PostMapping("/saveTweet")
    public String saveTweet(@RequestBody String tweet) throws ExecutionException, InterruptedException {
        System.out.println("Received: " + tweet);
        tweetDao.addTweet(tweet);
        return "ok";
    }

    @DeleteMapping("/deleteTweet/{twt_id}")
    public Long deleteTweet(@PathVariable Long twt_id) {
        System.out.println("Deleted: " + twt_id);
        tweetDao.deleteTweet(twt_id);
        return twt_id;


    }

    @PutMapping("/likeTweet/{twt_id}")
    public Long addLikeTweet(@PathVariable Long twt_id) throws ExecutionException, InterruptedException {
        System.out.println("Tweet Liked with: " + twt_id);
        tweetDao.likeTweet(twt_id);
        return twt_id;
    }
}