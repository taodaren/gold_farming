package com.xiacms.goldfarming.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.mode_cart.fragment.CartFragment;
import com.xiacms.goldfarming.mode_type.fragment.TypeFragment;
import com.xiacms.goldfarming.mode_home.fragment.HomeFragment;
import com.xiacms.goldfarming.mode_mine.fragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends AppCompatActivity {
    private Fragment[] fragments;
    FragmentManager fragmentManager;
    ViewPager viewPager;

    HomeFragment homeFragment;
    TypeFragment typeFragment;
    CartFragment cartFragment;
    MineFragment mineFragment;

    @BindView(R.id.bottom_page)
    PageBottomTabLayout bottomPage;
    @BindView(R.id.fragment)
    FrameLayout fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initReplace();
        initBottomPager();
    }

    private void initReplace() {
        fragments = new Fragment[5];
        homeFragment = new HomeFragment();
        typeFragment = new TypeFragment();
        cartFragment = new CartFragment();
        mineFragment = new MineFragment();
        fragments[0] = homeFragment;
        fragments[1] = typeFragment;
        fragments[2] = cartFragment;
        fragments[3] = mineFragment;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, homeFragment)
                .show(homeFragment)
                .commit();
    }

    /**
     * 使用 PagerBottomTabStrip 框架创建底部菜单
     */
    private void initBottomPager() {
        NavigationController navigationController = bottomPage.custom()
                .addItem(newItem(R.drawable.shou_ye, R.drawable.green_shou_ye, "首页"))
                .addItem(newItem(R.drawable.fen_lei, R.drawable.green_fen_lei, "分类"))
                .addItem(newItem(R.drawable.gou_wu_che, R.drawable.green_gou_wu_che, "购物车"))
                .addItem(newItem(R.drawable.wo_de, R.drawable.green_wo_de, "我的"))
                .build();

        navigationController.setupWithViewPager(viewPager);
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                //选中时触发
                switch (index) {
                    case 0:
                        replaceFragment(fragments[0]);
                        break;
                    case 1:
                        replaceFragment(fragments[1]);
                        break;
                    case 2:
                        replaceFragment(fragments[2]);
                        break;
                    case 3:
                        replaceFragment(fragments[3]);
                        break;
                }
            }

            // 动态添加碎片
            private void replaceFragment(Fragment fragment) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment, fragment)
                        .commit();
            }

            @Override
            public void onRepeat(int index) {
                //重复选中时触发

            }
        });
    }

    // 创建一个Item
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(Color.GRAY);
        normalItemView.setTextCheckedColor(0xFF009688);
        return normalItemView;
    }

}