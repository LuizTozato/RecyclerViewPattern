package com.ugps.treinorecyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ugps.treinorecyclerview.R;
import com.ugps.treinorecyclerview.adapter.TextAdapter;
import com.ugps.treinorecyclerview.helper.RecyclerItemClickListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNewTask;
    private RecyclerView taskRecyclerView;
    private Button addTaskButton;
    private List<String> taskList = new ArrayList<>();
    private TextAdapter textAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNewTask  = findViewById(R.id.editTextNewTask);
        taskRecyclerView = findViewById(R.id.taskRecyclerView);
        addTaskButton    = findViewById(R.id.addTaskButton);

        //CONFIGURANDO O RECYCLERVIEW
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        taskRecyclerView.setLayoutManager(layoutManager);
        taskRecyclerView.setHasFixedSize(true);


        //EVENTO DE CLIQUE DO BOTÃO
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskList.add(editTextNewTask.getText().toString());

                //PASSANDO A LISTA DE TAREFAS AO ADAPTADOR
                textAdapter = new TextAdapter(taskList);

                //SETTANDO O ADAPTADOR
                if(taskList.size() <= 2) {
                    taskRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
                }
                taskRecyclerView.setAdapter(textAdapter);

            }
        });



        //ADICIONANDO EVENTO DE CLIQUE AO RECYCLERVIEW
        taskRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        taskRecyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(),"Clique curto",Toast.LENGTH_LONG).show();
                                Log.i("INFO ","CLIQUE CURTO");
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(),"Clique longo",Toast.LENGTH_LONG).show();
                                Log.i("INFO ","CLIQUE LONGO");
                            }
                        }
                )
        );



    }
}