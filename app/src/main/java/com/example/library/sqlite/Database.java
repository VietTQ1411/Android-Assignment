package com.example.library.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.library.Entity.UserModel;
import com.example.library.R;
import com.example.library.Resources.App;

public class Database {
    private Context context;
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;

    public Database(Context context) {
        this.context = context;
        this.dbHelper = new SQLiteHelper(context);
    }

    public void insertUser(String user, String tokenKey, boolean isLogged) {
        this.db = this.dbHelper.getWritableDatabase();
        //deleteUser();
        ContentValues contentValues = new ContentValues();//HashMap
        //Tao ra "hashmap kieu k-v"
        contentValues.put(App.getInstance().getResources().getString(R.string.COLUMN_USER), user);
        contentValues.put(App.getInstance().getResources().getString(R.string.COLUMN_TOKEN_KEY), tokenKey);
        contentValues.put(App.getInstance().getResources().getString(R.string.COLUMN_IS_LOGGING), (isLogged ? 1 : 0));
        db.insert(App.getInstance().getResources().getString(R.string.TABLE_NAME), null, contentValues);
    }

    public UserModel getLoggedUser() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {App.getInstance().getResources().getString(R.string.COLUMN_USER_ID),
                App.getInstance().getResources().getString(R.string.COLUMN_USER)
                , App.getInstance().getResources().getString(R.string.COLUMN_TOKEN_KEY),
                App.getInstance().getResources().getString(R.string.COLUMN_IS_LOGGING)};
        try {
            Cursor cursor = db.query(
                    App.getInstance().getResources().getString(R.string.TABLE_NAME),
                    columns,
                    null, null, null, null, null
            );
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(App.getInstance().getResources().getString(R.string.COLUMN_USER_ID)));
                String user = cursor.getString(cursor.getColumnIndexOrThrow(App.getInstance().getResources().getString(R.string.COLUMN_USER)));
                String tokenKey = cursor.getString(cursor.getColumnIndexOrThrow(App.getInstance().getResources().getString(R.string.COLUMN_TOKEN_KEY)));
                boolean isLogged = cursor.getInt(cursor.getColumnIndexOrThrow(App.getInstance().getResources().getString(R.string.COLUMN_IS_LOGGING))) == 1;
                UserModel foundUser = new UserModel(id,user, tokenKey, isLogged);
                return foundUser;
            }

            return null;
        } catch (Exception ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
}
