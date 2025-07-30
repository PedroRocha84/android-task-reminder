package pt.pedrorocha.android.taskmanager.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {

    private int id;
    private String title;
    private String description;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static List<Task> list(){
        Task task1 = new Task(0,"My first task", "A little description for testing my app");
        Task task2 = new Task(1,"My second task", "A little description for testing my app");

        return new ArrayList<>(Arrays.asList(task1,task2));
    }
}
