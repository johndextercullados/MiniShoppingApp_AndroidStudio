package com.cullados.cullados_activity7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CategoryScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_screen);

        TextView tv_Name = findViewById(R.id.tvName);
        Button btn_Technic = findViewById(R.id.btnTechnic);
        Button btn_Modular = findViewById(R.id.btnModular);
        Button btn_Starwars = findViewById(R.id.btnStarwars);

        // TAGASALO
        String collectorName = getIntent().getStringExtra("USER_NAME");
        tv_Name.setText(collectorName + "!");

        //TECHNIC BUTTONNNNNNNNNNNNNNNN
        btn_Technic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryScreen.this, ProductScreen.class);

                // THIS IS TO PASS THE NAME AND SELECTED CATEGORY
                intent.putExtra("user_name", collectorName);
                intent.putExtra("CATEGORY_KEY", "TECHNIC");

                startActivity(intent);
            }
        });

        // MODULAR BUTTONNNNNNN
        btn_Modular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryScreen.this, ProductScreen.class);

                intent.putExtra("user_name", collectorName);
                intent.putExtra("CATEGORY_KEY", "MODULAR");

                startActivity(intent);
            }
        });

        //STAR WARS BUTTONNNNN
        btn_Starwars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryScreen.this, ProductScreen.class);

                intent.putExtra("user_name", collectorName);
                intent.putExtra("CATEGORY_KEY", "STARWARS");

                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}