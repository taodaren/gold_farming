package com.xiacms.goldfarming.mode_cart.bean;

import com.xiacms.goldfarming.mode_home.bean.ProductDetailsBean;

import java.io.Serializable;

public class CartBean implements Serializable {

    private int id=0;
    private String userName;
    private int goodsId;
    private int count;
    private boolean isChecked;
    private ProductDetailsBean goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public ProductDetailsBean getGoods() {
        return goods;
    }

    public void setGoods(ProductDetailsBean goods) {
        this.goods = goods;
    }


    public CartBean() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartBean)) return false;

        CartBean cartBean = (CartBean) o;

        return getId() == cartBean.getId();

    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "CartBean{" +
                "id=" + id +
                ", userName=" + userName +
                ", goodsId=" + goodsId +
                ", count=" + count +
                ", checked=" + isChecked +
                ", goods='" + goods + '\'' +
                '}';
    }
}
