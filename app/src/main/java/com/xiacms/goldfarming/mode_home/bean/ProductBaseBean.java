package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;

/**
 * 商品基类
 */

public class ProductBaseBean implements Serializable {
    private int id;                     // 商品ID
    private String name;                // 商品名称
    private String price;               // 商品价格
    private String oldPrice;            // 商品原价
    private String imageUrl;            // 商品图片地址

    public ProductBaseBean() {
    }

    public ProductBaseBean(int id, String name, String price, String oldPrice, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.imageUrl = imageUrl;
    }

    public ProductBaseBean(String name, String price, String oldPrice, String imageUrl) {
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.imageUrl = imageUrl;
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
        return "ProductBaseBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
