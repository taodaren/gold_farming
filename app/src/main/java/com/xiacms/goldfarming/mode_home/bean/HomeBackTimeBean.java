package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;

/**
 * 首页 限时抢购实体类
 */

public class HomeBackTimeBean implements Serializable {
    //限时抢购商品图片地址
    private String backTimeImg;
    //显示抢购剩余时间（后台传入倒计时秒数）
    private long backTime;

    public HomeBackTimeBean() {
    }

    public String getBackTimeImg() {
        return backTimeImg;
    }

    public void setBackTimeImg(String backTimeImg) {
        this.backTimeImg = backTimeImg;
    }

    public long getBackTime() {
        return backTime;
    }

    public void setBackTime(long backTime) {
        this.backTime = backTime;
    }

    @Override
    public String toString() {
        return "HomeBackTimeBean{" +
                "backTimeImg='" + backTimeImg + '\'' +
                ", backTime=" + backTime +
                '}';
    }
}
