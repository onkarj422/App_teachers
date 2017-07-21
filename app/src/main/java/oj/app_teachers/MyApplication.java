package oj.app_teachers;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.Select;

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
        Context context = getApplicationContext();
        String d;
        Cursor cursor = new Select(User_Table.name).from(User.class).query();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            d=cursor.getString(0);
            Toast.makeText(context,"Logged in successfully"+d,Toast.LENGTH_SHORT).show();
            cursor.moveToNext();
        }
        cursor.close();

    }
}
