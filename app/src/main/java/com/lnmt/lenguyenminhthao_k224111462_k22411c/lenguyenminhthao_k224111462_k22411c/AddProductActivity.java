package com.lnmt.lenguyenminhthao_k224111462_k22411c.lenguyenminhthao_k224111462_k22411c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lnmt.lenguyenminhthao_k224111462_k22411c.R;
import com.lnmt.lenguyenminhthao_k224111462_k22411c.models.Product;

public class AddProductActivity extends AppCompatActivity {

    EditText edtProductCode;
    EditText edtProductName;

    EditText edtUnitPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initializeViews() {
        edtProductCode = findViewById(R.id.edtProductCode);
        edtProductName = findViewById(R.id.edtProductName);
        edtUnitPrice = findViewById(R.id.edtUnitPrice);
    }

    public void saveProduct(View view) {
        String productCode = edtProductCode.getText().toString().trim();
        String productName = edtProductName.getText().toString().trim();
        String unitPriceStr = edtUnitPrice.getText().toString().trim();

        if (areFieldsEmpty(productCode, productName, unitPriceStr)) {
            showToast("Please fill all fields!");
            return;
        }

        double unitPrice = parseUnitPrice(unitPriceStr);
        if (unitPrice == -1) {
            showToast("Invalid Unit Price!");
            return;
        }

        Product newProduct = new Product(0, productCode, productName, unitPrice, "");

        returnResult(newProduct);
    }

    private boolean areFieldsEmpty(String productCode, String productName, String unitPriceStr) {
        return productCode.isEmpty() || productName.isEmpty() || unitPriceStr.isEmpty();
    }

    private double parseUnitPrice(String unitPriceStr) {
        try {
            return Double.parseDouble(unitPriceStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void returnResult(Product newProduct) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("NEW_PRODUCT", newProduct);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

}