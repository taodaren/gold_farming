package com.xiacms.goldfarming.mode_type.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页 -> 分类
 */
public class TypeFragment extends BaseFragment {
    private FrameLayout frameLayout;
    private List<BaseFragment> fragmentList;
    private Fragment tempFragment;

    TypeListFragment leftFragment;

    @Override
    public View initView() {
        View inflate = View.inflate(mContext, R.layout.fragment_type, null);

        //初始化分类标题栏
        TextView textTitle = (TextView) inflate.findViewById(R.id.text_title_top);
        textTitle.setText("分类");
        //初始化容器
        frameLayout = (FrameLayout) inflate.findViewById(R.id.fl_type);
        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
//        replaceFragment();
        initFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        switchFragment(tempFragment,fragmentList.get(0));
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        leftFragment = new TypeListFragment();
        fragmentList.add(leftFragment);

        switchFragment(tempFragment,fragmentList.get(0));
    }

//    private void replaceFragment() {
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_category_left, new TypeListFragment());
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }

    public void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (tempFragment != nextFragment) {
            tempFragment = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }

                    transaction.add(R.id.fl_type, nextFragment, "tagFragment").commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

}
