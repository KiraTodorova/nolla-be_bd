package com.nolla.nollatwitterapi.Model;
import java.sql.Array;
import java.time.LocalDateTime;
public class Tweet {
    private Long twt_id;
    private Long usr_id;
    private LocalDateTime updated_twt;
    private Long likes_twt;
    private Array content_twt;
    private LocalDateTime created_twt;
    public Long getUsr_id() {
        return usr_id;
    }
    public void setUsr_id(Long usr_id) {
        this.usr_id = usr_id;
    }
    public LocalDateTime getUpdated_twt() {
        return updated_twt;
    }
    public void setUpdated_twt(LocalDateTime updated_twt) {
        this.updated_twt = updated_twt;
    }
    public LocalDateTime getCreated_twt() {
        return created_twt;
    }
    public void setCreated_twt(LocalDateTime created_twt) {
        this.created_twt = created_twt;
    }
    public Long getLikes_twt() {
        return likes_twt;
    }
    public void setLikes_twt(Long likes_twt) {
        this.likes_twt = likes_twt;
    }
    public Array getContent_twt() {
        return content_twt;
    }
    public void setContent_twt(Array content_twt) {
        this.content_twt = content_twt;
    }
    public Tweet(Long twt_id, Long usr_id, LocalDateTime created_twt, LocalDateTime updated_twt, Long likes_twt, Array content_twt) {
        this.twt_id = twt_id;
        this.usr_id = usr_id;
        this.created_twt = created_twt;
        this.updated_twt = updated_twt;
        this.likes_twt =  likes_twt;
        this.content_twt = content_twt;
    }
    public Long getTwt_id() {
        return twt_id;
    }
    public void setTwt_id(Long twt_id) {
        this.twt_id = twt_id;
    }
}