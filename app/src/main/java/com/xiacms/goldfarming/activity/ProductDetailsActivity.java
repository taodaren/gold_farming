package com.xiacms.goldfarming.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.global.Constans;
import com.xiacms.goldfarming.global.MFGT;
import com.xiacms.goldfarming.mode_home.bean.ProductDetailsBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailsActivity extends Activity {
    private ProductDetailsBean productDetailsBean;
    private static final String PRO_BEAN = "pro_bean";

    @BindView(R.id.image_pro_img)
    ImageView imageProImg;
    @BindView(R.id.pro_info_title)
    TextView proInfoTitle;
    @BindView(R.id.pro_info_cate)
    TextView proInfoCate;
    @BindView(R.id.pro_info_price)
    TextView proInfoPrice;
    @BindView(R.id.pro_info_price_old)
    TextView proInfoPriceOld;
    @BindView(R.id.pro_info_yunfei)
    TextView proInfoYunfei;
    @BindView(R.id.pro_info_address)
    TextView proInfoAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);

        //取出Intent
        Intent intent = getIntent();
        productDetailsBean = (ProductDetailsBean) intent.getSerializableExtra(PRO_BEAN);
        if (productDetailsBean != null) {
            //本地获取存储的数据
            setDataFormView(productDetailsBean);
        }

    }

    private void setDataFormView(ProductDetailsBean productDetailsBean) {
        String name = productDetailsBean.getName();
        String price = productDetailsBean.getPrice();
        String oldPrice = productDetailsBean.getOldPrice();
        String freight = productDetailsBean.getFreight();
        String location = productDetailsBean.getLocation();
        String features = productDetailsBean.getFeatures();
        String note = productDetailsBean.getNote();
        String dosage = productDetailsBean.getDosage();
        String appPro = productDetailsBean.getAppPro();
        String appRate = productDetailsBean.getAppRate();
        String appUser = productDetailsBean.getAppUser();

        Glide.with(this)
                .load(Constans.PRO_DETAILS_URL)
                .into(imageProImg);
        if (name != null) {
            proInfoTitle.setText(name);
        }
        if (price != null) {
            proInfoPrice.setText(price);
        }
        if (oldPrice != null) {
            proInfoPriceOld.setText(oldPrice);
            // 为原价添加删除线
            proInfoPriceOld.setPaintFlags(proInfoPriceOld.getPaintFlags()
                    | Paint.STRIKE_THRU_TEXT_FLAG);

        }
        if (freight != null) {
            proInfoYunfei.setText(freight);
        }
        if (location != null) {
            proInfoAddress.setText(location);
        }
        if (features != null) {
            proInfoPriceOld.setText(features);
        }
        if (note != null) {
            proInfoPriceOld.setText(note);
        }
        if (dosage != null) {
            proInfoPriceOld.setText(dosage);
        }
        if (appPro != null) {
            proInfoPriceOld.setText(appPro);
        }
        if (appRate != null) {
            proInfoPriceOld.setText(appRate);
        }
        if (appUser != null) {
            proInfoPriceOld.setText(appUser);
        }

    }

    @OnClick({R.id.image_pro_img, R.id.pro_info_back, R.id.pro_info_keep, R.id.pro_info_more, R.id.pro_info_kefu, R.id.pro_info_cart, R.id.pro_info_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_pro_img:
                Toast.makeText(this, "商品图片展示跳转", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pro_info_back:
                MFGT.finishActivity(this);
                break;
            case R.id.pro_info_keep:
                Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pro_info_more:
                Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pro_info_kefu:
                Toast.makeText(this, "跳转至客服界面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pro_info_cart:
                Toast.makeText(this, "加入购物车", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pro_info_buy:
                Toast.makeText(this, "立即购买", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
