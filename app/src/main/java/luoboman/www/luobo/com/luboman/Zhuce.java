package luoboman.www.luobo.com.luboman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import util.GsonObjectCallback;
import util.OkHttp3Utils;

public class Zhuce extends AppCompatActivity {


    @BindView(R.id.zhuceimg)
    ImageView zhuceimg;
    @BindView(R.id.edt3)
    EditText edt3;
    @BindView(R.id.edt4)
    EditText edt4;
    @BindView(R.id.edt5)
    EditText edt5;
    @BindView(R.id.edt6)
    EditText edt6;
    @BindView(R.id.zhuce)
    Button zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
        zhuce=(Button)findViewById(R.id.zhuce);
        edt3=(EditText)findViewById(R.id.edt3);
        edt4=(EditText)findViewById(R.id.edt4);

    }



    @OnClick({R.id.zhuceimg, R.id.edt3, R.id.edt4, R.id.edt5, R.id.zhuce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuceimg:
                Intent intent2=new Intent(Zhuce.this,DengluActivity.class);
                startActivity(intent2);
                break;
            case R.id.edt3:
                break;
            case R.id.edt4:
                break;
            case R.id.edt5:
                break;
            case R.id.zhuce:
                // 获取输入框内容
                String mobile1 = edt3.getText().toString();
                String pass = edt4.getText().toString();
                RegUser(mobile1,pass);
                break;
        }
    }

    public void RegUser(String mob,String pas){
        OkHttp3Utils.getInstance().doGet(Filed.REG_URL+"?mobile="+mob+"&"+"password="+pas, new GsonObjectCallback<Denglujson>() {
            @Override
            public void onUi(Denglujson  json) {
                // msg 失败：天呢！用户已注册
                // msg 成功：注册成功
                if(json.getMsg().equals("注册成功")){
                    Toast.makeText(Zhuce.this,"注册成功啦",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Zhuce.this,DengluActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Zhuce.this,json.getMsg(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }


}
