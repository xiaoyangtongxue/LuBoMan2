package luoboman.www.luobo.com.luboman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;


import util.API;
import util.OkHttp3Utils;

/**
 * Created by Administrator on 2017/10/24.
 */

public class XRecycleView extends AppCompatActivity {
   /* private XRecyclerView xr;
    private List<String > list=new ArrayList<>();
    //获取数据的开始
    String path = "http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage";
    private int curr;
    private XRAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1);

        //初始化xr
        xr= (XRecyclerView) findViewById(R.id.XRecycleView);
        //加布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xr.setLayoutManager(layoutManager);

        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                curr=0;
                list.clear();
                getData(API.TYPE_HOME,curr);
                xr.refreshComplete();
            }

            @Override
            public void onLoadMore() {
             *//*   curr++;
                getData(API.TYPE_HOME,curr);
                xr.refreshComplete();*//*
            }
        });
        getData(API.TYPE_HOME,1);
    }

    //初始化数据
    private void getData(String url,int curr){
        OkHttp3Utils.getInstance().doGet(path, new GsonObjectCallback<bean>() {
            @Override
            public void onUi(bean homeBean) {
                homeBean.getMsg();
                XRAdapter  mxradapter=new XRAdapter(XRecycleView.this,homeBean.getData());
                xr.setAdapter(mxradapter);



            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });


    }*/

}
