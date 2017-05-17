package test.ban.com.test_repeating_data;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_insert_date;
    private Button delete_date;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = DbHelper.getDatabaseHelper(this).getWritableDatabase();
        btn_insert_date = (Button) findViewById(R.id.insert_date);
        delete_date = (Button) findViewById(R.id.delete_date);
        btn_insert_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
//                    String s="insert into Ban (uid,name)values(1,"ss")";
                    String s = "insert into Ban(uid,name)values(" + i + ",\"s" + i + "\")";
                    db.execSQL(s);
                }
            }
        });
        delete_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1="CREATE TABLE IF NOT EXISTS TBTemperature_Tem AS select distinct * from Ban;";
                db.execSQL(s1);
                String s2="delete from Ban;";
                db.execSQL(s2);
                String s3="insert into Ban select * from TBTemperature_Tem;";
                db.execSQL(s3);
                String s4="drop table TBTemperature_Tem;";

                db.execSQL(s4);
            }
        });
    }
}
