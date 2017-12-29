package com.senzecit.iitiimshaadi.activity;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.senzecit.iitiimshaadi.R;
import com.senzecit.iitiimshaadi.customdialog.CustomListAdapterDialog;
import com.senzecit.iitiimshaadi.customdialog.MainActivity;
import com.senzecit.iitiimshaadi.customdialog.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class RegistrationQuickActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar mToolbar;
    TextView mTitle;
    Button mbuttonContinue;
    ImageView mBoySelect,mBoyUnSelect,mGirlSelect,mGirlUnSelect;
    TextView mEducationTV, mStreamTV, mInstitutionTV;
    RelativeLayout mEducationRL, mStreamRL, mInstitutionRL;
    EditText mUserNameET, mEmailET, mMobileET, mCollegeNameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration_quick);

        init();
        mbuttonContinue.setOnClickListener(this);
        mBoySelect.setOnClickListener(this);
        mBoyUnSelect.setOnClickListener(this);
        mGirlSelect.setOnClickListener(this);
        mGirlUnSelect.setOnClickListener(this);

        mEducationRL.setOnClickListener(this);
        mStreamRL.setOnClickListener(this);
        mInstitutionRL.setOnClickListener(this);


    }

    private void init(){
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.toolbar_title);
        mTitle.setText("Quick Register");

        mbuttonContinue = (Button) findViewById(R.id.continueBtn);

        mBoySelect = (ImageView) findViewById(R.id.boySelect);
        mBoyUnSelect = (ImageView) findViewById(R.id.boyUnSelect);
        mGirlSelect = (ImageView) findViewById(R.id.girlSelect);
        mGirlUnSelect = (ImageView) findViewById(R.id.girlUnSelect);

        mEducationTV = (TextView) findViewById(R.id.educationTV);
        mStreamTV = (TextView) findViewById(R.id.idStreamTV);
        mInstitutionTV = (TextView) findViewById(R.id.idInstitutionTV);

        mEducationRL = (RelativeLayout) findViewById(R.id.id_educationRL);
        mStreamRL = (RelativeLayout) findViewById(R.id.id_streamRL);
        mInstitutionRL = (RelativeLayout) findViewById(R.id.id_institutionRL);

        mUserNameET = (EditText) findViewById(R.id.userNameET);
        mEmailET = (EditText) findViewById(R.id.emailET);
        mMobileET = (EditText) findViewById(R.id.mobileET);
        mCollegeNameET = (EditText) findViewById(R.id.collegeNameET);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.continueBtn:
                startActivity(new Intent(RegistrationQuickActivity.this,NewUserRegiaterActivity.class));
                break;
            case R.id.boyUnSelect:
                mBoySelect.setVisibility(View.VISIBLE);
                mBoyUnSelect.setVisibility(View.GONE);
                mGirlSelect.setVisibility(View.GONE);
                mGirlUnSelect.setVisibility(View.VISIBLE);
                gender();
                break;
            case R.id.girlUnSelect:
                mGirlSelect.setVisibility(View.VISIBLE);
                mGirlUnSelect.setVisibility(View.GONE);
                mBoySelect.setVisibility(View.GONE);
                mBoyUnSelect.setVisibility(View.VISIBLE);
                gender();
                break;
            case R.id.id_educationRL:
                showEducation();
                break;
            case R.id.id_streamRL:
                showStream();
                break;
            case R.id.id_institutionRL:
                showCountry();
                break;
        }
    }


    public String gender(){
        if(mBoySelect.getVisibility() == View.VISIBLE){
            Toast.makeText(this, "Male", Toast.LENGTH_LONG).show();
        }else if(mGirlSelect.getVisibility() == View.VISIBLE){
            Toast.makeText(this, "Female", Toast.LENGTH_LONG).show();
        }
        return  null;
    }

    public void showEducation(){
        List<String> educationList = new ArrayList<>();
        educationList.add("Indian");
        educationList.add("InterNational");
        showDialog(educationList, mEducationTV);
    }
    public void showStream(){
        List<String> streamList = new ArrayList<>();
        streamList.add("BBA");
        streamList.add("BCA");
        streamList.add("MBA");
        streamList.add("MCA");

        showDialog(streamList, mStreamTV);
    }
    public void showCountry(){
        List<String> countryList = new ArrayList<>();
        countryList.add("India");
        countryList.add("Russia");
        countryList.add("America");
        countryList.add("China");
        showDialog(countryList, mInstitutionTV);
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

        final CustomListAdapterDialog clad1 = new CustomListAdapterDialog(RegistrationQuickActivity.this, models);
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
