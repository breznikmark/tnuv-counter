package si.uni_lj.fe.tnuv.vaja1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> counters;
    private ArrayAdapter<String> countersAdapter;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCounter(v);
            }
        });

        counters = new ArrayList<>();
        countersAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, counters);
        listView.setAdapter(countersAdapter);
        setUpListViewListener();
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Counter Removed", Toast.LENGTH_LONG).show();

                counters.remove(position);
                countersAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addCounter(View v) {
        EditText input = findViewById(R.id.editText);
        String counterText = input.getText().toString();

        if (!(counterText.equals(""))) {
            countersAdapter.add(counterText);
            input.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(), "Please enter counter name.", Toast.LENGTH_LONG).show();
        }
    }
}