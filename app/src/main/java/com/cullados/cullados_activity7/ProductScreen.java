package com.cullados.cullados_activity7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductScreen extends AppCompatActivity {
    //uNIVERSAL TO
    int totalVaultAmount = 0;
    String ordersList = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_screen);

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

        Button btn_AddToCart1 = findViewById(R.id.btnAddToCart1);
        Button btn_AddToCart2 = findViewById(R.id.btnAddToCart2);
        Button btn_AddToCart3 = findViewById(R.id.btnAddToCart3);
        Button btn_Cart = findViewById(R.id.btnCart);
        Button btn_Category = findViewById(R.id.btnGotocategory);

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

            //PRESYO NUNG LEGO SET, NUMERICAL SO IT CAN BE READ IN OPERATIONS
            btn_AddToCart1.setTag(125000);
            btn_AddToCart2.setTag(95000);
            btn_AddToCart3.setTag(80000);

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

            btn_AddToCart1.setTag(150000);
            btn_AddToCart2.setTag(55000);
            btn_AddToCart3.setTag(65000);
        } else {
            //PRESYO NLNG KASI NAKA DEFAULT UNG TECHNIC SETS
            btn_AddToCart1.setTag(48000);
            btn_AddToCart2.setTag(32000);
            btn_AddToCart3.setTag(28000);
        }

        //ADD TO CART CODES
        btn_AddToCart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ETO UNG PRESYO KANINA, KAYA NAKA GETTAGG
                int price = (int) v.getTag();

                //MISMONG OPERATION
                totalVaultAmount += price;

                //GETTING THE NAME OF THE PRODUCT
                String productName = name1.getText().toString();
                String productPrice = price1.getText().toString();

                ordersList += "• " + productName + " - " + productPrice + "\n";

                //TOAST TO LET THE USER KNOW
                Toast.makeText(ProductScreen.this, productName + " successfully added to cart!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_AddToCart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price = (int) v.getTag();
                totalVaultAmount += price;

                String productName = name2.getText().toString();
                String productPrice = price2.getText().toString();

                ordersList += "• " + productName + " - " + productPrice + "\n";

                Toast.makeText(ProductScreen.this, productName + " successfully added to cart!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_AddToCart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price = (int) v.getTag();
                totalVaultAmount += price;

                String productName = name3.getText().toString();
                String productPrice = price3.getText().toString();

                ordersList += "• " + productName + " - " + productPrice + "\n";

                Toast.makeText(ProductScreen.this, productName + " successfully added to cart!", Toast.LENGTH_SHORT).show();
            }
        });


        //THE CART BUTTON, PARA MAPASA UNG TOTAL, LISTAHAN ANDDDD NAME
        btn_Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductScreen.this, CartScreen.class);

                intent.putExtra("user_name", name);
                intent.putExtra("TOTAL_PRICE", totalVaultAmount);
                intent.putExtra("ORDER_LIST", ordersList);

                startActivity(intent);
            }
        });

        //babalik sa category
        btn_Category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductScreen.this, CategoryScreen.class);

                //BABALIK LANG UNG NAME
                intent.putExtra("user_name", name);

                //cLREA ALL THE ACTIONES YOU MADE IN PRODUCT SCREEN
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);

                //KILL PRODUCT SCREEN
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}