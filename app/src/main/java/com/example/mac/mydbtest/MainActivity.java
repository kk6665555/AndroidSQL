package com.example.mac.mydbtest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MYDB mydb;
    private SQLiteDatabase db;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //(this,資料庫名稱,指標,版本號)
        mydb = new MYDB(this,"oneone",null,1);
        db=mydb.getReadableDatabase();
        textview=(TextView)findViewById(R.id.TestView);


    }

    public void insert(View view){
        //insert into cust() valuse() ;
        ContentValues valuse = new ContentValues();
        valuse.put("cname","666");
        valuse.put("tel","09000000");
        valuse.put("birthday","2017-08-13");
        db.insert("cust",null,valuse);
        query(null);
    }
    public void delete(View view){
        //delete from cust where id = 3 and cname = 666;
        db.delete("cust","_id=? and cname=?",new String[]{"3","666"});
        query(null);
    }
    public void updata(View view){
        ContentValues valuse = new ContentValues();
        valuse.put("cname","111");
        valuse.put("tel","2345");
        valuse.put("birthday","2017-08-16");
        db.update("cust",valuse,"_id=?",new String[]{"6"});
        query(null);
    }
    public void query(View view){
        //select * from cust
        textview.setText("");
        Cursor cursor = db.query("cust",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            String id =  cursor.getString(0);
            String cname =  cursor.getString(1);
            String tel =  cursor.getString(2);
            String birthday =  cursor.getString(3);
            textview.append(id +":"+cname +":"+ tel + ":" + birthday +"\n");

        }

    }
}
