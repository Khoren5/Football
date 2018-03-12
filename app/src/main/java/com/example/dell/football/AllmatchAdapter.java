package com.example.dell.football;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;


class AllmatchAdapter extends RecyclerView.Adapter<AllmatchAdapter.MyHelper> {
    private List<Glavni> arraylist;
    private Context context;
    private String p, amis = "./.", tari = "/", jama = "-:-";
    private int am = 1, tm = 2018, om = 1, jm = 0, rm = 0;
    private int[] zangvac;
    Calendar []calendar;
    Calendar[] calendar1;
    int sheri = 1;

    AllmatchAdapter(List<Glavni> arraylist, Context context) {
        this.arraylist = arraylist;
        this.context = context;
    }

    @Override
    public MyHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allmachtlist, parent, false);
        MyHelper myHelper = new MyHelper(view);

        return myHelper;


    }

    @Override
    public void onBindViewHolder(final MyHelper holder, final int position) {

        holder.pul.setText(arraylist.get(position).getPul());
        holder.tim2.setText(arraylist.get(position).getTim2());
        holder.tim1.setText(arraylist.get(position).getTim1());
        tm = Integer.parseInt(arraylist.get(position).getTm().toString());
        am = Integer.parseInt(arraylist.get(position).getAm().toString());
        om = Integer.parseInt(arraylist.get(position).getOm().toString());
        jm = Integer.parseInt(arraylist.get(position).getJm().toString());
        rm = Integer.parseInt(arraylist.get(position).getRm().toString());
        Picasso.with(context).load(arraylist.get(position).getNkar1()).into(holder.nkar1a);
        Picasso.with(context).load(arraylist.get(position).getNkar2()).into(holder.nkar2a);
        final String g = String.valueOf(position);

        TimeZone tz1 = TimeZone.getTimeZone("Asia/Yerevan");
        calendar1 = new Calendar[arraylist.size()];
        calendar1[position] = Calendar.getInstance();
        calendar1[position].setTimeZone(tz1);
        calendar1[position].set(tm, am, om, jm, rm);
        if (calendar1[position].getTimeInMillis() >= System.currentTimeMillis()) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("all", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (sharedPreferences.getString(g, "off").equals("avart")) {
                editor.putString(g, "skizb");
                editor.apply();
            }
            String pt = String.valueOf(calendar1[position].getTime());
            jama = pt.substring(10, 16);
            holder.jamanak.setText(jama);
            amis = pt.substring(4, 10);
            tari = pt.substring(pt.length() - 4, pt.length());
            holder.amsativ.setText(amis + "/" + tari);
            String skizb=sharedPreferences.getString(g,"avart");
            if (skizb.equals("skizb")||skizb.equals("on")||skizb.equals("off")){
                holder.notif.setEnabled(true);
            holder.notif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("all", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    if (isChecked == true) {
                        editor.putString(String.valueOf(position), "on");


                    } else {
                        editor.putString(String.valueOf(position), "off");
                    }
                    editor.apply();
                    editor.commit();
                    try {
                        AllmatchAdapter.this.notifyItemChanged(position);
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }

                }
            });


            p = sharedPreferences.getString(String.valueOf(position), "off");

            if (p.equals("on") && calendar1[position].getTimeInMillis() >= System.currentTimeMillis()) {
                Intent intent = new Intent(context, AlarmAll.class);
                intent.putExtra(g, "   "+arraylist.get(position).getPul() + "\n" + arraylist.get(position).getTim1() +
                        "   VS   " + arraylist.get(position).getTim2());
                intent.putExtra("c", g);
                intent.setFlags(position);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, position);
                calendar = new Calendar[arraylist.size()];
                TimeZone tz = TimeZone.getTimeZone("Asia/Yerevan");
                calendar[position] = Calendar.getInstance();
                calendar[position].setTimeZone(tz);
                calendar[position].set(tm, am, om, jm, rm);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar[position].getTimeInMillis(), pendingIntent);
                holder.notif.setChecked(true);
            } else {
                holder.notif.setChecked(false);
            }
        }
        }
            if (calendar1[position].getTimeInMillis() < System.currentTimeMillis()) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("all", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(g, "avart");
                editor.apply();

            }


            SharedPreferences sharedPreferences = context.getSharedPreferences("all", Context.MODE_PRIVATE);
            String avart = sharedPreferences.getString(g, "off");
            if (avart.equals("avart"))

            {
                holder.notif.setChecked(false);
                holder.notif.setAlpha(0);
                holder.notif.setEnabled(false);
                holder.jamanak.setText(arraylist.get(position).getG());
                String pt2 = String.valueOf(calendar1[position].getTime());
                amis= pt2.substring(4, 10);
                tari = pt2.substring(pt2.length() - 4, pt2.length());
                holder.amsativ.setText(amis + "/" + tari);
            }
    }
    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    class MyHelper extends RecyclerView.ViewHolder{
        private ImageView nkar1a,nkar2a;
        private TextView tim1,tim2,jamanak,amsativ,pul;
       private Switch notif;
        public MyHelper(View itemView) {
            super(itemView);
            notif=itemView.findViewById(R.id.notif);
            nkar1a=itemView.findViewById(R.id.nkarr1a);
            nkar2a=itemView.findViewById(R.id.nkarr2a);
            tim1=itemView.findViewById(R.id.komand10a);
            tim2=itemView.findViewById(R.id.komand20a);
            jamanak=itemView.findViewById(R.id.time71a);
            amsativ=itemView.findViewById(R.id.amis1a);
            pul=itemView.findViewById(R.id.pul5a);

        }
    }
}