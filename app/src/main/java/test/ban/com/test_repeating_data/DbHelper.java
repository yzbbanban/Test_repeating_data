package test.ban.com.test_repeating_data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by brander on 2017/5/17.
 */
public class DbHelper extends SQLiteOpenHelper{
    private static DbHelper mDatabaseHelper;
    private DbHelper(Context context) {
        super(context, "Brander", null, 1);
    }

    public static synchronized DbHelper getDatabaseHelper(Context context) {

        if (mDatabaseHelper == null) {

            mDatabaseHelper = new DbHelper(context);
        }

        return mDatabaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists Ban(uid Integer,name Varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
