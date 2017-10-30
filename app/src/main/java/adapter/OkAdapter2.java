package adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import luoboman.www.luobo.com.luboman.R;

/**
 * Created by Administrator on 2017/10/23.
 */

public class OkAdapter2  extends XRecyclerView.Adapter<RecyclerView.ViewHolder>  {
     Context context;
     List<String>imglist2;




    public OkAdapter2(List<String> imglist2, Context context) {
        this.context = context;
        this.imglist2 = imglist2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_recycle_view2,parent,false);

        ViewHolder vh2 = new ViewHolder(view);
          return vh2;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(imglist2.get(position)).into(((ViewHolder)holder).img3);
}

//    @Override
//    public void onBindViewHolder(OkAdapter.ViewHolder holder, int position) {
//        Glide.with(context).load(imglist2.get(position)).into((()holder).img3);
//    }

    @Override
    public int getItemCount() {
        return imglist2.size();
    }


    class ViewHolder extends  XRecyclerView.ViewHolder{
          ImageView img3;
        public ViewHolder(View itemView) {
            super(itemView);
            img3 = itemView.findViewById(R.id.item2);
        }

    }
}
