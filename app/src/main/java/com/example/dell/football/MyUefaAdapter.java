package com.example.dell.football;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;


public class MyUefaAdapter extends RecyclerView.Adapter<MyUefaAdapter.ViewHolder> {
    private List<UefaItems> arrayList1;
    private Context context;
    private String p, amisuef = "./.", tari = "/", jam = "-:-";
    private int ua = 1, ut = 2018, ur = 1, uo = 1, uj = 1;
    Calendar[] calendar1;
    Calendar[] calendar;

    public MyUefaAdapter(ArrayList<UefaItems> arrayList, Context context) {
        this.arrayList1 = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.uefa, parent, false);
        ViewHolder myUefaHolder = new ViewHolder(view);

        return myUefaHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.komand10.setText(arrayList1.get(position).getKomand1());
        holder.komand20.setText(arrayList1.get(position).getKomand2());
        holder.pul5.setText(arrayList1.get(position).getPul1());
        ut = Integer.parseInt(arrayList1.get(position).getUt().toString());
        ua = Integer.parseInt(arrayList1.get(position).getUa().toString());
        uo = Integer.parseInt(arrayList1.get(position).getUo().toString());
        uj = Integer.parseInt(arrayList1.get(position).getUj().toString());
        ur = Integer.parseInt(arrayList1.get(position).getUr().toString());
        Picasso.with(context).load(arrayList1.get(position).getNkar1()).into(holder.nkarr1);
        Picasso.with(context).load(arrayList1.get(position).getNkar2()).into(holder.nkarr2);
        final String g = String.valueOf(position);
        TimeZone tz1 = TimeZone.getTimeZone("Asia/Yerevan");
        calendar1 = new Calendar[arrayList1.size()];
        calendar1[position] = Calendar.getInstance();
        calendar1[position].setTimeZone(tz1);
        calendar1[position].set(ut, ua, uo, uj, ur);
        if (calendar1[position].getTimeInMillis() >= System.currentTimeMillis()) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Uefa", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (sharedPreferences.getString(g, "off").equals("avart")) {
                editor.putString(g, "skizb");
                editor.apply();
            }
            String pt = String.valueOf(calendar1[position].getTime());
            jam = pt.substring(10, 16);
            holder.time.setText(jam);
            amisuef = pt.substring(4, 10);
            tari = pt.substring(pt.length() - 4, pt.length());
            holder.amis.setText(amisuef + "/" + tari);
            String skizb=sharedPreferences.getString(g,"avart");
            if (skizb.equals("skizb")||skizb.equals("on")||skizb.equals("off")){
                holder.swich.setEnabled(true);
            holder.swich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("Uefa", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    if (isChecked == true) {
                        editor.putString(String.valueOf(position), "on");


                    } else {
                        editor.putString(String.valueOf(position), "off");
                    }
                    editor.apply();
                    editor.commit();
                    try {
                        MyUefaAdapter.this.notifyItemChanged(position);
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }

                }
            });


            p = sharedPreferences.getString(String.valueOf(position), "off");

            if (p.equals("on")  && calendar1[position].getTimeInMillis() >= System.currentTimeMillis()) {
                Intent intent = new Intent(context, AlarmUefa.class);
                intent.putExtra(g, "   UEFA\n"+"  "+arrayList1.get(position).getPul1() + "\n" + arrayList1.get(position).getKomand1() +
                        "   VS   " + arrayList1.get(position).getKomand2());
                intent.putExtra("b",g);
                intent.setFlags(position);
                PendingIntent pendingIntent = PendingIntent.
                        getBroadcast(context, 0, intent, position);
                calendar = new Calendar[arrayList1.size()];
                TimeZone tz = TimeZone.getTimeZone("Asia/Yerevan");
                calendar[position] = Calendar.getInstance();
                calendar[position].setTimeZone(tz);
                calendar[position].set(ut, ua, uo, uj, ur);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar[position].getTimeInMillis(), pendingIntent);
                holder.swich.setChecked(true);
            } else {
                holder.swich.setChecked(false);
            }
        }
    }
        if (calendar1[position].

                getTimeInMillis() < System.

                currentTimeMillis())

        {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Uefa", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(g, "avart");
            editor.apply();

        }

        SharedPreferences sharedPreferences = context.getSharedPreferences("Uefa", Context.MODE_PRIVATE);
        String avart = sharedPreferences.getString(g, "off");
        if (avart.equals("avart"))

        {
            holder.swich.setChecked(false);
            holder.swich.setAlpha(0);
            holder.swich.setEnabled(false);
            holder.time.setText(arrayList1.get(position).getGu());
            String pt2 = String.valueOf(calendar1[position].getTime());
            amisuef = pt2.substring(4, 10);
            tari = pt2.substring(pt2.length() - 4, pt2.length());
            holder.amis.setText(amisuef + "/" + tari);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
private TextView komand10,komand20,amis,pul5,time;
private ImageView nkarr1,nkarr2;
private Switch swich;
        public ViewHolder(View itemView) {
            super(itemView);
            komand10=itemView.findViewById(R.id.komand10);
            komand20=itemView.findViewById(R.id.komand20);
            amis=itemView.findViewById(R.id.amis);
            swich=itemView.findViewById(R.id.switch1);
            pul5=itemView.findViewById(R.id.pul5);
            time=itemView.findViewById(R.id.time71);
            nkarr1=itemView.findViewById(R.id.nkarr1);
            nkarr2=itemView.findViewById(R.id.nkarr2);
        }
    }
}
