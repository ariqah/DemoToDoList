package sg.edu.rp.c346.id20023243.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> tasksArrayList;

    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        tasksArrayList = objects;

        //when create object look like this
        //adapter = new CustomAdapter(MainActivity.this, R.layout.row, al);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //to get every item in list view

        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        // Obtain the Android Version information based on the position
        ToDoItem currentTask = tasksArrayList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentTask.getTitle());
        tvDate.setText(currentTask.toString());

        return rowView;
    }
}
