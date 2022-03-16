package com.nolla.nollatwitterapi.Model;

import java.time.LocalDateTime;

public class Model_ver2 {
    private Long twt_id;
    private LocalDateTime created_twt;
    private String content_twt;

    public Long getTwt_id() {
        return twt_id;
    }

    public void setTwt_id(Long twt_id) {
        this.twt_id = twt_id;
    }

    public LocalDateTime getCreated_twt() {
        return created_twt;
    }

    public void setCreated_twt(LocalDateTime created_twt) {
        this.created_twt = created_twt;
    }

    public String getContent_twt() {
        return content_twt;
    }

    public void setContent_twt(String content_twt) {
        this.content_twt = content_twt;
    }
}
