package com.senzecit.iitiimshaadi.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.senzecit.iitiimshaadi.R;
import com.senzecit.iitiimshaadi.customdialog.CustomListAdapterDialog;
import com.senzecit.iitiimshaadi.customdialog.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

public class NewUserRegiaterActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar mToolbar;
    TextView mTitle, mProfileCreatedForTV, mGenderTV, mDateOfBirthTV;
    ImageView mTermCheck,mTermUnCheck;
    Button mUserRegister;
    RelativeLayout mProfileCreatedRL, mGenderRL, mDOBRL;
    EditText mUserNameET, mEmailET, mFullNameET, mPasswordET, mRePasswordET, mMobileET;
    int mDay, mMonth, mYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_user_regiater);
        init();

        mProfileCreatedRL.setOnClickListener(this) ;
        mGenderRL.setOnClickListener(this);
        mDOBRL.setOnClickListener(this) ;

        mTermCheck.setOnClickListener(this);
        mTermUnCheck.setOnClickListener(this);
        mUserRegister.setOnClickListener(this);
    }

    private void init(){
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.toolbar_title);
        mTitle.setText("New User Register");

        mProfileCreatedRL = (RelativeLayout)findViewById(R.id.idProfileCreatedFor) ;
        mGenderRL = (RelativeLayout)findViewById(R.id.idGenderRL) ;
        mDOBRL = (RelativeLayout)findViewById(R.id.idDobRL) ;

        mProfileCreatedForTV = (TextView) findViewById(R.id.profileCreateTV);
        mGenderTV = (TextView) findViewById(R.id.genderTV);
        mDateOfBirthTV = (TextView) findViewById(R.id.dateOfBirthTV);

        mTermCheck = (ImageView) findViewById(R.id.termCheckIV);
        mTermUnCheck = (ImageView) findViewById(R.id.termUnCheckIV);
        mUserRegister = (Button) findViewById(R.id.userRegisterBtn);

        mUserNameET = (EditText) findViewById(R.id.userNameET);
        mEmailET = (EditText) findViewById(R.id.emailET);
        mFullNameET = (EditText) findViewById(R.id.fullNameET);
        mPasswordET = (EditText) findViewById(R.id.passwordET);
        mRePasswordET = (EditText) findViewById(R.id.re_passwordET);
        mMobileET = (EditText) findViewById(R.id.mobileNoET);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.termCheckIV:
                mTermCheck.setVisibility(View.INVISIBLE);
                mTermUnCheck.setVisibility(View.VISIBLE);
                break;
            case R.id.termUnCheckIV:
                mTermCheck.setVisibility(View.VISIBLE);
                mTermUnCheck.setVisibility(View.INVISIBLE);
                break;

            case R.id.userRegisterBtn:
                startActivity(new Intent(NewUserRegiaterActivity.this,SubscriberDashboardActivity.class));
                break;
            case R.id.idProfileCreatedFor:
                showProfileCreatedFor();
                break;
            case R.id.idGenderRL:
                showGender();
                break;
            case R.id.idDobRL:
                showDateOfBirth();
                break;

        }
    }

    public void showProfileCreatedFor(){
        List<String> list = new ArrayList<>();
        list.add("Myself");
        list.add("Son");
        list.add("Daughter");
        list.add("Brother");
        list.add("Sister");
        list.add("Friend");
        list.add("Others");

        showDialog(list, mProfileCreatedForTV);
    }

    public void showGender(){
        List<String> list = new ArrayList<>();
        list.add("Male");
        list.add("Female");

        showDialog(list, mGenderTV);
    }

    public void showDateOfBirth(){

       Calendar cal1 = Calendar.getInstance();
       mYear = cal1.get(Calendar.YEAR);
       mMonth = cal1.get(Calendar.MONTH);
       mDay = cal1.get(Calendar.DAY_OF_MONTH);

       DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker datePicker, int year, int month, int day) {
               System.out.println(year);
               mDateOfBirthTV.setText(day+"/"+month+"/"+year);
           }
       }, mYear, mMonth, mDay);
       datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

        datePickerDialog.updateDate(mYear, mMonth, mDay);
       datePickerDialog.show();

    }

    public Vector<Dialog> dialogs = new Vector<Dialog>();
    private void showDialog(List<String> dataList, final TextView textView) {
        int d_width = 100;
        int d_height = 50;
        final ArrayList<Model> models = new ArrayList<Model>();
        if(dataList.size()>0){
            for (int i = 0; i < dataList.size(); i++) {
                Model model = new Model();
                model.setName(dataList.get(i));
                models.add(model);
            }
        }else {
            for (int i = 0; i < 20; i++) {
                Model model = new Model();
                model.setName("senzecit " + i);
                models.add(model);
            }
        }

        final Dialog dialog = new Dialog(this, R.style.CustomDialog);//,R.style.CustomDialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        View view = getLayoutInflater().inflate(R.layout.toast_layout, null);

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.custom_list);
//		final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        ((Button) view.findViewById(R.id.button_done)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        final CustomListAdapterDialog clad1 = new CustomListAdapterDialog(NewUserRegiaterActivity.this, models);
        recyclerView.setAdapter(clad1);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialogs.add(dialog);
        dialog.show();

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        Window window = dialog.getWindow();
        window.setGravity(Gravity.RIGHT);
        window.setLayout(width - d_width, height - d_height);

        clad1.setOnItemClickListener(new CustomListAdapterDialog.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, String id) {
                int positionInList = position % models.size();
                textView.setText(models.get(positionInList).getName());
                dialog.dismiss();

//				showDialog(130,50);
            }
        });
    }
}
