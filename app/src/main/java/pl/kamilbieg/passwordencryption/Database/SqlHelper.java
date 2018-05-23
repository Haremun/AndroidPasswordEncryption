package pl.kamilbieg.passwordencryption.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqlHelper extends SQLiteOpenHelper {

    private static String dbName;

    public SqlHelper(Context context) {
        super(context, SqlStructure.DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db, SqlStructure.TABLE_NAME,
                SqlStructure.COLUMN_USER_NAME + " text not null unique",
                SqlStructure.COLUMN_USER_PASS + " text ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createTable(SQLiteDatabase db, String tableName, String... columns) {

        StringBuilder builder = new StringBuilder();
        builder
                .append("create table ")
                .append(tableName)
                .append("(id integer primary key autoincrement,");

        for (int i = 0; i < columns.length; i++) {
            builder.append(columns[i]);
            if (i != columns.length - 1)
                builder.append(", ");
        }
        builder.append(");");
        Log.i("SqlHelper", builder.toString());
        db.execSQL(builder.toString());
    }
}
