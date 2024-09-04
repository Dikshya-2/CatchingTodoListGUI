package dk.tec.catchingtodolist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dk.tec.catchingtodolist.model.Tasktype;
import dk.tec.catchingtodolist.model.TodoItem;

public class CreateTodoActivity extends AppCompatActivity {

    TodoItem todoItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_todo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        todoItem= new TodoItem();
        findViewById(R.id.button).setOnClickListener(view -> {

        });
        createSpinner();
    }
    void createSpinner(){
        Spinner taskSpinner = findViewById(R.id.sp_tasktype);
        ArrayAdapter<Tasktype> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Tasktype.values());
        taskSpinner.setAdapter(adapter);

        taskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              todoItem.setTasktype(Tasktype.values()[i]);
              Log.d("TAg", "onItemSelect: "+ todoItem.getTasktype());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                todoItem.setTasktype(null);

            }
        });
    }
}