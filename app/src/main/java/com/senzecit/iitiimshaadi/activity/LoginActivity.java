package com.senzecit.iitiimshaadi.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.senzecit.iitiimshaadi.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mPassword,mUsername;
    TextView mRegisterNew,mForgotPassword;
    Button mLogin;
    Toolbar mToolbar;
    TextView mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        init();
        mForgotPassword.setOnClickListener(this);
        mRegisterNew.setOnClickListener(this);
        mLogin.setOnClickListener(this);
    }

    private void init(){
        mPassword = (EditText) findViewById(R.id.passwordET);
        mUsername = (EditText) findViewById(R.id.userNameET);
        mRegisterNew = (TextView) findViewById(R.id.registerTV);
        mForgotPassword = (TextView) findViewById(R.id.forgotpasswordTV);
        mLogin = (Button) findViewById(R.id.loginBtn);

        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.toolbar_title);
        mTitle.setText("Login");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forgotpasswordTV:
                alertDialog();
                break;
            case R.id.registerTV:
                startActivity(new Intent(LoginActivity.this,RegistrationQuickActivity.class));
                break;
            case R.id.loginBtn:
                startActivity(new Intent(LoginActivity.this,PaidSubscriberDashboardActivity.class));
                break;
        }
    }

    private void alertDialog(){

        final Button mConfirm,mLogin;
        EditText mUsernameOfForgotET;
        LayoutInflater inflater = (LayoutInflater) getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        final AlertDialog dialog = dialogBuilder.create();
        View dialogView = inflater.inflate(R.layout.forgot_password_layout,null);

        mUsernameOfForgotET = dialogView.findViewById(R.id.userNameForgotET);
        mConfirm = dialogView.findViewById(R.id.confirmBtn);
        mLogin = dialogView.findViewById(R.id.loginFPLBtn);

       /* mConfirm.setBackground(getResources().getDrawable(R.drawable.button_shape_select_forgot));
        mConfirm.setTextColor(getResources().getColor(R.color.colorWhite));*/

        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mConfirm.setBackground(getResources().getDrawable(R.drawable.button_shape_select_forgot));
                mConfirm.setTextColor(getResources().getColor(R.color.colorWhite));*/
                dialog.dismiss();
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mLogin.setBackground(getResources().getDrawable(R.drawable.button_shape_select_forgot));
                mLogin.setTextColor(getResources().getColor(R.color.colorWhite));*/
                dialog.dismiss();

            }
        });

        dialog.setView(dialogView);
        dialog.show();
    }
}
