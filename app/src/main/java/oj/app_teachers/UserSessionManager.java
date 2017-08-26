package oj.app_teachers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import java.util.HashMap;

/**
 * Created by Onkar J on 24-08-2017.
 */

public class UserSessionManager {


    Editor editor;
    Context _context;
    SharedPreferences prefs;
    int PRIVATE_MODE = 0;
    private static final String PREFER_NAME = "session_preferences";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    public static final String KEY_LOGINID = "loginID";
    public static final String KEY_PASS = "passKey";

    public UserSessionManager(Context context) {
        this._context = context;
        prefs = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = prefs.edit();
    }

    public void createLoginSession(String loginId, String passKey) {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_LOGINID, loginId);
        editor.putString(KEY_PASS, passKey);
        editor.commit();
    }

    public boolean isUserLoggedIn(Context bcontext) {
        this._context = bcontext;
        prefs = PreferenceManager
                .getDefaultSharedPreferences(_context);
        return prefs.getBoolean(IS_USER_LOGIN, false);
    }

    public boolean checkLogin(Context context) {
        this._context = context;
        if (!isUserLoggedIn(_context)) {
            return true;
        }
        return false;
    }

    public HashMap<String, String> getUser() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_LOGINID, prefs.getString(KEY_LOGINID, null));
        user.put(KEY_PASS, prefs.getString(KEY_PASS, null));
        return user;
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }


}
