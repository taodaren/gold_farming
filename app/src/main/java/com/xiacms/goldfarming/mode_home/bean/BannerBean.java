package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;

/**
 * 首页轮播实体类
 */

public class BannerBean implements Serializable {
    private String imgUrlBanner;

    public BannerBean() {
    }

    public BannerBean(String imgUrlBanner) {
        this.imgUrlBanner = imgUrlBanner;
    }

    public String getImgUrlBanner() {
        return imgUrlBanner;
    }

    public void setImgUrlBanner(String imgUrlBanner) {
        this.imgUrlBanner = imgUrlBanner;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "imgUrlBanner='" + imgUrlBanner + '\'' +
                '}';
    }
}
