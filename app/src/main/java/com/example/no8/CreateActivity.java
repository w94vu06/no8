package com.example.no8;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.stetho.Stetho;

public class CreateActivity extends AppCompatActivity {
    private static final String DB_NAME = "MyList.db";
    private static String TABLE_NAME = "MyTable";
    private static final int DB_VERSION = 1;
    public static SQLiteDatabase db;
    public SQLiteDataBaseHelper sqlDataBaseHelper;


    private Button btn_create;
    private EditText editText_else;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_page);
        editText_else = findViewById(R.id.editText_else);
        sqlDataBaseHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);
        db = sqlDataBaseHelper.getWritableDatabase();

//        initDB();

        btn_create = findViewById(R.id.btn_create);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDataBaseHelper.getWritableDatabase();
                String comment = editText_else.getText().toString();
                db.execSQL("INSERT INTO MyTable(Comment, LikeNum)VALUES('123', 0)");

//                Cursor c = db.rawQuery("SELECT * FROM "+"MyTable", null);
//                c.moveToFirst();
//                Log.d("SELECT", "onClick: "+ c.getString(1));

                //startActivity(new Intent(CreateActivity.this,CommandActivity.class));

            }
        });
    }

    private void initDB() {
        Stetho.initializeWithDefaults(this);

        ContentValues contentValues = new ContentValues();
        contentValues.put("Comment", String.valueOf(editText_else));
        sqlDataBaseHelper = new SQLiteDataBaseHelper(this, DB_NAME
                , null, DB_VERSION, TABLE_NAME);//初始化資料庫

    }


}
