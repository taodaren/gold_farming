package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;

/**
 * Created by Dell on 2017/5/12.
 */

public class HomeHotBean implements Serializable {

    /**
     * productBase : {"id":13,"name":"1","price":"1.00","oldPrice":"1.00","imageUrl":"http://a.net75.com/public/uploads/images/osc1/1/1.jpg"}
     * freight :
     * location :
     * features :
     * note :
     * dosage :
     * appPro : 商品评价
     * appRate :
     * appUser :
     */

    private ProductBaseBean productBase;
    private String freight;
    private String location;
    private String features;
    private String note;
    private String dosage;
    private String appPro;
    private String appRate;
    private String appUser;

    public ProductBaseBean getProductBase() {
        return productBase;
    }

    public void setProductBase(ProductBaseBean productBase) {
        this.productBase = productBase;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getAppPro() {
        return appPro;
    }

    public void setAppPro(String appPro) {
        this.appPro = appPro;
    }

    public String getAppRate() {
        return appRate;
    }

    public void setAppRate(String appRate) {
        this.appRate = appRate;
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    public static class ProductBaseBean {
        /**
         * id : 13
         * name : 1
         * price : 1.00
         * oldPrice : 1.00
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
