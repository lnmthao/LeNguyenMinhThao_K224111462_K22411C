package com.lnmt.lenguyenminhthao_k224111462_k22411c.lenguyenminhthao_k224111462_k22411c;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lnmt.lenguyenminhthao_k224111462_k22411c.R;
import com.lnmt.lenguyenminhthao_k224111462_k22411c.models.Product;

public class ProductDetailActivity extends AppCompatActivity {

    EditText edt_product_id;
    EditText edt_product_name;
    EditText edt_product_code;
    EditText edt_product_unit_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        edt_product_id = findViewById(R.id.edt_product_id);
        edt_product_name = findViewById(R.id.edt_product_name);
        edt_product_code = findViewById(R.id. edt_product_code);
        edt_product_unit_price = findViewById(R.id.edt_product_unit_price);
        display_product_infor();
    }

    private void display_product_infor() {
        //Lấy Intent từ bên ProductManagementActivity gửi qua:
        Intent intent=getIntent();
        //Lấy dữ liệu Selected Product từ intent
        Product p=(Product) intent.getSerializableExtra("SELECTED_PRODUCT");
        if(p==null)
            return;

        edt_product_id.setText(String.valueOf(p.getId()));
        edt_product_name.setText(p.getProductName());
        edt_product_code.setText(String.valueOf(p.getProductCode()));
        edt_product_unit_price.setText(String.valueOf(p.getUnitPrice()));
    }
}