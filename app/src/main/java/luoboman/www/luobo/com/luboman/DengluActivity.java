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

public class DengluActivity extends AppCompatActivity {


    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.edt)
    EditText phone;
    @BindView(R.id.edt2)
    EditText password;
    @BindView(R.id.denglu)
    Button denglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);
        ButterKnife.bind(this);
        denglu=(Button)findViewById(R.id.denglu);
        phone=(EditText)findViewById(R.id.edt);
        password=(EditText)findViewById(R.id.edt2);

    }

    @OnClick({R.id.img, R.id.edt, R.id.edt2, R.id.denglu,R.id.check})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img:
                break;
            case R.id.edt:
                break;
            case R.id.edt2:
                break;
            case R.id.check:

                Intent intent=new Intent(DengluActivity.this,Zhuce.class);
                startActivity(intent);
                break;
            case R.id.denglu:
                String mob=phone.getText().toString();
                String pass = password.getText().toString();
                User(mob,pass);
                break;
        }
    }

    private void User(String mob,String pass){
        OkHttp3Utils.getInstance().doGet(Filed.LOGIN_URL + "?mobile=" + mob + "&" + "password=" + pass, new GsonObjectCallback<json>() {
            @Override
            public void onUi(json json) {
                if(json.getMsg().equals("登录成功")){
                    Toast.makeText(DengluActivity.this,"成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(DengluActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(DengluActivity.this,json.getMsg(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
