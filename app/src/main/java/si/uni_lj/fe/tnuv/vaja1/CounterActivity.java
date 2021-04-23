package si.uni_lj.fe.tnuv.vaja1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    private int counter = 0;
    Button reset;
    Button plus;
    Button minus;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        Button reset = findViewById(R.id.reset);
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        TextView textView = findViewById(R.id.textView);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter ++;
                textView.setText(Integer.toString(counter));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter --;
                textView.setText(Integer.toString(counter));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                textView.setText(Integer.toString(counter));
            }
        });
    }
}