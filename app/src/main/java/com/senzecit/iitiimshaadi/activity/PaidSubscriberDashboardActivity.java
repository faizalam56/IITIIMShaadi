package com.senzecit.iitiimshaadi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.senzecit.iitiimshaadi.R;
import com.senzecit.iitiimshaadi.navigation_paid.PaidBaseActivity;
import com.senzecit.iitiimshaadi.utils.CircleImageView;
import com.senzecit.iitiimshaadi.utils.alert.AlertDialogSingleClick;


public class PaidSubscriberDashboardActivity extends PaidBaseActivity {

    ScrollView mScrollView;
    CircleImageView mProfileCIV;
    ImageView mAlbumIV;
    TextView mUsrNameTV, mUsrIdTV, mProfilePercTV, mMyProfileTV, mProfileShowTV, mShowMessageTV;
    TextView mFriendsTV, mSearchPartnerTV, mPremServicesTV, mChatMessageTV, mSubscriptionTV, mCustomFolderTV, mWalletTV, mUploadVideoTV, mReferFrndTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_subscriber_dashboard);

        initView();
        handleClick();
    }

    public void initView(){
        mProfileCIV = (CircleImageView)findViewById(R.id.idProfileCIV);
        mUsrNameTV = (TextView) findViewById(R.id.idUserNameTV);
        mProfilePercTV = (TextView)  findViewById(R.id.idProfilePercTV);
        mMyProfileTV = (TextView)findViewById(R.id.idMyProfileTV);

        mProfileShowTV = (TextView)findViewById(R.id.idProfileShowTV) ;
        mShowMessageTV = (TextView)findViewById(R.id.idShowMessageTV);
        mAlbumIV = (ImageView) findViewById(R.id.idAlbum);

        //BOTTOM
        mFriendsTV = (TextView)findViewById(R.id.idFriendsTV) ;
        mSearchPartnerTV = (TextView)findViewById(R.id.idSearchPartnerTV) ;
        mPremServicesTV = (TextView)findViewById(R.id.idPremServicesTV) ;
        mChatMessageTV = (TextView)findViewById(R.id.idChatMessageTV) ;
        mSubscriptionTV = (TextView)findViewById(R.id.idSubscriptionTV) ;
        mCustomFolderTV = (TextView)findViewById(R.id.idCustFolderTV) ;
        mWalletTV = (TextView)findViewById(R.id.idWalletTV) ;
        mUploadVideoTV = (TextView)findViewById(R.id.idUploadVideoTV) ;
        mReferFrndTV = (TextView)findViewById(R.id.idReferFrndTV) ;

    }
    public void handleClick(){
        mProfileCIV.setOnClickListener(this);
        mMyProfileTV.setOnClickListener(this);
        mProfileShowTV.setOnClickListener(this);
        mShowMessageTV.setOnClickListener(this);
        mAlbumIV.setOnClickListener(this);
        mFriendsTV.setOnClickListener(this);
        mSearchPartnerTV.setOnClickListener(this);
        mPremServicesTV.setOnClickListener(this);
        mChatMessageTV.setOnClickListener(this);
        mSubscriptionTV.setOnClickListener(this);
        mCustomFolderTV.setOnClickListener(this);
        mWalletTV.setOnClickListener(this);
        mUploadVideoTV.setOnClickListener(this);
        mReferFrndTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        switch (view.getId()){
            case R.id.idProfileCIV: {
                Toast.makeText(PaidSubscriberDashboardActivity.this,"Profile", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(PaidSubscriberDashboardActivity.this,ProfileActivity.class));
                break;
            }
            case R.id.idMyProfileTV: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"My Profile", //Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaidSubscriberDashboardActivity.this,ProfileActivity.class));
                break;
            }
            case R.id.idProfileShowTV: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Profile Show", //Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(PaidSubscriberDashboardActivity.this,ProfileActivity.class));
//                showToast("No interest received");
                new AlertDialogSingleClick().showDialog(PaidSubscriberDashboardActivity.this, "Alert!", "No interest received");
                break;
            }
            case R.id.idShowMessageTV: {
//                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Show Message", //Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(PaidSubscriberDashboardActivity.this,ChatMessagesActivity.class));
                new AlertDialogSingleClick().showDialog(PaidSubscriberDashboardActivity.this, "Alert!", "No message received");
                break;
            }
            case R.id.idAlbum: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Album", //Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaidSubscriberDashboardActivity.this,AlbumActivity.class));
                break;
            }
            case R.id.idFriendsTV: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Friens", //Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaidSubscriberDashboardActivity.this,FriendsActivity.class));
                break;
            }
            case R.id.idSearchPartnerTV: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Search Partner", //Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaidSubscriberDashboardActivity.this,SearchPartnerPaidActivity.class));
                break;
            }
            case R.id.idPremServicesTV: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Premier Services", //Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaidSubscriberDashboardActivity.this,PremierServicesActivity.class));
                break;
            }
            case R.id.idChatMessageTV: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Chat/Message", //Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaidSubscriberDashboardActivity.this,ChatMessagesActivity.class));
                break;
            }
            case R.id.idSubscriptionTV: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Subscription", //Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaidSubscriberDashboardActivity.this,SubscriptionActivity.class));
                break;
            }
            case R.id.idCustFolderTV: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Custom Folder", //Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaidSubscriberDashboardActivity.this,CustomFolderActivity.class));
                break;
            }
            case R.id.idWalletTV: {
//                Intent intent = new Intent(PaidSubscriberDashboardActivity.this,WalletActivity.class);
//                intent.putExtra("type","wallet");
//                startActivity(intent);
                break;
            }
            case R.id.idUploadVideoTV: {
                //Toast.makeText(PaidSubscriberDashboardActivity.this,"Upload Video", //Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaidSubscriberDashboardActivity.this,UploadVideoActivity.class));
                break;
            }
            case R.id.idReferFrndTV: {
//                Toast.makeText(PaidSubscriberDashboardActivity.this,"Refer Friend", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(PaidSubscriberDashboardActivity.this,WalletActivity.class);
//                intent.putExtra("type","referFriend");
//                startActivity(intent);
                break;
            }

        }
    }

    public void showToast(String msg){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_dialog,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setImageResource(R.drawable.logo_main);
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(msg);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }
}
