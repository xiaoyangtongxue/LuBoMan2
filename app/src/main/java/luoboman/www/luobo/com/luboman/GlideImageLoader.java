package luoboman.www.luobo.com.luboman;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.youth.banner.loader.ImageLoaderInterface;

/**
 * Created by Administrator on 2017/10/18.
 */
public class GlideImageLoader implements ImageLoaderInterface {


    @Override
    public void displayImage(Context context, Object path, View imageView) {
        //使用glide加载图片

        Glide.with(context).load(path).into((ImageView) imageView);
    }

    @Override
    public View createImageView(Context context) {
        return null;
    }
}
