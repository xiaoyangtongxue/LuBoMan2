package luoboman.www.luobo.com.luboman;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapter.OkAdapter;
import adapter.OkAdapter2;

import bean.bean;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import util.GsonObjectCallback;
import util.NetWorkUtils;
import util.OkHttp3Utils;

public class fragment1 extends Fragment {

    //RecycleView
    String path = "http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage";
    XRecyclerView mRecyclerView;
    List<String> imglist = new ArrayList<>();
    List<String> textlist = new ArrayList<>();
    View view;
    //第二个recycleview
    XRecyclerView recycleView;
    List<String> imglist2 = new ArrayList<>();

   //轮播
    private List<bean.DataBean.Ad1Bean> ad1 = new ArrayList<>();
    List<String>ad2=new ArrayList<>();

    //private List<bean.DataBean.Ad5Bean> list = new ArrayList<>();

    //图片的地址和title的集合
    private List<String> mListImage, mListTitle;
    private Banner banner;
    // private List<bean.DataBean.Ad1Bean> ad1 = new ArrayList<>();


    //绑定
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.activity_fragment1, null);
        unbinder = ButterKnife.bind(this, view);
        banner = view.findViewById(R.id.banner);
        mRecyclerView = view.findViewById(R.id.recycleview);
        banner();
        recycleView = view.findViewById(R.id.recycleview2);
        boolean netWorkAvailable = NetWorkUtils.isNetWorkAvailable(getContext());
        if (!netWorkAvailable) {
            Toast.makeText(getContext(), "联网：" + netWorkAvailable, Toast.LENGTH_SHORT).show();
        } else {


        }
        getData();
        getData2();
        //banner();

        //第二个刷新
        recycleView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                recycleView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                recycleView.loadMoreComplete();
            }
        });
        //第一个刷新
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mRecyclerView.loadMoreComplete();
            }
        });

        return view;

    }

    //请求网络第二个recycleview
    public void getData() {
        OkHttp3Utils.doGet(path, new GsonObjectCallback<bean>() {
            @Override

            public void onUi(bean okBean) {
                List<bean.DataBean.SubjectsBean> subjects = okBean.getData().getSubjects();
                for (int i = 0; i < subjects.size(); i++) {
                    imglist2.add(subjects.get(i).getImage());
                    Log.d("sss", subjects.get(i).getImage());
                }


                OkAdapter2 adapter2 = new OkAdapter2(imglist2, getActivity());

                // mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                //StaggeredGridLayoutManager.HORIZONTAL));

                // mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
                recycleView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
                recycleView.setAdapter(adapter2);


            }


            @Override
            public void onFailed(Call call, IOException e) {

            }

        });
    }

    //请求网络
    public void getData2() {
        OkHttp3Utils.doGet(path, new GsonObjectCallback<bean>() {
            @Override

            public void onUi(bean okBean) {
                for (int j = 0; j < okBean.getData().getSubjects().size(); j++) {
                    for (int i = 0; i < okBean.getData().getSubjects().get(j).getGoodsList().size(); i++) {
                        String img = okBean.getData().getSubjects().get(j).getGoodsList().get(i).getGoodsImage();
                        String text = okBean.getData().getSubjects().get(j).getGoodsList().get(i).getGoods_name();
                        imglist.add(img);
                        textlist.add(text);
                    }

                }

                OkAdapter adapter = new OkAdapter(imglist, textlist, getActivity());
                mRecyclerView.setAdapter(adapter);
                // mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                //StaggeredGridLayoutManager.HORIZONTAL));

                // mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


            }

            @Override
            public void onFailed(Call call, IOException e) {

            }

        });
    }


    //轮播图
    public void banner() {
//找到控件
        banner = view. findViewById(R.id.banner);
//banner的样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
//加载图片的方法
        banner.setImageLoader(new GlideImageLoader());
        mListImage = new ArrayList<>();
//想图片集合中添加网网址
        mListImage.add("https://image.yunifang.com/yunifang/images/goods/ad0/17100908319495742677657462.jpg");
        mListImage.add("https://image.yunifang.com/yunifang/images/goods/ad0/170905143497021095281713081.jpg");
        mListImage.add("https://image.yunifang.com/yunifang/images/goods/ad0/170905143499118006873413769.jpg");
        mListImage.add("https://image.yunifang.com/yunifang/images/goods/ad0/170823222049920659891841095.jpg");

//设置Banner图片集合
        banner.setImages(mListImage);
//设置banner的动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
//切换的时间
        banner.setDelayTime(2000);
        mListTitle = new ArrayList<>();
//添加Title
        mListTitle.add("第一张图片");
        mListTitle.add("第二张图片");
        mListTitle.add("第三张图片");
        mListTitle.add("第四张图片");

//设置Banner标题集合（当banner样式有显示title时）
        banner.setBannerTitles(mListTitle);
//title的位置在banner的显示
        banner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
//启动banner
        banner.start();

    }


    }










