package oj.app_teachers;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * Created by Onkar J on 21-07-2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
        // add for verbose logging
        // FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            String[] columnsNames = new String[]{"vivian", "onkar", "karan", "vijay"};
            String[] columnsPasswords = new String[]{"vivian123", "onkar123", "karan123", "vijay123"};
            String[] columnsRole = new String[]{"student", "student", "student", "teacher"};
            for (int i = 0; i < 4; i++)
                SQLite.insert(User.class)
                        .columns(User_Table.id, User_Table.Name, User_Table.Password, User_Table.Role)
                        .values(i + 1, columnsNames[i], columnsPasswords[i], columnsRole[i])
                        .execute();
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstTime", true);
        editor.apply();
        // Above code runs only once per installation. This is the initialization of database which needed only once per installation.
    }

    public String selectPassword(String compareName) {
        List<User> userList = SQLite.select(User_Table.Password).from(User.class).where(User_Table.Name.is(compareName)).queryList();
        String textPassword = null;
        for (User value : userList) {
            textPassword = value.getPassword();
        }
        return textPassword;
    }

    public String selectRole(String compareName) {
        List<User> userList = SQLite.select(User_Table.Role).from(User.class).where(User_Table.Name.is(compareName)).queryList();
        String textRole = null;
        for (User value : userList) {
            textRole = value.getRole();
        }
        return textRole;
    }
}
