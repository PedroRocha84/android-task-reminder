package pt.pedrorocha.android.taskmanager.model;

import android.provider.BaseColumns;

public class TaskDbSchema {

    private TaskDbSchema(){}

    public static class  TaskTable implements BaseColumns{

        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME = "task_name";
        public static final String COLUMN_DESCRIPTION = "task_description";
    }
}
