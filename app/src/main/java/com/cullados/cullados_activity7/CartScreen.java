package com.cullados.cullados_activity7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart_screen);

        TextView tv_Name = findViewById(R.id.tvName);
        TextView tv_Orders = findViewById(R.id.tvOrders);
        TextView tv_Total = findViewById(R.id.tvTotal);
        Button btn_Clear = findViewById(R.id.btnClear);
        Button btn_GotoMain = findViewById(R.id.btnGotoMain);

        //SASALUHIN UNG MGA INPUYTS FROM PRODUCT SCREEN
        String name = getIntent().getStringExtra("user_name");
        int total = getIntent().getIntExtra("TOTAL_PRICE", 0);
        String orders = getIntent().getStringExtra("ORDER_LIST");


        // SET NA UNG NAME, TOTAL, AND ORDERS LIST,,,MAY IF ELSE STATEMENT LANG
        tv_Name.setText(name);
        tv_Total.setText("₱" + String.format("%,d", total));

        if (orders == null || orders.isEmpty()) {
            tv_Orders.setText("no item yet :<");
        } else {
            tv_Orders.setText(orders);
        }


        btn_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset the UI text directly
                tv_Orders.setText("no item yet :<");
                tv_Total.setText("₱0");

                Toast.makeText(CartScreen.this, "Lego Cart Cleared", Toast.LENGTH_SHORT).show();
            }
        });

        btn_GotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartScreen.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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