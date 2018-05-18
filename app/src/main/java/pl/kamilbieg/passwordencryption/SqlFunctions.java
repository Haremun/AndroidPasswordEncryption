package pl.kamilbieg.passwordencryption;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class SqlFunctions {

    private SQLiteDatabase mDatabase;

    public SqlFunctions(SQLiteDatabase database){
        this.mDatabase = database;
    }

    public void addToDatabase(String name, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SqlStructure.COULMN_USER_NAME, name);
        contentValues.put(SqlStructure.COLUMN_USER_PASS, password);
        mDatabase.insert(SqlStructure.TABLE_NAME, null, contentValues);
    }
}
