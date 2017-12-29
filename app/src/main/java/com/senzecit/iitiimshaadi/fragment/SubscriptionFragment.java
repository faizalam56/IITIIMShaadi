package com.senzecit.iitiimshaadi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.senzecit.iitiimshaadi.R;
import com.senzecit.iitiimshaadi.adapter.SubscriptionTransactionAdapter;
import com.senzecit.iitiimshaadi.utils.LinearLayoutManagerWithSmoothScroller;

/**
 * Created by ravi on 22/11/17.
 */

public class SubscriptionFragment extends Fragment implements View.OnClickListener {
    View view;
    Button mUpgradeSubscription;
    SubscriptionFragmentCommunicator communicator;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;

    public void setSubscriptionFragmentCommunicator(SubscriptionFragmentCommunicator communicator){
        this.communicator = communicator;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_subscription_new,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        mUpgradeSubscription.setOnClickListener(this);
        SubscriptionTransactionAdapter adapter = new SubscriptionTransactionAdapter();
        mRecyclerView.setAdapter(adapter);
    }

    private void init(){
       mUpgradeSubscription = view.findViewById(R.id.idSubscriptionBtn);
       mRecyclerView = view.findViewById(R.id.idSubsTranDetail_RV);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true);
//        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(getActivity()));
        mRecyclerView.smoothScrollToPosition(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.idSubscriptionBtn:
                communicator.upgradeSubscription();
                break;
        }
    }

    public interface SubscriptionFragmentCommunicator{
        void upgradeSubscription();
    }

}
