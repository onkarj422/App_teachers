package oj.app_teachers;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.security.AccessController.getContext;

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
        User u = new User();
        u.setId(1);
        u.setName("XYZ");
        u.save();

        List<User> UserList = SQLite.select()
                .from(User.class)
                .queryList();

        Context context = getApplicationContext();
        for (int i=0;i<=UserList.size();i++)
            Toast.makeText(context, Arrays.toString(UserList.toArray()), Toast.LENGTH_SHORT).show();
    }
}
