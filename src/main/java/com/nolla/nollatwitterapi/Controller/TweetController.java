package com.nolla.nollatwitterapi.Controller;
import com.nolla.nollatwitterapi.DAO.DAO_ver2;
import com.nolla.nollatwitterapi.Model.Model_ver2;
import java.util.List;

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
    public List<Model_ver2> fetchTweet() {
        return tweetDao.getTweets();
    }

    @PostMapping("/saveTweet")
    public String saveTweet(@RequestBody String tweet) {
        System.out.println("Received: " + tweet);
        tweetDao.addTweet(tweet);
        return "ok";
    }
}