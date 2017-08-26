package oj.app_teachers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by Onkar J on 24-08-2017.
 */

public class UserSessionManager {

    Editor editor;
    Context _context;
    SharedPreferences prefs;
    private int PRIVATE_MODE = 0;
    private static final String PREFER_NAME = "session_preferences";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    private static final String KEY_LOGINID = "loginID";
    private static final String KEY_PASS = "passKey";

    public UserSessionManager(Context context) {
        this._context = context;
        prefs = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = prefs.edit();
        editor.apply();
    }

    public void createLoginSession(String loginId, String passKey) {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_LOGINID, loginId);
        editor.putString(KEY_PASS, passKey);
        editor.apply();
    }

    public boolean isUserLoggedIn() {
        boolean value = prefs.getBoolean(IS_USER_LOGIN, true);
        if (prefs.contains(IS_USER_LOGIN) && value)
            return true;
        else
            return false;
    }

    public String getKeyLoginid() {
        return prefs.getString(KEY_LOGINID, null);
    }

    public void logoutUser() {
        editor.clear();
        editor.apply();
    }
}
