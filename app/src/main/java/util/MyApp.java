package util;

import android.app.Application;
import android.content.Context;

/**
 * Created by TA on 2017/10/14.
 */

public class MyApp extends Application{
    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getInstance() {
        return instance;
    }

}
