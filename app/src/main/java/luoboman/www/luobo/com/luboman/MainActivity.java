package luoboman.www.luobo.com.luboman;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;


    Activity activity;
    ArrayList<Fragment> list;
    @BindView(R.id.btn)
    RadioButton btn;
    @BindView(R.id.btn2)
    RadioButton btn2;
    @BindView(R.id.btn3)
    RadioButton btn3;
    @BindView(R.id.btn4)
    RadioButton btn4;
    // MyPageAdapter adapter;

    private View view;
    FrameLayout main_f1;


    /*//图片的地址和title的集合
    private List<String> mListImage, mListTitle;
    private Banner banner;*/


    fragment1 f1;
    fragment2 f2;
    fragment3 f3;
    fragment4 f4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn=(RadioButton)findViewById(R.id.btn);
        btn2=(RadioButton)findViewById(R.id.btn2);
        btn3=(RadioButton)findViewById(R.id.btn3);
        btn4=(RadioButton)findViewById(R.id.btn4);
        ButterKnife.bind(this);
        main_f1 = (FrameLayout) findViewById(R.id.main_f1);

        //getData();
        initView();
        getSupportFragmentManager().beginTransaction().add(R.id.main_f1, f1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_f1, f2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_f1, f3).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_f1, f4).commit();
        getSupportFragmentManager().beginTransaction().hide(f1).commit();
        getSupportFragmentManager().beginTransaction().hide(f2).commit();
        getSupportFragmentManager().beginTransaction().hide(f3).commit();
        getSupportFragmentManager().beginTransaction().hide(f4).commit();


    }

    private void initView() {
        f1 = new fragment1();
        f2 = new fragment2();
        f3 = new fragment3();
        f4 = new fragment4();
    }


    @OnClick({R.id.btn, R.id.btn2, R.id.btn3, R.id.btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                getSupportFragmentManager().beginTransaction().show(f1).commit();
                getSupportFragmentManager().beginTransaction().hide(f2).commit();
                getSupportFragmentManager().beginTransaction().hide(f3).commit();
                getSupportFragmentManager().beginTransaction().hide(f4).commit();
                btn.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_home_press), null, null);
                btn.setTextColor(ContextCompat.getColor(this, R.color.main));
                btn2.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_class), null, null);
                btn2.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                btn3.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_cart), null, null);
                btn3.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                btn4.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_user), null, null);
                btn4.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));

                break;
            case R.id.btn2:
                getSupportFragmentManager().beginTransaction().show(f2).commit();
                getSupportFragmentManager().beginTransaction().hide(f1).commit();
                getSupportFragmentManager().beginTransaction().hide(f3).commit();
                getSupportFragmentManager().beginTransaction().hide(f4).commit();

                btn2.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_class_press), null, null);
                btn2.setTextColor(ContextCompat.getColor(this, R.color.main));
                btn.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_home), null, null);
                btn.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                btn3.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_cart), null, null);
                btn3.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                btn4.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_user), null, null);
                btn4.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                break;
            case R.id.btn3:

                getSupportFragmentManager().beginTransaction().show(f3).commit();
                getSupportFragmentManager().beginTransaction().hide(f1).commit();
                getSupportFragmentManager().beginTransaction().hide(f2).commit();
                getSupportFragmentManager().beginTransaction().hide(f4).commit();

                btn2.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_home), null, null);
                btn2.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                btn.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_class), null, null);
                btn.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                btn3.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_cart_press), null, null);
                btn3.setTextColor(ContextCompat.getColor(this, R.color.main));
                btn4.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_user), null, null);
                btn4.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                break;
            case R.id.btn4:
                getSupportFragmentManager().beginTransaction().show(f4).commit();
                getSupportFragmentManager().beginTransaction().hide(f1).commit();
                getSupportFragmentManager().beginTransaction().hide(f2).commit();
                getSupportFragmentManager().beginTransaction().hide(f3).commit();
                btn.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_home), null, null);
                btn.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                btn2.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_class), null, null);
                btn2.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                btn3.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_cart), null, null);
                btn3.setTextColor(ContextCompat.getColor(this, R.color.colorBorder));
                btn4.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.ic_nav_user_press), null, null);
                btn4.setTextColor(ContextCompat.getColor(this, R.color.main));

                break;
        }


    }


    //扫描
    public void saomiao(View v) {
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }


    public Activity getActivity() {
        return activity;
    }
}