package oj.app_teachers;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
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
        if(!prefs.getBoolean("firstTime", false))
        {
            String[] columnsNames = new String[] { "vivian", "onkar", "karan", "vijay" };
            String[] columnsPasswords = new String[] { "vivian123", "onkar123", "karan123", "vijay123" };
            String[] columnsRole = new String[] { "student", "student", "student", "teacher" };
            for(int i = 1; i<4; i++)
                SQLite.insert(User.class)
                        .columns(User_Table.id, User_Table.Name, User_Table.Password, User_Table.Role)
                        .values(i, columnsNames[i], columnsPasswords[i], columnsRole[i])
                        .execute();
        }
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        // Above code runs only once per installation. This is the initialization of database which needed only once per installation.
    }

    public String selectQuery(String CompareName) {
        List<User> UserList = SQLite.select(User_Table.Password).from(User.class).where(User_Table.Name.is(CompareName)).queryList();
        String Text = null;
        for (User value : UserList) {
            Text = value.getPassword();
        }
        return Text;
    }
}
