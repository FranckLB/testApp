package mx.mediomelon.testapp;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import mx.mediomelon.testapp.model.ItemsHandler;

/**
 * Created by FranckLB on 09/11/2018.
 */
public class TestApp extends MultiDexApplication {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ItemsHandler.getInstance().initList();
    }
}
