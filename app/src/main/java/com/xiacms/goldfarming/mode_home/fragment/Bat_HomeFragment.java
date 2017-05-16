package com.xiacms.goldfarming.mode_home.fragment;


import android.support.v4.app.Fragment;

/**
 * 首页
 */
public class Bat_HomeFragment extends Fragment {
//    private static final String TAG = Bat_HomeFragment.class.getSimpleName();
//    Unbinder unbinder;
//    // 金品货架
//    @BindView(R.id.hp_recycler_huojia)
//    RecyclerView reViewShelf;
//    @BindView(R.id.swipe_refresh)
//    SwipeRefreshLayout swipeRefresh;
//    @BindView(R.id.text_refresh)
//    TextView textRefresh;
//
//    LinearLayoutManager layoutManager;
//    List<ProductDetailsBean> proDetailsBeanList;
//    HomeRecycleAdapter shelfAdapter;
//    MHomepageModel homepageModel;
//
//    int pageId = 1;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
//        unbinder = ButterKnife.bind(this, inflate);
//        return inflate;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        homepageModel = new MHomepageModel();
//        init();
//        setListener();
//    }
//
//    private void init() {
//        initData(I.ACTION_FIRST_LOAD);
////        initView();
//    }
//
////    private void initView() {
////        layoutManager = new LinearLayoutManager(getContext());
////        reViewShelf.setNestedScrollingEnabled(false);// 解决 ScrollView 与 RecyclerView 滑动冲突
////        reViewShelf.setLayoutManager(layoutManager);
////        shelfAdapter = new HomeRecycleAdapter(getContext());
////        reViewShelf.setAdapter(shelfAdapter);
////    }
//
//    private void initData(final int action) {
//        homepageModel = new MHomepageModel();
//        proDetailsBeanList = new ArrayList<>();
//        homepageModel.loadHomepageData(getContext(), new OnCompleteListener<ProductDetailsBean[]>() {
//            @Override
//            public void onSuccess(ProductDetailsBean[] result) {
//                setRefresh(false);
//                shelfAdapter.setMore(true);
//                Log.e(TAG, "onSuccess: " + result);
//                if (result != null && result.length > 0) {
//                    List<ProductDetailsBean> list = ResultUtils.array2List(result);
//                    if (action == I.ACTION_FIRST_LOAD || action == I.ACTION_PULL_DOWN) {
//                        proDetailsBeanList.clear();
//                    }
//                    proDetailsBeanList.addAll(list);
//                    if (list.size() < I.PAGE_SIZE_DEFAULT) {
//                        shelfAdapter.setMore(false);
//                    }
//                    shelfAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onError(String error) {
//                Log.e(TAG, "onError: " + error);
//                CommonUtils.showShortToast(error);
//                setRefresh(false);
//            }
//        });
//    }
//
//    private void setListener() {
//        setPullUpListener();
//        setPullDownListener();
//    }
//
//    private void setPullUpListener() {
//        reViewShelf.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                int lastPosition = layoutManager.findLastVisibleItemPosition();
//                if (newState == RecyclerView.SCROLL_STATE_IDLE
//                        && lastPosition == shelfAdapter.getItemCount() - 1
//                        && shelfAdapter.isMore()) {
//                    pageId++;
//                    initData(I.ACTION_PULL_UP);
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                int itemPosition = layoutManager.findFirstVisibleItemPosition();
//                swipeRefresh.setEnabled(itemPosition == 0);
//            }
//        });
//    }
//
//    private void setPullDownListener() {
//        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                setRefresh(true);
//                pageId = 1;
//                initData(I.ACTION_PULL_DOWN);
//            }
//        });
//    }
//
//    private void setRefresh(boolean refresh) {
//        if (swipeRefresh != null) {
//            swipeRefresh.setRefreshing(refresh);
//        }
//        if (textRefresh != null) {
//            textRefresh.setVisibility(refresh ? View.VISIBLE : View.GONE);
//        }
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        if (unbinder != null) {
//            unbinder.unbind();
//        }
//    }
}
