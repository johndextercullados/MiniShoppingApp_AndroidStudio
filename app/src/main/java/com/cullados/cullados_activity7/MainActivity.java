package com.cullados.cullados_activity7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        EditText et_Name = findViewById(R.id.etName);
        Button btn_Gotopage2 = findViewById(R.id.btnGotopage2);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_Gotopage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String collectorName = et_Name.getText().toString();

                // PAG WALA LAMAN, DEFAULKT NLNG
                if(collectorName.isEmpty() || collectorName.equals("")) {
                    et_Name.setText("User1");
                } else {

                    Intent intent = new Intent(MainActivity.this, CategoryScreen.class);
                    //PAPASA UNG NAME
                    intent.putExtra("user_name", collectorName);

                    startActivity(intent);
                }
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}