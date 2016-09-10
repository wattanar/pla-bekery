package me.wattana.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner category;
    private Spinner ingredient;

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

        category = (Spinner) findViewById(R.id.Cetagory);
        ingredient = (Spinner) findViewById(R.id.Ingredient);
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

        // ประเภท
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1) {
                    ingredient.setAdapter(cake_adapter);
                } else if (position == 2) {
                    ingredient.setAdapter(brownie_adapter);
                } else if (position == 3){

                } else {
                    Toast.makeText(getApplicationContext(), "ไม่สามารถดึงข้อมูลได้",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // ส่วนผสม
        ingredient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
