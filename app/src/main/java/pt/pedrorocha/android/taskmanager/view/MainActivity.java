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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskAdapter adapter = new TaskAdapter(this, Task.list());

        Log.d("MainActivity", "Tasks size: " + Task.list().size());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        Button btnNewTask = findViewById(R.id.button);
        btnNewTask.setOnClickListener(v->{
            Intent intent = new Intent(this, NewTaskActivity.class);
            startActivity(intent);
        });

    }
}