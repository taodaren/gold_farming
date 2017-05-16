package com.xiacms.goldfarming.global;

/**
 * 全局接口参数
 */

public interface I {
    String SERVER_URL                  = "http://a.net75.com/android";                                                 // 服务器主域名
    String MD5_URL                     = "1c3d5ffa75157b4ec3fc67df50fbd34f";                                           // MD5写死
    String HOMEPAGE_URL                = "/homepage";                                                                  // 首页接口
    String HOMEPAGE_BANNER_IMG         = "/index/banner/sign/" + MD5_URL;
    String HOMEPAGE_GOLD_SHELF         = "/goods/index/sign/" + MD5_URL + "/type/best/number/5";
    String CATEGORY_GROUP_URL          = "/category/index/sign/" + MD5_URL;                                            // 一级分类接口
    String CATEGORY_CHILD_URL          = "/goods/category/sign/" + MD5_URL + "/categoryId/0/page/1";                   // 二级分类接口
    String CART_URL                    = "/cart";                                                                      // 购物车接口
    String MINE_URL                    = "/mine";                                                                      // 我的接口
    String DOWNLOAD_IMG_URL            = "";

    String ACTION_HP_BANNER                              =                                      "BANNER";
    String ACTION_HP_CATEJUMP                            =                                      "CATEJUMP";
    String ACTION_HP_NOTICE                              =                                      "NOTICE";
    String ACTION_HP_UNTIME                              =                                      "UNTIME";
    String ACTION_HP_GOLD_TJ                             =                                      "GOLD_TJ";
    String ACTION_HP_HOTSEET                             =                                      "HOTSEET";
    String ACTION_HP_GOLD_SHELF                          =                                      "GOLD_SHELF";

    /** 刷新数据*/
    int ACTION_FIRST_LOAD                                =                                       11;                   // 首次加载
    int ACTION_PULL_UP                                   =                                       12;                   // 上拉刷新
    int ACTION_PULL_DOWN                                 =                                       13;                   // 下拉加载
    int PAGE_SIZE_DEFAULT                                =                                       14;                   // 分页的每页数量默认值

    /** 表示列表项布局的两种类型*/
    int TYPE_ITEM                                        =                                      101;                   // 列表项
    int TYPE_LOADING                                     =                                      102;                   // 加载更多数据

    /** 首页 Recycler item 类型*/
    //轮播活动
    int TYPE_HOME_BANNER = 0;
    //搜索商品
    int TYPE_HOME_FIND = 1;
    //显示分类
    int TYPE_HOME_CHANNEL = 2;
    //通知消息
    int TYPE_HOME_NOTICE = 3;
    //限时抢购
    int TYPE_HOME_UNTIME = 4;
    //推荐标题
    int TYPE_HOME_BOUND_RECOMMEND = 5;
    //金品推荐
    int TYPE_HOME_RECOMMEND = 6;
    //热销标题
    int TYPE_HOME_BOUND_HOT = 7;
    //热销种子
    int TYPE_HOME_HOT = 8;
    //推荐标题
    int TYPE_HOME_BOUND_SHELF = 9;
    //金品货架
    int TYPE_HOME_SHELF = 10;

    /** 跳转请求码*/
    int REQUEST_CODE_REGISTER                            =                                      601;
    int REQUEST_CODE_LOGIN                               =                                      602;
    int REQUEST_CODE_NICK                                =                                      603;
    int REQUEST_CODE_LOGIN_FROM_CART                     =                                      604;
    int REQUEST_CODE_COLLECT                             =                                      605;
    int REQUEST_CODE_ORDER                               =                                      606;

    /** 其它常量*/
    String UTF_8                                         =                                  "utf-8";                   // utf_8 编码方式

    interface CategoryGroup {
        String ID = "id";
        String NAME = "name";
        String IMAGE_URL = "image_url";
    }

    interface CategoryChild extends CategoryGroup {
        String PARENT_ID = "parent_id";
        String PRICE = "price";
        String OLD_PRICE = "old_price";
    }

    /** 商品 */
    interface Product {
        String PRODUCT_ID = "product_id";
    }

}
