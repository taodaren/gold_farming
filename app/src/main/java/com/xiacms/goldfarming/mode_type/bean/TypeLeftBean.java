package com.xiacms.goldfarming.mode_type.bean;

import java.io.Serializable;

/**
 * 分类一级页面实体类
 */

public class TypeLeftBean implements Serializable {
    private int id;                 // 分类名ID
    private String name;            // 分类名称
    private String imageUrl;        // 分类地址

    public TypeLeftBean() {
    }

    public TypeLeftBean(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "TypeLeftBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
