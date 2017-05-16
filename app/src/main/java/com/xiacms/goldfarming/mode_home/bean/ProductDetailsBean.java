package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;

/**
 * 商品详情实体类
 */

public class ProductDetailsBean implements Serializable {

    /**
     * id : 1
     * name : 艺创 青花甜白三才大盖碗功夫茶具敬茶陶瓷泡茶器
     * price : 49.00
     * oldPrice : 49.00
     * imageUrl : http://a.net75.com/public/uploads/images/osc1/1/1.jpg
     * freight : 免运费
     * location : 北京
     * features : 耐热，耐湿株型较直立，生长快速，外叶嫩绿色，叶片厚，叶面无刺毛，叶柄白色而宽平，品质极佳，可做苗菜栽培。
     * note : 选择前作非十字花科蔬菜，土壤肥沃，水利条件较好的地块。施足基肥，作小白菜栽培时，采用撒播亩用种量400－450g。作半结球白菜栽培时，采收条播亩用种量150g。及时追肥，浇水要掌握轻浇，勤浇的原则，切不能大水漫灌，加强病虫害防治，及时采收。
     * dosage : 400－450g
     * appPro : 商品评价
     * appRate :
     * appUser :
     */

    private int id;
    private String name;
    private String price;
    private String oldPrice;
    private String imageUrl;
    private String freight;
    private String location;
    private String features;
    private String note;
    private String dosage;
    private String appPro;
    private String appRate;
    private String appUser;

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
}
