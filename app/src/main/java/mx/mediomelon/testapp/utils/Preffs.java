package mx.mediomelon.testapp.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Map;

import mx.mediomelon.testapp.TestApp;

/**
 * Created by FranckLB on 13/11/2018.
 */
public class Preffs {

    public static void setBoolPref(String preference, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(TestApp.getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(preference, value);
        editor.commit();
    }

    public static boolean getBoolPref(String pref) {
        SharedPreferences sharedPreferences;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(TestApp.getContext());
        return sharedPreferences.getBoolean(pref, false);
    }

    public static void setStringPref(String preference, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(TestApp.getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preference, value);
        editor.commit();
    }

    public static String getStringPref(String pref) {
        SharedPreferences sharedPreferences;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(TestApp.getContext());
        return sharedPreferences.getString(pref, "");
    }

    public static Map<String, ?> getAll() {
        SharedPreferences sharedPreferences;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(TestApp.getContext());
        return sharedPreferences.getAll();
    }

    public static void removePrefference(String name) {
        SharedPreferences sharedPreferences;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(TestApp.getContext());
        sharedPreferences.edit().remove(name).commit();
    }
}
