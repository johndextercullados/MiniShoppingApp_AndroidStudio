package com.cullados.cullados_activity7;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //NEED 3 DECLARATION KASI 3 PRODUCTS PER CATEGORY
        ImageView img1 = findViewById(R.id.imgProduct1);
        TextView name1 = findViewById(R.id.txtName1);
        TextView price1 = findViewById(R.id.txtPrice1);
        TextView status1 = findViewById(R.id.status1);

        ImageView img2 = findViewById(R.id.imgProduct2);
        TextView name2 = findViewById(R.id.txtName2);
        TextView price2 = findViewById(R.id.txtPrice2);
        TextView status2 = findViewById(R.id.status2);

        ImageView img3 = findViewById(R.id.imgProduct3);
        TextView name3 = findViewById(R.id.txtName3);
        TextView price3 = findViewById(R.id.txtPrice3);
        TextView status3 = findViewById(R.id.status3);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_screen);

        //TAGASALO ULE
        String category = getIntent().getStringExtra("CATEGORY_KEY");
        String name = getIntent().getStringExtra("user_name");

        if ("MODULAR".equals(category)) {
            //MODULAR SET 1
            img1.setImageResource(R.drawable.cafe);
            name1.setText("10182 Café Corner");
            price1.setText("₱125,000");
            status1.setText("RETIRED - SEALED");

            //MOD 2
            img2.setImageResource(R.drawable.grocer);
            name2.setText("10185 Green Grocer");
            price2.setText("₱95,000");
            status2.setText("RETIRED - OPENED");

            //MOD 3
            img3.setImageResource(R.drawable.grand);
            name3.setText("10190 Market Street");
            price3.setText("₱80,000");
            status3.setText("RETIRED - SEALED");

        } else if ("STARWARS".equals(category)) {
            //STAR WARS SET 1
            img1.setImageResource(R.drawable.millen);
            name1.setText("10179 UCS Falcon");
            price1.setText("₱150,000");
            status1.setText("COLLECTOR GRADE");

            //STAR 2
            img2.setImageResource(R.drawable.imperial);
            name2.setText("10212 Imperial Shuttle");
            price2.setText("₱55,000");
            status2.setText("SEALED");

            //STAR 3
            img3.setImageResource(R.drawable.star);
            name3.setText("10221 Star Destroyer");
            price3.setText("₱65,000");
            status3.setText("OPEN BOX");
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}