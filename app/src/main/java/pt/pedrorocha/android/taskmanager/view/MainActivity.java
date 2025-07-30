package pt.pedrorocha.android.taskmanager.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pt.pedrorocha.android.taskmanager.R;
import pt.pedrorocha.android.taskmanager.model.Task;
import pt.pedrorocha.android.taskmanager.model.TaskDbHelper;
import pt.pedrorocha.android.taskmanager.model.TaskDbSchema;
import pt.pedrorocha.android.taskmanager.model.TaskService;

public class MainActivity extends AppCompatActivity {

    public TaskAdapter adapter;
    public TaskService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskDbHelper dbHelper = new TaskDbHelper(this); //CREATE DB

        service = new TaskService(dbHelper);
        adapter = new TaskAdapter(this, service.list());

// Tell service about the adapter
        service.setAdapter(adapter);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        Button btnNewTask = findViewById(R.id.button);
        btnNewTask.setOnClickListener(v->{
            Intent intent = new Intent(this, NewTaskActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh task list
        adapter.setTasks(service.list());
        adapter.notifyDataSetChanged();
    }

}