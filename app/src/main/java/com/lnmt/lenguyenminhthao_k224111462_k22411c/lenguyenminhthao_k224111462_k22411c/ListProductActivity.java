package com.lnmt.lenguyenminhthao_k224111462_k22411c.lenguyenminhthao_k224111462_k22411c;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lnmt.lenguyenminhthao_k224111462_k22411c.R;
import com.lnmt.lenguyenminhthao_k224111462_k22411c.models.Product;

public class ListProductActivity extends AppCompatActivity {


    ListView lvProduct;
    ArrayAdapter<Product> adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Product p=adapterProduct.getItem(i);
                displayProductDetailActivity(p);
            }
        });
    }

    private void displayProductDetailActivity(Product p) {
        Intent intent = new Intent(ListProductActivity.this,
                ProductDetailActivity.class);
        intent.putExtra("SELECTED_PRODUCT", p);
        startActivity(intent);
    }

    private void addViews() {
        lvProduct=findViewById(R.id.lvProduct);
        adapterProduct=new ArrayAdapter<>(
                ListProductActivity.this,
                android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(adapterProduct);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_product,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_new_product)
        {
            Toast.makeText(ListProductActivity.this,
                    "Mở màn hình thêm mới sản phẩm",
                    Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(ListProductActivity.this,
                    AddProductActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.menu_broadcast_advertising)
        {
            Toast.makeText(ListProductActivity.this,
                    "Mở màn hình thông tin chi tiết sản phẩm",
                    Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(ListProductActivity.this,
                    AboutProductActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}