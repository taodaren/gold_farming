package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;

/**
 * 首页 金品货架实体类
 */

public class HomeShelfBean implements Serializable {

    /**
     * discount : 5
     * surplus : 1
     * productBase : {"id":13,"name":"1","price":"1.00","oldPrice":"2.00","imageUrl":"http://a.net75.com/public/uploads/images/osc1/1/1.jpg"}
     */

    private int discount;
    private int surplus;
    private ProductBaseBean productBase;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public ProductBaseBean getProductBase() {
        return productBase;
    }

    public void setProductBase(ProductBaseBean productBase) {
        this.productBase = productBase;
    }

    public static class ProductBaseBean {
        /**
         * id : 13
         * name : 1
         * price : 1.00
         * oldPrice : 2.00
         * imageUrl : http://a.net75.com/public/uploads/images/osc1/1/1.jpg
         */

        private int id;
        private String name;
        private String price;
        private String oldPrice;
        private String imageUrl;

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
    }
}
