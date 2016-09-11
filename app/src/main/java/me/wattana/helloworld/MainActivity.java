package me.wattana.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner category;
    private Spinner ingredient;

    private Spinner FromSpinner;
    private Spinner ToSpinner;

    private Button btnExample;

    int category_selected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrayCategory = {"กรุณาเลือกข้อมูล", "เค้ก", "บราวนี่", "ขนมปัง", "คุกกี้", "โดนัท", "ชูครีม"};
        String[] arrayIngredient = {"กรุณาเลือกข้อมูล"};

        String[] arrayCake = {
                "แป้งเค้ก",
                "น้ำตาลทราย"
        };

        String[] arrayBrownie = {
                "แป้งอเนกประสงค์",
                "เนยจืด"
        };



        String[] arrayFrom = {"ถ้วย", "ช้อนโต๊ะ", "ช้อนชา", "กรัม"};
        String[] arrayTo = {"ถ้วย", "ช้อนโต๊ะ", "ช้อนชา", "กรัม"};


        category = (Spinner) findViewById(R.id.Cetagory);
        ingredient = (Spinner) findViewById(R.id.Ingredient);

        FromSpinner = (Spinner) findViewById(R.id.FromSpinner);
        ToSpinner  = (Spinner) findViewById(R.id.ToSpinner);

        btnExample = (Button) findViewById(R.id.btnExample);

        final ArrayAdapter from_adpater = new ArrayAdapter(this,
                R.layout.spinner_item, arrayFrom);

        final ArrayAdapter to_adpater = new ArrayAdapter(this,
                R.layout.spinner_item, arrayTo);

        // set ประเภท
        final ArrayAdapter category_adpater = new ArrayAdapter(this,
                R.layout.spinner_item, arrayCategory);
        // set ส่วนผสม
        final ArrayAdapter ingredient_adpater = new ArrayAdapter(this,
                R.layout.spinner_item, arrayIngredient);
        // ======



        // Cake
        final ArrayAdapter cake_adapter = new ArrayAdapter(this,
                R.layout.spinner_item, arrayCake);

        // Brownie
        final ArrayAdapter brownie_adapter = new ArrayAdapter(this,
                R.layout.spinner_item, arrayBrownie);

        // ======
        category.setAdapter(category_adpater);
        ingredient.setAdapter(ingredient_adpater);

        FromSpinner.setAdapter(from_adpater);
        ToSpinner.setAdapter(to_adpater);

        // ประเภท
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1) {
                    ingredient.setAdapter(cake_adapter);
                } else if (position == 2) {
                    ingredient.setAdapter(brownie_adapter);
                }

                category_selected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // ส่วนผสม
        ingredient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExampleActivity.class);
                intent.putExtra("category", category_selected);
                startActivity(intent);
            }
        });
    }
}
