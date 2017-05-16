package com.xiacms.goldfarming.mode_home.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.activity.MyMsgActivity;
import com.xiacms.goldfarming.activity.ProductDetailsActivity;
import com.xiacms.goldfarming.global.Constans;
import com.xiacms.goldfarming.global.I;
import com.xiacms.goldfarming.global.MFGT;
import com.xiacms.goldfarming.mode_home.bean.BannerBean;
import com.xiacms.goldfarming.mode_home.bean.HomeBackTimeBean;
import com.xiacms.goldfarming.mode_home.bean.HomeHotBean;
import com.xiacms.goldfarming.mode_home.bean.HomeShelfBean;
import com.xiacms.goldfarming.mode_home.bean.HomeJumpBean;
import com.xiacms.goldfarming.mode_home.bean.HomeNoticeBean;
import com.xiacms.goldfarming.mode_home.bean.ProductBaseBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.RotateDownTransformer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 首页适配器
 */

public class HomeRecycleAdapter extends RecyclerView.Adapter {
    private static final String TAG = "HomeRecycleAdapter";
    //上下文
    private Context mContext;

    //当前类型
    private int currentType = I.TYPE_HOME_BANNER;

    //用于初始化布局
    private LayoutInflater mLayoutInflater;

    //数据对象
    private List<BannerBean> bannerBeanList = new ArrayList<>();
    private List<HomeJumpBean> cateJumpBeanList = new ArrayList<>();
    private List<HomeNoticeBean> noticeBeanList = new ArrayList<>();
    private HomeBackTimeBean backTimeBeanList;
    private List<ProductBaseBean> goldBeanList = new ArrayList<>();
    private List<HomeHotBean.ProductBaseBean> hotSeekBeenList = new ArrayList<>();
    private List<HomeShelfBean> goldShelfList = new ArrayList<>();

    public HomeRecycleAdapter(Context mContext,
                              List<BannerBean> bannerBeanList,
                              List<HomeJumpBean> jumpBeanList,
                              List<HomeNoticeBean> noticeBeanList,
                              HomeBackTimeBean timeBeen,
                              List<HomeHotBean.ProductBaseBean> hotSeekBeenList,
                              List<HomeShelfBean> shelfBeanList) {
        this.mContext = mContext;
        this.bannerBeanList = bannerBeanList;
        this.cateJumpBeanList = jumpBeanList;
        this.noticeBeanList = noticeBeanList;
        this.backTimeBeanList = timeBeen;
        this.hotSeekBeenList = hotSeekBeenList;
        this.goldShelfList = shelfBeanList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
//    public HomeRecycleAdapter(Context mContext, Map<String,Object> homepageBeanList) {
//        this.mContext = mContext;
//        this.homepageBeenList = homepageBeanList;
//        mLayoutInflater = LayoutInflater.from(mContext);
//    }

    //是否有更多
//    private boolean isMore;

//    private int totalCount = 0; // 总数


//    public boolean isMore() {
//        return isMore;
//    }
//
//    public void setMore(boolean more) {
//        isMore = more;
//    }
//
//    private int getLoadingString() {
//        return isMore ? R.string.load_more : R.string.no_more;
//    }

    @Override
    public int getItemCount() {
        return 11;
    }

    /**
     * 根据位置得到类型-系统调用
     *
     * @param position 位置
     * @return 类型
     */
    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case I.TYPE_HOME_BANNER:
                currentType = I.TYPE_HOME_BANNER;
                break;
            case I.TYPE_HOME_FIND:
                currentType = I.TYPE_HOME_FIND;
                break;
            case I.TYPE_HOME_CHANNEL:
                currentType = I.TYPE_HOME_CHANNEL;
                break;
            case I.TYPE_HOME_NOTICE:
                currentType = I.TYPE_HOME_NOTICE;
                break;
            case I.TYPE_HOME_UNTIME:
                currentType = I.TYPE_HOME_UNTIME;
                break;
            case I.TYPE_HOME_BOUND_RECOMMEND:
                currentType = I.TYPE_HOME_BOUND_RECOMMEND;
                break;
            case I.TYPE_HOME_RECOMMEND:
                currentType = I.TYPE_HOME_RECOMMEND;
                break;
            case I.TYPE_HOME_BOUND_HOT:
                currentType = I.TYPE_HOME_BOUND_HOT;
                break;
            case I.TYPE_HOME_HOT:
                currentType = I.TYPE_HOME_HOT;
                break;
            case I.TYPE_HOME_BOUND_SHELF:
                currentType = I.TYPE_HOME_BOUND_SHELF;
                break;
            case I.TYPE_HOME_SHELF:
                currentType = I.TYPE_HOME_SHELF;
                break;
//            case I.TYPE_LOADING:
//                currentType = I.TYPE_LOADING;
//                break;
        }
        return currentType;
    }

    /**
     * 根据视图类型创建View Holder
     *
     * @param viewType 当前的视图类型
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case I.TYPE_HOME_BANNER://图片轮播
                //创建BannerViewHolder Banner里面传布局文件
                viewHolder = new BannerViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_home_banner, null));
                break;
            case I.TYPE_HOME_FIND://查询
                viewHolder = new FindViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_home_shape_find, null));
                break;
            case I.TYPE_HOME_CHANNEL://频道
                viewHolder = new ChannelViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_home_cate_jump, null));
                break;
            case I.TYPE_HOME_NOTICE://通知
                viewHolder = new FlipperViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_home_flipper, null));
                break;
            case I.TYPE_HOME_UNTIME://限时抢购
                viewHolder = new UntimeViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_home_untime, null));
                break;
            case I.TYPE_HOME_BOUND_RECOMMEND://推荐标题
                viewHolder = new RecommendBoundViewHolder(mContext, mLayoutInflater.inflate(R.layout.layout_home_bound, null));
                break;
            case I.TYPE_HOME_RECOMMEND://推荐
                viewHolder = new RecommendViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_home_recommend, null));
                break;
            case I.TYPE_HOME_BOUND_HOT://热销标题
                viewHolder = new HotBoundViewHolder(mContext, mLayoutInflater.inflate(R.layout.layout_home_bound, null));
                break;
            case I.TYPE_HOME_HOT://热销
                viewHolder = new HotViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_home_seed, null));
                break;
            case I.TYPE_HOME_BOUND_SHELF://货架标题
                viewHolder = new ShelfBoundViewHolder(mContext, mLayoutInflater.inflate(R.layout.layout_home_bound, null));
                break;
            case I.TYPE_HOME_SHELF://货架
                viewHolder = new ShelfViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_home_shelf, null));
                break;
//            case I.TYPE_LOADING:
//                viewHolder = new LoadingViewHolder(mContext,mLayoutInflater.inflate(R.layout.item_loading, null));
//                break;
        }
        return viewHolder;
    }

    /**
     * 绑定数据到View Holder
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case I.TYPE_HOME_BANNER:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                bannerViewHolder.setData(bannerBeanList);
                break;
            case I.TYPE_HOME_FIND:
                FindViewHolder findViewHolder = (FindViewHolder) holder;
                break;
            case I.TYPE_HOME_CHANNEL:
                ChannelViewHolder cateViewHolder = (ChannelViewHolder) holder;
                cateViewHolder.setData(cateJumpBeanList);
                break;
            case I.TYPE_HOME_NOTICE:
                FlipperViewHolder flipperViewHolder = (FlipperViewHolder) holder;

                flipperViewHolder.setData(noticeBeanList);
                break;
            case I.TYPE_HOME_UNTIME:
                UntimeViewHolder untimeViewHolder = (UntimeViewHolder) holder;
                untimeViewHolder.setData(backTimeBeanList);
                break;
            case I.TYPE_HOME_BOUND_RECOMMEND:
                RecommendBoundViewHolder recommendBoundViewHolder = (RecommendBoundViewHolder) holder;
                recommendBoundViewHolder.textView.setText("金品推荐");
                break;
            case I.TYPE_HOME_RECOMMEND:
                RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
                break;
            case I.TYPE_HOME_BOUND_HOT:
                HotBoundViewHolder hotBoundViewHolder = (HotBoundViewHolder) holder;
                hotBoundViewHolder.textView.setText("热销种子");
                break;
            case I.TYPE_HOME_HOT:
                HotViewHolder hotViewHolder = (HotViewHolder) holder;
                Log.e(TAG, "onBindViewHolder: =========================================================" + hotSeekBeenList);
                hotViewHolder.setData(hotSeekBeenList);
                break;
            case I.TYPE_HOME_BOUND_SHELF:
                ShelfBoundViewHolder shelfBoundViewHolder = (ShelfBoundViewHolder) holder;
                shelfBoundViewHolder.textView.setText("金品货架");
                break;
            case I.TYPE_HOME_SHELF:
                ShelfViewHolder shelfViewHolder = (ShelfViewHolder) holder;
                shelfViewHolder.setData(goldShelfList);
                break;
//            case I.TYPE_LOADING:
//                LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
//                loadingViewHolder.setTextLoading(getLoadingString());
//                break;
        }
    }


    class BannerViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private Banner hpBanner;

        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            hpBanner = (Banner) itemView.findViewById(R.id.homepage_banner);
        }

        public void setData(final List<BannerBean> bannerInfo) {
            //设置Banner数据 得到图片地址集合
            List<String> imagesUrl = new ArrayList<>();
            for (int i = 0; i < bannerInfo.size(); i++) {
                String imageUrl = bannerInfo.get(i).getImgUrlBanner();
                imagesUrl.add(imageUrl);
            }

            //设置Banner图片数据(新版banner偷懒使用方法)
            hpBanner.setImages(imagesUrl)
                    //设置循环指示点
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                    .setImageLoader(new GlideImageLoader())
                    .start();

            //设置点击事件
            hpBanner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(mContext, "position==" + position, Toast.LENGTH_SHORT).show();

                    if (position < bannerInfo.size()) {
                        String productId = "";
                        String name = "";
                        String price = "";
                        String priceOld = "";

                        switch (position) {
                            case 0:
                                productId = "9527";
                                name = "至尊宝";
                                price = "27";
                                priceOld = "95";
                                break;
                            case 1:
                                productId = "9528";
                                name = "隔壁老王";
                                price = "27";
                                priceOld = "95";
                                break;
                            case 2:
                                productId = "7259";
                                name = "犀利哥";
                                price = "27";
                                priceOld = "95";
                                break;
                            case 3:
                                productId = "7259";
                                name = "大冰";
                                price = "71";
                                priceOld = "105";
                                break;
                            case 4:
                                productId = "7259";
                                name = "格林";
                                price = "271";
                                priceOld = "505";
                                break;
                        }
                        String imageUrl = bannerInfo.get(position).getImgUrlBanner();
                        ProductBaseBean proBean = new ProductBaseBean();
                        proBean.setId(Integer.parseInt(productId));
                        proBean.setName(name);
                        proBean.setPrice(price);
                        proBean.setOldPrice(priceOld);
                        proBean.setImageUrl(imageUrl);
                    }

                    //跳转到商品信息界面
                    MFGT.gotoProductDetails(mContext, ProductDetailsActivity.class);
                }
            });
        }
    }

    class FindViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private EditText editFind;
        private TextView textFind;

        public FindViewHolder(final Context context, View itemView) {
            super(itemView);
            this.context = context;
            editFind = (EditText) itemView.findViewById(R.id.homepage_find_et);
            textFind = (TextView) itemView.findViewById(R.id.homepage_find);

            textFind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFGT.gotoTitleMsg(mContext, MyMsgActivity.class);//临时
                }
            });
        }
    }

    class ChannelViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private GridView gridChannel;
        private HomeCateAdapter adapter;

        public ChannelViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            gridChannel = (GridView) itemView.findViewById(R.id.homepage_cate_jump);
        }

        public void setData(List<HomeJumpBean> channelInfo) {
            // 得到数据后，就设置 GridView 的适配器
            adapter = new HomeCateAdapter(context, channelInfo);
            gridChannel.setAdapter(adapter);

            // 设置 item 的点击事件
            gridChannel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position <= 8) {
                        Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    class FlipperViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private ViewFlipper flipperMsg;
        private TextView textFlipper;

        public FlipperViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            flipperMsg = (ViewFlipper) itemView.findViewById(R.id.homepage_flipper);
            textFlipper = (TextView) itemView.findViewById(R.id.text_flipper);
        }

        public void setData(List<HomeNoticeBean> noticeInfo) {
            flipperMsg.addView(View.inflate(context, R.layout.layout_flipper_info, null));
        }
    }

    class UntimeViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private ImageView imageUntime;
        private TextView textTimeOver;
        private TextView textMore;

        private boolean isFirst;
        private long differTime = 0;//相差多少毫秒

        //设置倒计时
        private Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    differTime = differTime - 1000;
                    //设置具体的时间
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    textTimeOver.setText(simpleDateFormat.format(new Date(differTime)));

                    handler.removeMessages(0);
                    //发送消息，不断减时间
                    handler.sendEmptyMessageDelayed(0, 1000);
                    if (differTime == 0) {
                        //把消息移除
                        handler.removeMessages(0);
                    }
                }
            }
        };

        public UntimeViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            //初始化布局控件
            imageUntime = (ImageView) itemView.findViewById(R.id.homepage_image_untime);
            textTimeOver = (TextView) itemView.findViewById(R.id.text_time_over);
            textMore = (TextView) itemView.findViewById(R.id.text_more);
        }

        public void setData(HomeBackTimeBean untimeInfo) {
            //设置时间
            if (isFirst) {
//                differTime = untimeInfo.get(0).getBackTime() - System.currentTimeMillis();
                differTime = (int) (untimeInfo.getBackTime() - System.currentTimeMillis());
                isFirst = false;
            }
            //倒计时开始
            handler.sendEmptyMessageDelayed(0, 1000);
            //加载图片
            Glide.with(context)
                    .load(backTimeBeanList.getBackTimeImg())
                    .into(imageUntime);
        }
    }

    class RecommendBoundViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        TextView textView;

        public RecommendBoundViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            textView = (TextView) itemView.findViewById(R.id.homepage_title_bound);
        }
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        TextView name1;
        TextView price1;
        TextView oldPrice1;
        ImageView imageUrl1;
        TextView name2;
        TextView price2;
        TextView oldPrice2;
        ImageView imageUrl2;
        TextView name3;
        TextView price3;
        TextView oldPrice3;
        ImageView imageUrl3;

        public RecommendViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            name1 = (TextView) itemView.findViewById(R.id.homepage_name_1);
            price1 = (TextView) itemView.findViewById(R.id.homepage_price_1);
            oldPrice1 = (TextView) itemView.findViewById(R.id.homepage_price_o1);
            imageUrl1 = (ImageView) itemView.findViewById(R.id.homepage_image_1);

            name2 = (TextView) itemView.findViewById(R.id.homepage_name_2);
            price2 = (TextView) itemView.findViewById(R.id.homepage_price_2);
            oldPrice2 = (TextView) itemView.findViewById(R.id.homepage_price_o2);
            imageUrl2 = (ImageView) itemView.findViewById(R.id.homepage_image_2);

            name3 = (TextView) itemView.findViewById(R.id.homepage_name_3);
            price3 = (TextView) itemView.findViewById(R.id.homepage_price_3);
            oldPrice3 = (TextView) itemView.findViewById(R.id.homepage_price_o3);
            imageUrl3 = (ImageView) itemView.findViewById(R.id.homepage_image_3);
        }
    }

    class HotBoundViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        TextView textView;

        public HotBoundViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            textView = (TextView) itemView.findViewById(R.id.homepage_title_bound);
        }
    }

    class HotViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private ViewPager vpHotSeed;

        public HotViewHolder(Context context, View itemView) {
            super(itemView);
            vpHotSeed = (ViewPager) itemView.findViewById(R.id.homepage_vp_seed);
            this.context = context;
        }

        public void setData(final List<HomeHotBean.ProductBaseBean> hotInfo) {
            Log.e(TAG, "setData: =========================" + hotInfo);
            //设置每个页面的间距
            vpHotSeed.setPageMargin(20);
            //>=3
            vpHotSeed.setOffscreenPageLimit(3);
            //设置动画
            vpHotSeed.setPageTransformer(true, new RotateDownTransformer());
            vpHotSeed.setAdapter(new PagerAdapter() {
                @Override
                public int getCount() {
                    return hotInfo.size();
                }

                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return view == object;
                }

                @Override
                public Object instantiateItem(ViewGroup container, int position) {
                    ImageView view = new ImageView(context);
                    view.setScaleType(ImageView.ScaleType.FIT_XY);
                    //绑定数据
                    Glide.with(context)
                            .load(Constans.HOME_HOT_URL + hotInfo.get(position).getImageUrl())
                            .into(view);
                    container.addView(view);
                    return view;
                }

                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView((View) object);
                }
            });

            //点击事件
            vpHotSeed.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    class ShelfBoundViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        TextView textView;

        public ShelfBoundViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            textView = (TextView) itemView.findViewById(R.id.homepage_title_bound);
        }
    }

    class ShelfViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private RecyclerView recyclerShelf;

        public ShelfViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            recyclerShelf = (RecyclerView) itemView.findViewById(R.id.homepage_recycler_shelf);
        }

        public void setData(final List<HomeShelfBean> shelfInfo) {
            recyclerShelf.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            ShelfRecyclerViewAdapter adapter = new ShelfRecyclerViewAdapter(context, shelfInfo);
            recyclerShelf.setAdapter(adapter);

            recyclerShelf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "" + shelfInfo.get(0).getProductBase().getName(), Toast.LENGTH_SHORT).show();
                    MFGT.gotoProductDetails(mContext, ProductDetailsActivity.class);
                }
            });
        }
    }

    /**
     * 重写图片加载器（用于Banner）
     */
    private static class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //Glide 加载图片简单用法
            Glide.with(context)
                    .load(path)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }
    }
}