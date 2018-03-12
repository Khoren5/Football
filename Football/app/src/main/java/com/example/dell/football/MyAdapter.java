package com.example.dell.football;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by DELL on 01.02.2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyRecyclerO> {
private ArrayList<Items> arrayList;
private Context context;
private String p;

MyAdapter(ArrayList<Items> arrayList,Context context){
    this.arrayList=arrayList;
    this.context=context;
}
    @Override
    public MyRecyclerO onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.khagher,parent,false);
        MyRecyclerO myRecyclerO=new MyRecyclerO(view);

        return myRecyclerO;
    }
    @Override
    public void onBindViewHolder(final MyRecyclerO holder, final int position) {
holder.komand1.setText(arrayList.get(position).getArajin());
holder.komand2.setText(arrayList.get(position).getErkrord());
holder.time.setText(arrayList.get(position).getJamanak());
holder.nkar1.setBackgroundResource(arrayList.get(position).getNkar11());
holder.nkar2.setBackgroundResource(arrayList.get(position).getNkar22());
final String t=String.valueOf(position);
holder.swich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

if (isChecked==true){SharedPreferences sharedPreferences=context.getSharedPreferences("File",Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=sharedPreferences.edit();
editor.putString(t,"on");
    editor.apply();}else {SharedPreferences sharedPreferences=context.getSharedPreferences("File",Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=sharedPreferences.edit();
    editor.putString(t,"off");
    editor.apply();
}

    }
});SharedPreferences sharedPreferences=context.getSharedPreferences("File",Context.MODE_PRIVATE);
      p=sharedPreferences.getString(t,"off");
if (p.equals("on")){
   holder.swich.setChecked(true);
}else holder.swich.setChecked(false);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyRecyclerO extends RecyclerView.ViewHolder{
private TextView komand1,komand2,time;
private ImageView nkar1,nkar2;
private Switch swich;
        public MyRecyclerO(View itemView) {
            super(itemView);
            komand1=itemView.findViewById(R.id.komand1);
            komand2=itemView.findViewById(R.id.komand2);
            time=itemView.findViewById(R.id.time);
            nkar1=itemView.findViewById(R.id.nkar1);
            nkar2=itemView.findViewById(R.id.nkar2);
            swich=itemView.findViewById(R.id.SWICH);

        }
    }
}
