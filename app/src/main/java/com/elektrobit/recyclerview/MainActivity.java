package com.elektrobit.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    EmployeeAdapter adapter;
    RecyclerView recyclerView;
    ClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<EmployeeData> list = new ArrayList<>();
        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(getDataFromUser());
                adapter.notifyItemInserted(list.size() - 1);
            }
        });
        recyclerView
                = (RecyclerView) findViewById(
                R.id.recyclerView);
        listener = new ClickListener() {
            @Override
            public void click(int index) {
                Toast.makeText(getApplicationContext(), "Clicked item index is " + index, Toast.LENGTH_SHORT).show();
            }
        };
        adapter = new EmployeeAdapter(list, getApplication(), listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(MainActivity.this));
    }

    private EmployeeData getDataFromUser() {
        String name;
        String id;
        String dept;
        EditText Empname = findViewById(R.id.name);
        EditText Empid = findViewById(R.id.id);
        EditText Empdpt = findViewById(R.id.dept);
        name = Empname.getText().toString();
        id = Empid.getText().toString();
        dept = Empdpt.getText().toString();
        return new EmployeeData(name, id, dept);
    }
}
