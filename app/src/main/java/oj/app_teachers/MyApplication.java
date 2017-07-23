package oj.app_teachers;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

/**
 * Created by Onkar J on 21-07-2017.
 */

public class MyApplication extends Application {
    int d;
    @Override
    public void onCreate() {
        super.onCreate();
        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
        // add for verbose logging
        // FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
        User u = new User();
        u.setId(1);
        u.setName("vivian");
        u.save();
        u.setId(2);
        u.setName("onkar");
        u.save();
        u.setId(3);
        u.setName("karan");
        u.save();
        u.setId(4);
        u.setName("vijay");
        u.save();

        Context context = getApplicationContext();

        List<User> us=SQLite.select().from(User.class).where(User_Table.id.is(3)).queryList();
for(User ut:us)
{
    Toast.makeText(context,"Logged in successfully"+ut.getName(),Toast.LENGTH_SHORT).show();
}//By changing the id u will be able to access the name
        //for ex:by setting id=1 u will be able to access vivian.

        /*Cursor cursor= SQLite.select().from(User.class).query();
        cursor.moveToFirst();
       // while (!cursor.isAfterLast()) {
           d=cursor.getString(2);


         //   cursor.moveToNext();

        }*/

        //cursor.close();

        }

    }