package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;

/**
 * Created by Dell on 2017/5/8.
 */

public class HomeJumpBean implements Serializable {
    private int id;

    private String name;

    private String imageUrl;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
}
