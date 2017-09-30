package oj.app_teachers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by Onkar J on 24-08-2017.
 */

class UserSessionManager {

    private Editor editor;
    private SharedPreferences prefs;
    private static final String PREFER_NAME = "session_preferences";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    private static final String KEY_LOGINID = "loginID";
    private static final String KEY_PASS = "passKey";

    UserSessionManager(Context context) {
        int PRIVATE_MODE = 0;
        prefs = context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = prefs.edit();
        editor.apply();
    }

    void createLoginSession(String loginId, String passKey) {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_LOGINID, loginId);
        editor.putString(KEY_PASS, passKey);
        editor.apply();
    }

    boolean isUserLoggedIn() {
        boolean value = prefs.getBoolean(IS_USER_LOGIN, true);
        return prefs.contains(IS_USER_LOGIN) && value;
    }

    String getKeyLoginid() {
        return prefs.getString(KEY_LOGINID, null);
    }

    void logoutUser() {
        editor.clear();
        editor.apply();
    }
}
