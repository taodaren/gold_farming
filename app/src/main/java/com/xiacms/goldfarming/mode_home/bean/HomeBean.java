package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 首页所有网络数据集合实体类
 */

public class HomeBean implements Serializable {
    private List<BannerBean> bannerBeanList;
    private List<HomeJumpBean> jumpBeanList;
    private List<HomeNoticeBean> noticeBeanList;
    private List<HomeBackTimeBean> timeBeanList;
    private List<ProductBaseBean> tuijianBeanList;
    private List<ProductBaseBean> hotBeanList;
    private List<HomeShelfBean> shelfsBeanList;

    public HomeBean() {
    }

    public HomeBean(List<BannerBean> bannerBeanList, List<HomeJumpBean> jumpBeanList) {
        this.bannerBeanList = bannerBeanList;
        this.jumpBeanList = jumpBeanList;
    }

    public HomeBean(List<BannerBean> bannerBeanList, List<HomeJumpBean> jumpBeanList, List<HomeNoticeBean> noticeBeanList, List<HomeBackTimeBean> timeBeanList, List<ProductBaseBean> tuijianBeanList, List<ProductBaseBean> hotBeanList, List<HomeShelfBean> shelfsBeanList) {
        this.bannerBeanList = bannerBeanList;
        this.jumpBeanList = jumpBeanList;
        this.noticeBeanList = noticeBeanList;
        this.timeBeanList = timeBeanList;
        this.tuijianBeanList = tuijianBeanList;
        this.hotBeanList = hotBeanList;
        this.shelfsBeanList = shelfsBeanList;
    }

    public List<BannerBean> getBannerBeanList() {
        return bannerBeanList;
    }

    public void setBannerBeanList(List<BannerBean> bannerBeanList) {
        this.bannerBeanList = bannerBeanList;
    }

    public List<HomeJumpBean> getJumpBeanList() {
        return jumpBeanList;
    }

    public void setJumpBeanList(List<HomeJumpBean> jumpBeanList) {
        this.jumpBeanList = jumpBeanList;
    }

    public List<HomeNoticeBean> getNoticeBeanList() {
        return noticeBeanList;
    }

    public void setNoticeBeanList(List<HomeNoticeBean> noticeBeanList) {
        this.noticeBeanList = noticeBeanList;
    }

    public List<HomeBackTimeBean> getTimeBeanList() {
        return timeBeanList;
    }

    public void setTimeBeanList(List<HomeBackTimeBean> timeBeanList) {
        this.timeBeanList = timeBeanList;
    }

    public List<ProductBaseBean> getTuijianBeanList() {
        return tuijianBeanList;
    }

    public void setTuijianBeanList(List<ProductBaseBean> tuijianBeanList) {
        this.tuijianBeanList = tuijianBeanList;
    }

    public List<ProductBaseBean> getHotBeanList() {
        return hotBeanList;
    }

    public void setHotBeanList(List<ProductBaseBean> hotBeanList) {
        this.hotBeanList = hotBeanList;
    }

    public List<HomeShelfBean> getShelfsBeanList() {
        return shelfsBeanList;
    }

    public void setShelfsBeanList(List<HomeShelfBean> shelfsBeanList) {
        this.shelfsBeanList = shelfsBeanList;
    }

    @Override
    public String toString() {
        return "HomeBean{" +
                "bannerBeanList=" + bannerBeanList +
                ", jumpBeanList=" + jumpBeanList +
                ", noticeBeanList=" + noticeBeanList +
                ", timeBeanList=" + timeBeanList +
                ", tuijianBeanList=" + tuijianBeanList +
                ", hotBeanList=" + hotBeanList +
                ", shelfsBeanList=" + shelfsBeanList +
                '}';
    }
}
