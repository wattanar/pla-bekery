package me.wattana.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExampleActivity extends AppCompatActivity {

    private TextView show_example;

    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        show_example = (TextView) findViewById(R.id.example_detail);

        Intent intent = getIntent();

        c = intent.getIntExtra("category", 0);

        if (c == 1) { // เค้ก
            show_example.setText("Number : เค้ก is selected.");
        } else if (c == 2) { // บราวนี่
            show_example.setText("Number : บราวนี่ is selected.");
        }


    }
}
