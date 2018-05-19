package pl.kamilbieg.passwordencryption;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class SqlFunctions {

    private SQLiteDatabase mDatabase;

    public SqlFunctions(SQLiteDatabase database){
        this.mDatabase = database;
    }

    public void addUserToDatabase(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SqlStructure.COULMN_USER_NAME, user.getName());
        contentValues.put(SqlStructure.COLUMN_USER_PASS, user.getPassword());
        mDatabase.insert(SqlStructure.TABLE_NAME, null, contentValues);
    }
}
