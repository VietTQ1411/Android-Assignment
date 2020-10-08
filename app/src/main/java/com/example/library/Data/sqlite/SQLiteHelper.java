package com.example.library.Data.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.library.R;
import com.example.library.AppResources;

public class SQLiteHelper extends SQLiteOpenHelper {
 //   public static final String SQL_CREATE_ENTRIES =
//            "CREATE TABLE " + AppResources.getInstance().getResourses().getString(R.string.TABLE_NAME) + "(" +
//                    AppResources.getInstance().getResources().getString(R.string.COLUMN_USER_ID)+ " INTEGER PRIMARY KEY AUTOINCREMENT"+
//                    AppResources.getInstance().getResourses().getString(R.string.COLUMN_USER) + " VARCHAR(300)," +
//                    AppResources.getInstance().getResourses().getString(R.string.COLUMN_TOKEN_KEY) + " VARCHAR(300)," +
//                    AppResources.getInstance().getResourses().getString(R.string.COLUMN_IS_LOGGING) + " INTEGER)";

//    public static final String SQL_DELETE_ENTRIES =
//            "DELETE FROM " + AppResources.getInstance().getResourses().getString(R.string.TABLE_NAME) + " WHERE 1 = 1";

    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

   // public SQLiteHelper(@Nullable Context context) {
   //     super(context, AppResources.getInstance().getResourses().getString(R.string.DATABASE_NAME), null, AppResources.getInstance().getResourses().getInteger(R.integer.DATABASE_VERSION));
   // }

    @Override
    public void onCreate(SQLiteDatabase db) {
   //     db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //  db.execSQL(SQL_DELETE_ENTRIES);
    }

    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
