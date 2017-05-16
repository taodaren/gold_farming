package com.xiacms.goldfarming.mode_type.bean;

import java.io.Serializable;

/**
 * 分类二级页面实体类
 */

public class TypeRightBean implements Serializable {
    private int id;
    private int parentId;               // 对应一级分类ID
    private String name;                // 商品名称
    private String price;               // 商品价格
    private String oldPrice;            // 商品原价
    private String imageUrl;            // 商品图片地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "TypeRightBean{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
