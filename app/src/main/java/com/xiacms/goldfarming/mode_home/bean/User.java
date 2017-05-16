package com.xiacms.goldfarming.mode_home.bean;

/**
 * 用户信息实体类
 */

public class User {
    private String userName;                        // 用户名
    private String userNick;                        // 昵称
    private int avatarId;                           // 头像 ID
    private String avatarPath;                      // 头像地址
    private String avatarSuffix;                    // 头像后缀名
    private String avatarLastUpdateTime;            // 头像最后更新时间

    public User(String userName, String userNick, int avatarId, String avatarPath, String avatarSuffix, String avatarLastUpdateTime) {
        this.userName = userName;
        this.userNick = userNick;
        this.avatarId = avatarId;
        this.avatarPath = avatarPath;
        this.avatarSuffix = avatarSuffix;
        this.avatarLastUpdateTime = avatarLastUpdateTime;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getAvatarSuffix() {
        return avatarSuffix;
    }

    public void setAvatarSuffix(String avatarSuffix) {
        this.avatarSuffix = avatarSuffix;
    }

    public String getAvatarLastUpdateTime() {
        return avatarLastUpdateTime;
    }

    public void setAvatarLastUpdateTime(String avatarLastUpdateTime) {
        this.avatarLastUpdateTime = avatarLastUpdateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userNick='" + userNick + '\'' +
                ", avatarId=" + avatarId +
                ", avatarPath='" + avatarPath + '\'' +
                ", avatarSuffix='" + avatarSuffix + '\'' +
                ", avatarLastUpdateTime='" + avatarLastUpdateTime + '\'' +
                '}';
    }
}
