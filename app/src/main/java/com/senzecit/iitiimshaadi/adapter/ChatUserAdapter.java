package com.senzecit.iitiimshaadi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.senzecit.iitiimshaadi.R;
import com.senzecit.iitiimshaadi.fragment.ChatUserFragment;

import java.util.List;

/**
 * Created by ravi on 23/11/17.
 */

public class ChatUserAdapter extends RecyclerView.Adapter<ChatUserAdapter.MyViewHolder> {

    Context mContext;
    public ChatUserAdapter(Context mContext){
    this.mContext = mContext;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView mProfileIV;
        TextView mUsernameTV, mTimeSpentTV, mMessageTV;
        public MyViewHolder(View itemView) {
            super(itemView);


        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatuser_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

}
