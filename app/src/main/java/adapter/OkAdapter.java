package adapter;

import android.content.Context;
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
 * Created by Administrator on 2017/10/19.
 */

public class OkAdapter  extends XRecyclerView.Adapter<OkAdapter.ViewHolder>  {
    List<String> imglist =new ArrayList<>();
    List<String> textlist =new ArrayList<>();
    Context context;
    View view;

    public OkAdapter(List<String> imglist,List<String> textlist, Context context) {
        this.imglist = imglist;
        this.context = context;
        this.textlist = textlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
         holder.mTitle.setText(textlist.get(position));
        Glide.with(context).load(imglist.get(position)).into(holder.mIv);



    }

    @Override
    public int getItemCount() {
        return imglist.size();
    }

    public class ViewHolder extends XRecyclerView.ViewHolder {
       TextView mTitle;
         ImageView mIv;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle =  view.findViewById(R.id.textitem);
            mIv = view.findViewById(R.id.itemimg);
        }
    }

}
