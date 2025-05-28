package com.lnmt.lenguyenminhthao_k224111462_k22411c.lenguyenminhthao_k224111462_k22411c;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lnmt.lenguyenminhthao_k224111462_k22411c.R;
import com.lnmt.lenguyenminhthao_k224111462_k22411c.connector.AccountConnector;
import com.lnmt.lenguyenminhthao_k224111462_k22411c.models.Account;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;
    CheckBox chkSaveLogin;

    private long lastBackPressedTime = 0;
    private static final long BACK_PRESS_THRESHOLD = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtUserName=findViewById(R.id.edtUserName);
        edtPassword=findViewById(R.id.edtPassword);
        chkSaveLogin=findViewById(R.id.chkSaveLoginInfor);
    }

    public void do_login(View view) {

        String usr=edtUserName.getText().toString();
        String pwd=edtPassword.getText().toString();
        AccountConnector connector = new AccountConnector();
        Account account = connector.login(usr, pwd);

        if (account != null) {
            Intent intent = new Intent(this, ListProductActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Login failed - please check your credentials!", Toast.LENGTH_LONG).show();
        }
    }

    public void do_exit(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
        Resources res=getResources();
        //thiet lap tieu de
        builder.setTitle(res.getText(R.string.confirm_exit_title));
        //noi dung cua so
        builder.setMessage(res.getText(R.string.confirm_exit_message));
        //bieu tuong
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        //thiet lap tuong tac Yes
        builder.setPositiveButton(res.getText(R.string.confirm_exit_yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //System.exit(0);
                finish();
            }
        });
        builder.setNegativeButton(res.getText(R.string.confirm_exit_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastBackPressedTime <= BACK_PRESS_THRESHOLD) {
            do_exit(null);
        } else {
            lastBackPressedTime = currentTime;
            Toast.makeText(this, "Nhấn lần nữa để thoát", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveLoginInformation()
    {
        SharedPreferences preferences=getSharedPreferences("LOGIN_INFORMATION",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        String usr=edtUserName.getText().toString();
        String pwd=edtPassword.getText().toString();
        boolean isSave=chkSaveLogin.isChecked();
        editor.putString("USERNAME:",usr);
        editor.putString("PASSWORD",pwd);
        editor.putBoolean("SAVED",isSave);
        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveLoginInformation();
    }

    public void restoreLoginInformation()
    {
        SharedPreferences preferences=getSharedPreferences("LOGIN_INFORMATION",MODE_PRIVATE);
        String usr=preferences.getString("USERNAME", "");
        String pwd=preferences.getString("PASSWORD","");
        boolean isSave=preferences.getBoolean("SAVED",true);
        if(isSave)
        {
            edtUserName.setText(usr);
            edtPassword.setText(pwd);
            chkSaveLogin.setChecked(isSave);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreLoginInformation();
    }
}