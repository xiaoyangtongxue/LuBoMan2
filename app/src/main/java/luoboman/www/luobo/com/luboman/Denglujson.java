package luoboman.www.luobo.com.luboman;

/**
 * Created by Administrator on 2017/10/22.
 */

public class Denglujson {
    /**
     * msg : 天呢！用户已注册
     * code : 1
     * data : {}
     */

    private String msg;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /*// 注册失败
    {"msg":"天呢！用户已注册","code":"1","data":"{}"}
    // 登陆失败
    {"msg":"天呢！密码错误","code":"1"}
    // 注册成功
    {"msg":"注册成功","code":"0","data":{"age":null,"createtime":"2017-10-19T00:00:00","gender":0,"icon":null,"mobile":"18519722140","money":0,"nickname":null,"password":"123455","uid":878,"username":"18519722140"}}
    // 登陆成功
    {"msg":"登录成功","code":"0","data":{"age":null,"createtime":"2017-10-19T00:00:00","gender":0,"icon":null,"mobile":"18519722140","money":0,"nickname":null,"password":"123455","uid":878,"username":"18519722140"}}*/

}


