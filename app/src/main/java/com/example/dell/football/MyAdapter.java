package com.example.dell.football;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
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
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyRecyclerO> {
private ArrayList<Items> arrayList;
private Context context;
private String p,amis="./.",tari="/",jam="-:-";
private int a=0,t=0,j=0,o=0,r=0,gf;
Calendar []calendar1;
Calendar []calendar;

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
         t=Integer.parseInt(arrayList.get(position).getT().toString());
         a=Integer.parseInt(arrayList.get(position).getA().toString());
         o=Integer.parseInt(arrayList.get(position).getO().toString());
         j=Integer.parseInt(arrayList.get(position).getJ().toString());
         r=Integer.parseInt(arrayList.get(position).getR().toString());
        holder.pulf.setText(arrayList.get(position).getPulf());
        Picasso.with(context).load(arrayList.get(position).getNkar11()).into(holder.nkar1);
        Picasso.with(context).load(arrayList.get(position).getNkar22()).into(holder.nkar2);
        final String g=String .valueOf(position);


        TimeZone tz1=TimeZone.getTimeZone("Asia/Yerevan");
         calendar1=new Calendar[arrayList.size()];
        calendar1[position] = Calendar.getInstance();
        calendar1[position].setTimeZone(tz1);
        calendar1[position].set(t, a, o, j, r);
        if (calendar1[position].getTimeInMillis()>=System.currentTimeMillis()){
            SharedPreferences sharedPreferences=context.getSharedPreferences("Fif",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            if (sharedPreferences.getString(g,"off").equals("avart")){
            editor.putString(g,"skizb");
            editor.apply();}
        String pt=String.valueOf(calendar1[position].getTime());
        jam=pt.substring(10,16);
        holder.time.setText(jam);
        amis=pt.substring(4,10);
        tari=pt.substring(pt.length()-4,pt.length());
        holder.amisf.setText(amis+"/"+tari);
        String skizb=sharedPreferences.getString(g,"avart");
if (skizb.equals("skizb")||skizb.equals("on")||skizb.equals("off")){
  holder.swich.setEnabled(true);
        holder.swich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences sharedPreferences=context.getSharedPreferences("Fif",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
        if (isChecked==true){
        editor.putString(g,"on");

        }else {
            editor.putString(g,"off");

        } editor.apply();
                editor.commit();try {
                    MyAdapter.this.notifyItemChanged(position);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }

            }
        });
        p=sharedPreferences.getString(g,"off");

        if (p.equals("on")&&calendar1[position].getTimeInMillis()>=System.currentTimeMillis()) {
            Intent intent = new Intent(context, Alarm.class);
            intent.putExtra(g, "     FIFA\n"+"  "+arrayList.get(position).getPulf()+"\n"+arrayList.get(position).getArajin() + "   VS   " + arrayList.get(position).getErkrord());
            intent.putExtra("a",g);
            intent.setFlags(position);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, position);
            calendar=new Calendar[arrayList.size()];
            TimeZone tz=TimeZone.getTimeZone("Asia/Yerevan");
            calendar[position] =Calendar.getInstance();
            calendar[position].setTimeZone(tz);
            calendar[position].set(t, a, o, j, r);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar[position].getTimeInMillis()
                    , pendingIntent);
            holder.swich.setChecked(true);}else {holder.swich.setChecked(false);}}}
            if (calendar1[position].getTimeInMillis() < System.currentTimeMillis()) {
                SharedPreferences sharedPreferences=context.getSharedPreferences("Fif",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(g, "avart");
                editor.apply();

            }
        SharedPreferences sharedPreferences=context.getSharedPreferences("Fif",Context.MODE_PRIVATE);
       String avart= sharedPreferences.getString(g,"off");
            if (avart.equals("avart")){
                holder.swich.setChecked(false);
                holder.swich.setAlpha(0);
                holder.swich.setEnabled(false);
                holder.time.setText(arrayList.get(position).getCa());
                String pt2=String.valueOf(calendar1[position].getTime());
                amis=pt2.substring(4,10);
                tari=pt2.substring(pt2.length()-4,pt2.length());
                holder.amisf.setText(amis+"/"+tari);
            }
        }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyRecyclerO extends RecyclerView.ViewHolder{
private TextView komand1,komand2,time,pulf,amisf;
private ImageView nkar1,nkar2;
private Switch swich;
        public MyRecyclerO(View itemView) {
            super(itemView);
            komand1=itemView.findViewById(R.id.komand1);
            pulf=itemView.findViewById(R.id.pulf);
            amisf=itemView.findViewById(R.id.amisf);
            komand2=itemView.findViewById(R.id.komand2);
            time=itemView.findViewById(R.id.time);
            nkar1=itemView.findViewById(R.id.nkar1);
            nkar2=itemView.findViewById(R.id.nkar2);
            swich=itemView.findViewById(R.id.SWICH);

        }}
    }

