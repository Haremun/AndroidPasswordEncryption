package pl.kamilbieg.passwordencryption.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pl.kamilbieg.passwordencryption.User;

public class SqlFunctions {

    private SQLiteDatabase mDatabase;

    public SqlFunctions(SQLiteDatabase database){
        this.mDatabase = database;
    }

    public void addUserToDatabase(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SqlStructure.COLUMN_USER_NAME, user.getName());
        contentValues.put(SqlStructure.COLUMN_USER_PASS, user.getPassword());
        mDatabase.insert(SqlStructure.TABLE_NAME, null, contentValues);
    }

    public User searchForUser(String userName) {
        Cursor cursor = mDatabase.query(
                SqlStructure.TABLE_NAME,
                null,
                SqlStructure.COLUMN_USER_NAME + "=?",
                new String[] {userName},
                null,
                null,
                null
        );

        cursor.moveToNext();
        if (cursor.getCount() != 0){
            User user = new User.Builder().name(cursor.getString(1)).password(cursor.getString(2)).build();
            cursor.close();
            return user;
        }
        else{
            cursor.close();
            return null;
        }
    }
}
