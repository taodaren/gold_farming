package com.xiacms.goldfarming.mode_type.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSONArray;
import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.base.BaseFragment;
import com.xiacms.goldfarming.global.Constans;
import com.xiacms.goldfarming.mode_type.adapter.TypeLeftAdapter;
import com.xiacms.goldfarming.mode_type.adapter.TypeRightAdapter;
import com.xiacms.goldfarming.mode_type.bean.TypeLeftBean;
import com.xiacms.goldfarming.mode_type.bean.TypeRightBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * 分类显示
 */
public class TypeListFragment extends BaseFragment {
    private static final String TAG = TypeListFragment.class.getSimpleName();

    private ListView listLeft;
    private RecyclerView recyclerRight;
    private List<TypeLeftBean> leftBeanList;
    private List<TypeRightBean> rightBeanList;

    private TypeLeftAdapter leftAdapter;
    private TypeRightAdapter rightAdapter;
    boolean isFirst = true;


    @Override
    public View initView() {
        View inflate = View.inflate(mContext, R.layout.fragment_type_list, null);
        listLeft = (ListView) inflate.findViewById(R.id.list_left);
        recyclerRight = (RecyclerView) inflate.findViewById(R.id.recycler_right);
        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();
    }

    private void getDataFromNet() {
        getDataLeft();
        getDataRight();
    }

    private void getDataLeft() {
        OkHttpUtils.get().url(Constans.TYPE_LEFT_URL).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "TypeLeft 数据请求失败===" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                if (response != null) {
//                    Log.e(TAG, "TypeLeft 数据请求成功==" + response);
                    leftBeanList = JSONArray.parseArray(response, TypeLeftBean.class);
//                    Log.e(TAG, "TypeLeft 数据解析成功==" + response);
                    if (isFirst) {
                        leftAdapter = new TypeLeftAdapter(mContext,leftBeanList);
                        listLeft.setAdapter(leftAdapter);
                    }
                    initListener(leftAdapter);
                }
            }
        });
    }

    private void getDataRight() {
        OkHttpUtils.get()
                .url(Constans.TYPE_RIGHT_INIT_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "TypeRight 数据请求失败===" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if (response != null) {
//                            Log.e(TAG, "TypeRight 数据请求成功==" + response);
                            rightBeanList = JSONArray.parseArray(response, TypeRightBean.class);
//                            Log.e(TAG, "TypeRight 数据解析成功==" + response);

                            rightAdapter = new TypeRightAdapter(mContext, rightBeanList);
                            recyclerRight.setAdapter(rightAdapter);
                            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

                                @Override
                                public int getSpanSize(int position) {
                                    if (position == 0) {
                                        return 2;
                                    }
                                    return 1;
                                }
                            });
                            recyclerRight.setLayoutManager(layoutManager);
                        }
                    }
                });
    }

    /**
     * 响应ListView的点击事件改变右侧显示对应数据的方法
     */
    private void getDataRightInfo(int id) {
        OkHttpUtils.get()
                .url(Constans.TYPE_RIGHT_URL + id + Constans.TYPE_RIGHT_URL_SUFFIX)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "TypeRight 数据请求失败===" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if (response != null) {
                            rightBeanList.clear();
//                            Log.e(TAG, "TypeRight 数据请求成功==" + response);
                            rightBeanList = JSONArray.parseArray(response, TypeRightBean.class);
//                            Log.e(TAG, "TypeRight 数据解析成功==" + response);

                            rightAdapter = new TypeRightAdapter(mContext, rightBeanList);
                            recyclerRight.setAdapter(rightAdapter);
                            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

                                @Override
                                public int getSpanSize(int position) {
                                    if (position == 0) {
                                        return 2;
                                    }
                                    return 1;
                                }
                            });
                            recyclerRight.setLayoutManager(layoutManager);
                        }
                    }
                });
    }

    private void initListener(final TypeLeftAdapter leftAdapter) {
        //点击监听
        listLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leftAdapter.changeSelected(position);//刷新
                if (position != 0) {
                    isFirst = false;
                }
                getDataRightInfo(position);
//                leftAdapter.notifyDataSetChanged();
            }
        });

        //选中监听
        listLeft.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                leftAdapter.changeSelected(position);//刷新

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}