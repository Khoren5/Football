package com.example.dell.football;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by DELL on 11.02.2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
private Context context;
    String []textt={"La Liga","Bundesliga"};
    int []nkarr={R.drawable.laliga,R.drawable.bundesliga};
String [] Urrl={"https://www.google.am/search?q=laliga&oq=la&aqs=chrome.0.69i59j69i60l2j69i61j69i59j69i57.807j0j7&sourceid=chrome&ie=UTF-8#sie=lg;/g/11c6w1q_2s;2;/m/09gqx;mt;fp;1",
"https://www.google.am/search?q=bundesliga&oq=bunde&aqs=chrome.0.69i59l2j69i60j69i57j0l2.2199j1j9&sourceid=chrome&ie=UTF-8#sie=lg;/g/11c6vvhbmx;2;/m/037169;mt;fp;1"};
    public UserAdapter(Context context){
this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
holder.nameliga.setText(textt[position]);
holder.nkar111.setBackgroundResource(nkarr[position]);
holder.nameliga.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context,Main4Activity.class);
        intent.putExtra("liga",Urrl[position]);
        context.startActivity(intent);
    }
});

    }

    @Override
    public int getItemCount() {
        return textt.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
private Button nameliga;
private ImageView nkar111;
        public ViewHolder(View itemView) {
            super(itemView);
            nkar111=itemView.findViewById(R.id.nkar111);
           nameliga=itemView.findViewById(R.id.nameliga);
        }
    }
}
