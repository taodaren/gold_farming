package com.xiacms.goldfarming.mode_home.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.activity.MyMsgActivity;
import com.xiacms.goldfarming.base.BaseFragment;
import com.xiacms.goldfarming.global.MFGT;
import com.xiacms.goldfarming.mode_home.adapter.HomeRecycleAdapter;
import com.xiacms.goldfarming.global.Constans;
import com.xiacms.goldfarming.mode_home.bean.BannerBean;
import com.xiacms.goldfarming.mode_home.bean.HomeBackTimeBean;
import com.xiacms.goldfarming.mode_home.bean.HomeHotBean;
import com.xiacms.goldfarming.mode_home.bean.HomeShelfBean;
import com.xiacms.goldfarming.mode_home.bean.HomeJumpBean;
import com.xiacms.goldfarming.mode_home.bean.HomeNoticeBean;
import com.xiacms.goldfarming.mode_home.bean.ProductBaseBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = Bat_HomeFragment.class.getSimpleName();

    //标题右侧消息
    private ImageView imgTitleMsg;
    //Recycler容器
    private RecyclerView rvHomepage;
    //置顶按钮
    private ImageView imgBackTop;

    /**
     * 返回的数据
     **/
    //顶部图片轮播
    private List<BannerBean> hpBannerBean;
    //分类跳转
    private List<HomeJumpBean> hpJumpBean;
    //通知消息
    private List<HomeNoticeBean> hpNoticeBean;
    //限时抢购
    private HomeBackTimeBean hpTimeBean;
    //金品推荐
    private ProductBaseBean hpRecommend;
    //热销种子
    private List<HomeHotBean.ProductBaseBean> hpHotSeedBean;
    //金品货架
    private List<HomeShelfBean> hpGoldShelf;
    //首页适配器
    private HomeRecycleAdapter hpAdapter;

    @Override
    public View initView() {
        View inflate = View.inflate(mContext, R.layout.fragment_home, null);

        //初始化布局控件
        imgTitleMsg = (ImageView) inflate.findViewById(R.id.homepage_image_message);
        rvHomepage = (RecyclerView) inflate.findViewById(R.id.homepage_recycler);
        imgBackTop = (ImageView) inflate.findViewById(R.id.image_to_top);

        //设置点击事件
        imgTitleMsg.setOnClickListener(this);
        rvHomepage.setOnClickListener(this);
        imgBackTop.setOnClickListener(this);

        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
        //联网请求首页数据
        getDataFromNet();
        //将数据传入到Adapter进行展示，设置数据及布局管理
        sendAdapterSetLayout();
    }

    /**
     * 通过网络后台请求首页数据
     */
    private void getDataFromNet() {
        getDataBanner();
        getDataChannel();
        getDataNotice();
        getDataUntime();
        getDataRecommend();
        getDataHot();
        getDataShelf();
    }

    /**
     * 将数据传入到Adapter进行展示，设置数据及布局管理
     */
    private void sendAdapterSetLayout() {
        if (hpBannerBean != null && hpJumpBean != null
                && hpNoticeBean != null && hpTimeBean != null
                && hpRecommend != null && hpHotSeedBean != null
                && hpGoldShelf != null) {

            //有数据就设置适配器
            hpAdapter = new HomeRecycleAdapter(mContext, hpBannerBean, hpJumpBean, hpNoticeBean, hpTimeBean, hpHotSeedBean, hpGoldShelf);
            rvHomepage.setAdapter(hpAdapter);

            GridLayoutManager manager = new GridLayoutManager(mContext, 1);

            //设置跨度大小监听器（设置滑动到哪个位置了的监听）
            manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position <= 3) {
                        //隐藏
                        imgBackTop.setVisibility(View.GONE);
                    } else {
                        //显示
                        imgBackTop.setVisibility(View.VISIBLE);
                    }
                    //只能返回1
                    return 1;
                }
            });
            //设置布局管理者
            rvHomepage.setLayoutManager(manager);
        } else {
            //没有数据
            Toast.makeText(mContext, "没有数据传递", Toast.LENGTH_SHORT).show();
        }
    }

    private void getDataBanner() {
        OkHttpUtils.get().url(Constans.HOME_BANNER_URL).build().execute(new StringCallback() {
            //请求失败的时候回调
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "onError: 首页 Banner 数据请求失败==" + e.getMessage());
            }

            //请求成功的时候回调
            //response:请求成功数据(json)
            @Override
            public void onResponse(String response, int id) {
//                Log.e(TAG, "onResponse: 首页 Banner 数据请求成功==" + response);
                //解析数据
                hpBannerBean = JSONArray.parseArray(response, BannerBean.class);
//                Log.e(TAG, "processData: 解析 Banner 数据成功==" + hpBannerBean.size());
            }
        });
    }

    private void getDataChannel() {
        OkHttpUtils.get().url(Constans.HOME_CHANNEL_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "onError: 首页 Channel 数据请求失败==" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
//                Log.e(TAG, "onResponse: 首页 Channel 数据请求成功==" + response);
                //解析数据
                hpJumpBean = JSONArray.parseArray(response, HomeJumpBean.class);
//                Log.e(TAG, "processData: 解析 Channel 成功==" + hpJumpBean.size());
            }
        });
    }

    private void getDataNotice() {
        OkHttpUtils.get().url(Constans.HOME_NOTICE_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "onError: 首页 notice 数据请求失败==" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
//                Log.e(TAG, "onResponse: 首页 notice 数据请求成功==" + response);
                //解析数据
                hpNoticeBean = JSONArray.parseArray(response, HomeNoticeBean.class);
//                Log.e(TAG, "processData: 解析 notice 数据成功==" + hpNoticeBean.size());
            }
        });
    }

    private void getDataUntime() {
        OkHttpUtils.get().url(Constans.HOME_TIME_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "onError: 首页 kill time 数据请求失败==" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
//                Log.e(TAG, "onResponse: 首页 kill time 数据请求成功==" + response);
                //解析数据（非数组）
                hpTimeBean = JSON.parseObject(response, HomeBackTimeBean.class);
//                Log.e(TAG, "processData: 解析 kill time 数据成功==" + hpTimeBean.getBackTime());
            }
        });
    }

    private void getDataRecommend() {
        OkHttpUtils.get().url(Constans.HOME_RECOMMEND_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "onError: 首页 recommend 数据请求失败==" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
//                Log.e(TAG, "onResponse: 首页 recommend 数据请求成功==" + response);
                //解析数据
                hpRecommend = JSON.parseObject(response, ProductBaseBean.class);
//                Log.e(TAG, "processData: 解析 recommend 数据成功==" + hpRecommend.getName());
            }
        });
    }

    private void getDataHot() {
        OkHttpUtils.get().url(Constans.HOME_HOT_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "onError: 首页 hot 数据请求失败==" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
//                Log.e(TAG, "onResponse: 首页 hot 数据请求成功==" + response);
                //解析数据
                hpHotSeedBean = JSONArray.parseArray(response, HomeHotBean.ProductBaseBean.class);
//                Log.e(TAG, "processData: 解析 hot 数据成功==" + hpHotSeedBean.size());
            }
        });
    }

    private void getDataShelf() {
        OkHttpUtils.get().url(Constans.HOME_GOLD_SHELF_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "onError: 首页 shelf 数据请求失败==" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
//                Log.e(TAG, "onResponse: 首页 shelf 数据请求成功==" + response);
                //解析数据
                hpGoldShelf = JSONArray.parseArray(response, HomeShelfBean.class);
//                Log.e(TAG, "processData: 解析 shelf 数据成功==" + hpGoldShelf.size());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //消息监听
            case R.id.homepage_image_message:
                MFGT.gotoTitleMsg(mContext, MyMsgActivity.class);
                break;
            //置顶的监听
            case R.id.image_to_top:
                //回到顶部
                rvHomepage.scrollToPosition(0);
                break;
        }
    }

}
