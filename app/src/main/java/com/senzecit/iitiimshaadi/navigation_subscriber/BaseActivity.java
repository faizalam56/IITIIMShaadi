package com.senzecit.iitiimshaadi.navigation_subscriber;


import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.senzecit.iitiimshaadi.R;
import com.senzecit.iitiimshaadi.activity.AboutUsActivity;
import com.senzecit.iitiimshaadi.activity.AlertPlanActivity;
import com.senzecit.iitiimshaadi.activity.ChatMessagesActivity;
import com.senzecit.iitiimshaadi.activity.ContactUsActivity;
import com.senzecit.iitiimshaadi.activity.CustomFolderActivity;
import com.senzecit.iitiimshaadi.activity.DisclaimerActivity;
import com.senzecit.iitiimshaadi.activity.FAQActivity;
import com.senzecit.iitiimshaadi.activity.FriendsActivity;
import com.senzecit.iitiimshaadi.activity.HowToNavigatePageActivity;
import com.senzecit.iitiimshaadi.activity.YoutubeActivity;
import com.senzecit.iitiimshaadi.activity.MediaCoverageActivity;
import com.senzecit.iitiimshaadi.activity.PremierServicesActivity;
import com.senzecit.iitiimshaadi.activity.PrivacyActivity;
import com.senzecit.iitiimshaadi.activity.ProfileActivity;
import com.senzecit.iitiimshaadi.activity.SearchPartnerActivity;
import com.senzecit.iitiimshaadi.activity.SettingsActivity;
import com.senzecit.iitiimshaadi.activity.SubscriptionActivity;
import com.senzecit.iitiimshaadi.activity.SuccessStoriesActivity;
import com.senzecit.iitiimshaadi.activity.UploadVideoActivity;
import com.senzecit.iitiimshaadi.activity.WalletActivity;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    DrawerLayout drawer;
    FrameLayout frameLayout;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        drawer = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);

        FrameLayout activityContainer = (FrameLayout) drawer.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        //getLayoutInflater().inflate(R.layout.activity_home, activityContainer, true);
        super.setContentView(drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        final ToggleButton rightToggle = (ToggleButton)findViewById(R.id.right_menu_toggle);
//        Button btn1 = (Button) findViewById(R.id.idNavHome);
        ImageView mChatIV = (ImageView)findViewById(R.id.idChat);
        mChatIV.setOnClickListener(this);
        setSupportActionBar(toolbar);

        frameLayout = (FrameLayout) findViewById(R.id.activity_content);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);



        rightToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rightToggle.isChecked())
                {
                    drawer.openDrawer(Gravity.RIGHT);
                    drawer.bringToFront();
                    drawer.requestLayout();
                }else{
                    drawer.closeDrawer(Gravity.RIGHT);
                }
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.requestLayout();
        View headerview = navigationView.getHeaderView(0);

        TextView mSearchPartnerBtn = (TextView)headerview.findViewById(R.id.idSearchPartnerNav);
        TextView mFriendsBtn = (TextView)headerview.findViewById(R.id.idfriendsNav);
        TextView mChatMessageBtn = (TextView)headerview.findViewById(R.id.idChatMessageNav);
        TextView mSubscriptionBtn = (TextView)headerview.findViewById(R.id.idSubscriptionNav);

        TextView mPremierServiceBtn = (TextView)headerview.findViewById(R.id.idPremierServiceNav);
        TextView mAboutBtn = (TextView)headerview.findViewById(R.id.idAboutNav);
        TextView mMediaCovBtn = (TextView)headerview.findViewById(R.id.idMediaCoverageNav);
        TextView mSuccessStoryBtn = (TextView)headerview.findViewById(R.id.idSuccessStoryNav);
        TextView mHowToNavBtn = (TextView)headerview.findViewById(R.id.idHowToNav);
        TextView mPrivacyPolicyBtn = (TextView)headerview.findViewById(R.id.idPrivacyPolicyNav);
        TextView mContactUsBtn = (TextView)headerview.findViewById(R.id.idContactUsNav);
        TextView mFaqBtn = (TextView)headerview.findViewById(R.id.idFAQNav);
        TextView mDisclaimerBtn = (TextView)headerview.findViewById(R.id.idDisclaimerNav);
        TextView mWallet = (TextView)headerview.findViewById(R.id.idWalletNav);
        TextView mReferFriend = (TextView)headerview.findViewById(R.id.idReferFriendNav);
        TextView mUploadVideo = (TextView)headerview.findViewById(R.id.idUploadVideoNav);
        TextView mSettings = (TextView)headerview.findViewById(R.id.idSettingNav);
        TextView mMyProfile = (TextView)headerview.findViewById(R.id.idMyProfileNav);
        TextView mCustomFolder = (TextView)headerview.findViewById(R.id.idCustomFolderNav);

        mSearchPartnerBtn.setOnClickListener(BaseActivity.this);
        mFriendsBtn.setOnClickListener(BaseActivity.this);
        mChatMessageBtn.setOnClickListener(BaseActivity.this);
        mSubscriptionBtn.setOnClickListener(BaseActivity.this);

        mPremierServiceBtn.setOnClickListener(BaseActivity.this);
        mAboutBtn.setOnClickListener(BaseActivity.this);
        mMediaCovBtn.setOnClickListener(BaseActivity.this);
        mSuccessStoryBtn.setOnClickListener(BaseActivity.this);
        mHowToNavBtn.setOnClickListener(BaseActivity.this);
        mPrivacyPolicyBtn.setOnClickListener(BaseActivity.this);
        mContactUsBtn.setOnClickListener(BaseActivity.this);
        mFaqBtn.setOnClickListener(BaseActivity.this);
        mDisclaimerBtn.setOnClickListener(BaseActivity.this);
        mSettings.setOnClickListener(BaseActivity.this);
        mMyProfile.setOnClickListener(BaseActivity.this);
        mCustomFolder.setOnClickListener(BaseActivity.this);
        mWallet.setOnClickListener(BaseActivity.this);
        mReferFriend.setOnClickListener(BaseActivity.this);
        mUploadVideo.setOnClickListener(BaseActivity.this);

        // SET DEFAULT COLOR
        /*homeBtn.setTextColor(Color.parseColor("#000000"));
        newsFeedBtn.setTextColor(Color.parseColor("#000000"));
        calculatorBtn.setTextColor(Color.parseColor("#000000"));
        homeBtn.setTextColor(Color.parseColor("#000000"));
*/

        if(layoutResID == R.layout.activity_subscriber_dashboard)
        {
//            homeBtn.setTextColor(Color.parseColor("#66d9ff"));
        }/*else if(layoutResID == R.layout.activity_newsfeed)
        {
            newsFeedBtn.setTextColor(Color.parseColor("#66d9ff"));
        }else if(layoutResID == R.layout.activity_calculator)
        {
            calculatorBtn.setTextColor(Color.parseColor("#66d9ff"));
        }else if(layoutResID == R.layout.activity_notification)
        {
            notificationBtn.setTextColor(Color.parseColor("#66d9ff"));
        }
*/
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {

            case R.id.idSearchPartnerNav: {
                // Toast.makeText(getApplicationContext(), "Search Partner", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,SearchPartnerActivity.class));
                break;
            }
            case R.id.idfriendsNav: {
                // Toast.makeText(getApplicationContext(), "Friends Navigation", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,FriendsActivity.class));
                break;
            }
            case R.id.idChatMessageNav: {
                // Toast.makeText(getApplicationContext(), "Upload your document", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this, ChatMessagesActivity.class));
//                startActivity(new Intent(BaseActivity.this,ChatMessagesActivity.class));
                break;
            }
            case R.id.idSubscriptionNav: {
                // Toast.makeText(getApplicationContext(), "Subscription", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,SubscriptionActivity.class));
                break;
            }
            case R.id.idPremierServiceNav: {
                // Toast.makeText(getApplicationContext(), "Premier Services", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,PremierServicesActivity.class));
                break;
            }
            case R.id.idAboutNav: {
                // Toast.makeText(getApplicationContext(), "About", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,AboutUsActivity.class));
                break;
            }
            case R.id.idMediaCoverageNav: {
                // Toast.makeText(getApplicationContext(), "Media Coverage", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,MediaCoverageActivity.class));
                break;
            }
            case R.id.idSuccessStoryNav: {
                // Toast.makeText(getApplicationContext(), "Success Story", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,SuccessStoriesActivity.class));
                break;
            }
            case R.id.idHowToNav: {
                // Toast.makeText(getApplicationContext(), "How To Navigate", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this, HowToNavigatePageActivity.class));
                break;
            }
            case R.id.idPrivacyPolicyNav: {
                // Toast.makeText(getApplicationContext(), "Privacy Policy", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this, PrivacyActivity.class));
                break;
            }
            case R.id.idContactUsNav: {
                // Toast.makeText(getApplicationContext(), "Contact Us", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,ContactUsActivity.class));
                break;
            }
            case R.id.idFAQNav: {
                // Toast.makeText(getApplicationContext(), "FAQ", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,FAQActivity.class));
                break;
            }
            case R.id.idDisclaimerNav: {
                // Toast.makeText(getApplicationContext(), "FAQ", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,DisclaimerActivity.class));
                break;
            }
            case R.id.idWalletNav: {
                // Toast.makeText(getApplicationContext(), "FAQ", // Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BaseActivity.this,WalletActivity.class);
                intent.putExtra("type","wallet");
                startActivity(intent);
                break;
            }
            case R.id.idReferFriendNav: {
                // Toast.makeText(getApplicationContext(), "FAQ", // Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BaseActivity.this,WalletActivity.class);
                intent.putExtra("type","referFriend");
                startActivity(intent);
                break;
            }
            case R.id.idUploadVideoNav: {
                // Toast.makeText(getApplicationContext(), "FAQ", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,UploadVideoActivity.class));
                break;
            }
            case R.id.idSettingNav: {
                // Toast.makeText(getApplicationContext(), "FAQ", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,SettingsActivity.class));
                break;
            }
            case R.id.idMyProfileNav: {
                // Toast.makeText(getApplicationContext(), "FAQ", // Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,ProfileActivity.class));
                break;
            }
            case R.id.idCustomFolderNav: {
                // Toast.makeText(getApplicationContext(), "FAQ", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BaseActivity.this,CustomFolderActivity.class));
                break;
            }
            case R.id.idChat:
                startActivity(new Intent(BaseActivity.this, AlertPlanActivity.class));
                break;

        }
    }

}
