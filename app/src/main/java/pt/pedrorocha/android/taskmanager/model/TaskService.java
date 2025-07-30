package pt.pedrorocha.android.taskmanager.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pt.pedrorocha.android.taskmanager.view.TaskAdapter;

public class TaskService {

    private final TaskDbHelper dbHelper;
    private TaskAdapter adapter;
    long id;
    List<Task> tasks;

    public TaskService(TaskDbHelper dbHelper){
        this.dbHelper = dbHelper;
        tasks = new ArrayList<>();
    }

    public void setAdapter(TaskAdapter adapter) {
        this.adapter = adapter;
    }

    public Task add(Task task){
        ContentValues cValues = new ContentValues();

        cValues.put(TaskDbSchema.TaskTable.COLUMN_NAME, task.getTitle());
        cValues.put(TaskDbSchema.TaskTable.COLUMN_DESCRIPTION, task.getDescription());

        id = dbHelper.getDb().insert(TaskDbSchema.TaskTable.TABLE_NAME, null, cValues);
        task.setId(id);

        return task;
    }

    public List<Task> list(){

        //SELECT COLUMNS
        String[] projection = {
                TaskDbSchema.TaskTable._ID,
                TaskDbSchema.TaskTable.COLUMN_NAME,
                TaskDbSchema.TaskTable.COLUMN_DESCRIPTION
        };

        //SORT RESULTS
        String sortOrder = TaskDbSchema.TaskTable._ID + " ASC";

        Cursor cursor = dbHelper.getDb().query(
                TaskDbSchema.TaskTable.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );


        int idIndex = cursor.getColumnIndexOrThrow(TaskDbSchema.TaskTable._ID);
        int idTitle = cursor.getColumnIndexOrThrow(TaskDbSchema.TaskTable.COLUMN_NAME);
        int idDescIndex = cursor.getColumnIndexOrThrow(TaskDbSchema.TaskTable.COLUMN_DESCRIPTION);


        while( cursor.moveToNext()){
            Task task = new Task(
                    cursor.getString(idTitle),
                    cursor.getString(idDescIndex));
                task.setId(cursor.getLong(idIndex));
            tasks.add(task);
        }
        cursor.close();
        return tasks;
    }
}
