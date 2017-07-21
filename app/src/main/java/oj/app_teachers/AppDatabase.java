package oj.app_teachers;
import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Onkar J on 20-07-2017.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
    public static final String NAME = "AppDatabase"; // we will add the .db extension

    public static final int VERSION = 2;
}
