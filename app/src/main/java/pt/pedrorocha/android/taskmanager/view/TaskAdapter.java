package pt.pedrorocha.android.taskmanager.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.pedrorocha.android.taskmanager.R;
import pt.pedrorocha.android.taskmanager.model.Task;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private Context context;
    private List<Task> tasks;

    public TaskAdapter(Context context, List<Task> tasks){
        this.context = context;
        this.tasks = tasks;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.taskName.setText(tasks.get(position).getTitle());
        holder.taskDescriptionView.setText(tasks.get(position).getDescription());
        Task task = tasks.get(position);
        Log.d("TaskAdapter", "Binding task: " + task.getTitle());
        Log.d("TaskAdapter", "Binding task: " + task.getDescription());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView taskName;
        private final TextView taskDescriptionView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.textview_taskName);
            taskDescriptionView = itemView.findViewById(R.id.editText_taskDescription);
        }
    }

}
