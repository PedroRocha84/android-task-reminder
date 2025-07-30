package pt.pedrorocha.android.taskmanager.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pt.pedrorocha.android.taskmanager.R;
import pt.pedrorocha.android.taskmanager.model.Task;
import pt.pedrorocha.android.taskmanager.model.TaskDbHelper;
import pt.pedrorocha.android.taskmanager.model.TaskService;

public class NewTaskActivity extends AppCompatActivity {

    TaskService taskService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        taskService = new TaskService(new TaskDbHelper(this));

        Button btnSubmit = findViewById(R.id.button_submit);
        EditText txtName = findViewById(R.id.editText_taskNameInput);
        EditText txtDescription = findViewById(R.id.editText_taskDescriptionInput);

        btnSubmit.setOnClickListener(v -> {
            if (!txtName.getText().toString().isEmpty() && !txtDescription.getText().toString().isEmpty()) {
                Task task = new Task(txtName.getText().toString(), txtDescription.getText().toString());
                taskService.add(task);
                finish();
            } else {
                Toast.makeText(this, "Values not valid, try again!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}