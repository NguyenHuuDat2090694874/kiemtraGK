package com.example.kiemtra.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QLSanPham", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'ip 15', '30000000', 'https://cdn.tgdd.vn/Products/Images/42/281570/Slider/iphone-15-slider-3--2--1020x570.png')," +
                "(2, 'ip x ', '7000000', 'https://chamsocdidong.com/uploads/2020/01/Untitled-4.jpg')," +
                "(3, 'ip 8 plus ', '5000000', 'https://chamsocdidong.com/uploads/2020/01/Untitled-6-1.jpg')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}
