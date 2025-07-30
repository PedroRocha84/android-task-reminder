package pt.pedrorocha.android.taskmanager.model;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TaskDbHelper extends SQLiteOpenHelper{

    private SQLiteDatabase db;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "tasks.db";

    public TaskDbHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            String query = "CREATE TABLE " +
                    TaskDbSchema.TaskTable.TABLE_NAME + " ( " +
                    TaskDbSchema.TaskTable._ID + " INTEGER PRIMARY KEY, " +
                    TaskDbSchema.TaskTable.COLUMN_NAME + " TEXT, " +
                    TaskDbSchema.TaskTable.COLUMN_DESCRIPTION + " TEXT)";

            db.execSQL(query);

        } catch (Exception e) {
            Log.e(TAG, "onCreate: Table not created", e );
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskDbSchema.TaskTable.TABLE_NAME);
        onCreate(db);
    }

    public SQLiteDatabase getDb() {
        // lazy instantiation
        if (db != null) {
            return db;
        }

        db = getWritableDatabase(); // this is a long running task
        return db;
    }

}
