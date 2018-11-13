package mx.mediomelon.testapp.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import mx.mediomelon.testapp.BuildConfig;

/**
 * Created by FranckLB on 13/11/2018.
 */
public class Logs {
    private final static String DEV = " FLB";

    public static void i(@NonNull String msg) {
        if (BuildConfig.DEBUG) {
            StackTraceElement stackData = Thread.currentThread().getStackTrace()[3];
            Log.i(getSimpleClassName(stackData.getClassName()), stackData.getMethodName()
                    .concat(" : ").concat(String.valueOf(stackData.getLineNumber()))
                    .concat(DEV).concat("\n" + msg));
        }
    }

    public static void d(@NonNull String msg) {
        if (BuildConfig.DEBUG) {
            StackTraceElement stackData = Thread.currentThread().getStackTrace()[3];
            Log.d(getSimpleClassName(stackData.getClassName()), stackData.getMethodName()
                    .concat(" : ").concat(String.valueOf(stackData.getLineNumber()))
                    .concat(DEV).concat("\n" + msg));
        }
    }

    public static void e(@NonNull String msg) {
        if (BuildConfig.DEBUG) {
            StackTraceElement stackData = Thread.currentThread().getStackTrace()[3];
            Log.e(getSimpleClassName(stackData.getClassName()), stackData.getMethodName()
                    .concat(" : ").concat(String.valueOf(stackData.getLineNumber()))
                    .concat(DEV).concat("\n" + msg));
        }
    }

    public static void v(@NonNull String msg) {
        if (BuildConfig.DEBUG) {
            StackTraceElement stackData = Thread.currentThread().getStackTrace()[3];
            Log.v(getSimpleClassName(stackData.getClassName()), stackData.getMethodName()
                    .concat(" : ").concat(String.valueOf(stackData.getLineNumber()))
                    .concat(DEV).concat("\n" + msg));
        }
    }

    public static void w(@NonNull String msg) {
        if (BuildConfig.DEBUG) {
            StackTraceElement stackData = Thread.currentThread().getStackTrace()[3];
            Log.w(getSimpleClassName(stackData.getClassName()), stackData.getMethodName()
                    .concat(" : ").concat(String.valueOf(stackData.getLineNumber()))
                    .concat(DEV).concat("\n" + msg));
        }
    }

    private static String getSimpleClassName(String className) {
        return className.substring(className.lastIndexOf(".")+1);
    }

}