package com.xiacms.goldfarming.global;

/**
 * 所有域名类：url 网络地址
 */

public class Constans {

    /**全局**/
    //服务器主域名
    public static String SERVER_URL = "http://a.net75.com/android";
    //MD5写死
    public static String MD5_URL = "1c3d5ffa75157b4ec3fc67df50fbd34f";

    /**首页**/
    //图片轮播
    public static String HOME_BANNER_URL = SERVER_URL + "/index/banner/sign/" + MD5_URL;
    //分类跳转
    public static String HOME_CHANNEL_URL = SERVER_URL + "/index/category/sign/" + MD5_URL;
    //活动通知
    public static String HOME_NOTICE_URL = SERVER_URL + "/index/notice/sign/" + MD5_URL;
    //限时抢购
    public static String HOME_TIME_URL = SERVER_URL + "/index/backTime/sign/" + MD5_URL;
    //金品推荐
    public static String HOME_RECOMMEND_URL = SERVER_URL + "/goods/basicData/sign/" + MD5_URL;
    //热销种子
    public static String HOME_HOT_URL = SERVER_URL + "/goods/index/sign/" + MD5_URL + "/type/hot/number/3";
    //金品货架
    public static String HOME_GOLD_SHELF_URL = SERVER_URL + "/index/bestGoods/sign/" + MD5_URL;

    /**分类**/
    //一级分类接口
    public static String TYPE_LEFT_URL = SERVER_URL + "/category/index/sign/" + MD5_URL;
    //二级分类接口
    public static String TYPE_RIGHT_INIT_URL = SERVER_URL + "/goods/category/sign/" + MD5_URL + "/categoryId/0/page/1";
    public static String TYPE_RIGHT_URL = SERVER_URL + "/goods/category/sign/" + MD5_URL + "/categoryId/";
    public static String TYPE_RIGHT_URL_SUFFIX = "/page/1";

    /**其他**/
    //商品详情
    public static String PRO_DETAILS_URL = SERVER_URL + "/goods/detail/sign/" + MD5_URL + "/id/1";

}
