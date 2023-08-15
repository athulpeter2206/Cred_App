package com.example.crudapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.widget.Toast;

public class ClassForDBUsers extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "Users";

    public ClassForDBUsers(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table UserDetails(Id integer primary key autoincrement, Name text, UName text, PassW text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS UserDetails");
        onCreate(sqLiteDatabase);
    }

    public void registerUser(UserDetails ud) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("name", ud.Name);
            cv.put("uName", ud.UName);
            cv.put("passW", ud.PassW);
            db.insert("UserDetails", null, cv);
            db.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String[] getOneDepartment(String UNAME) {
        String a[] = new String[4];
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {"Id", "Name", "UName", "PassW"};
            String selection = "UName" + "=?";
            String[] selectionArgs = {UNAME};
            Cursor cursor = db.query("UserDetails", columns, selection, selectionArgs, null, null, null);
            System.out.println(cursor);
            if (cursor != null && cursor.getCount() != 0) {
                cursor.moveToFirst();
                a[0] = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("Id")));
                a[1] = cursor.getString(cursor.getColumnIndexOrThrow("Name"));
                a[2] = cursor.getString(cursor.getColumnIndexOrThrow("UName"));
                a[3] = cursor.getString(cursor.getColumnIndexOrThrow("PassW"));
            } else {

                a[0] = "";
                a[1] = "";
                a[2] = "";
                a[3] = "";
            }
            cursor.close();
            db.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }

        return a;
    }

    public int updatePassword(UserDetails ud) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("PassW", ud.PassW);

            String whereClause = "UName=?";
            String[] whereArgs = {ud.UName};

            int rowsAffected = db.update("UserDetails", values, whereClause, whereArgs);

            db.close();
            if (rowsAffected > 0) {
                System.out.println("Password updated successfully");
                return 1;
            } else {
                System.out.println("No rows were updated");
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}