package com.example.dell.football;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DELL on 11.02.2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    public List<Users> usersList;
    public UserAdapter(List<Users> usersList){

        this.usersList=usersList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.tim11.setText(usersList.get(position).getTim1());
holder.tim22.setText(usersList.get(position).getTim2());
holder.hashiv11.setText(usersList.get(position).getHashiv());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
private TextView tim11,tim22,hashiv11;
        public ViewHolder(View itemView) {
            super(itemView);
            tim11=itemView.findViewById(R.id.tim11);
            tim22=itemView.findViewById(R.id.tim22);
            hashiv11=itemView.findViewById(R.id.hashiv11);
        }
    }
}
