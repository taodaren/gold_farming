package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;

/**
 * 首页 通知消息实体类
 */

public class HomeNoticeBean implements Serializable {
    // 通知消息
    private String notice;

    public HomeNoticeBean() {
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "HomeNoticeBean{" +
                "notice='" + notice + '\'' +
                '}';
    }
}
