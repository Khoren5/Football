package com.example.dell.football;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyUefaAdapter extends RecyclerView.Adapter<MyUefaAdapter.ViewHolder> {
private List<UefaItems> arrayList1;
    public MyUefaAdapter(ArrayList<UefaItems> arrayList){
    this.arrayList1=arrayList;

}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.uefa,parent,false);
       ViewHolder myUefaHolder= new ViewHolder(view);

      return myUefaHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.komand10.setText(arrayList1.get(position).getKomand1());
holder.komand20.setText(arrayList1.get(position).getKomand2());
holder.time.setText(arrayList1.get(position).getTime1());
holder.amis.setText(arrayList1.get(position).getAmis());
holder.pul5.setText(arrayList1.get(position).getPul1());
    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
private TextView komand10,komand20,amis,pul5,time;
        public ViewHolder(View itemView) {
            super(itemView);
            komand10=itemView.findViewById(R.id.komand10);
            komand20=itemView.findViewById(R.id.komand20);
            amis=itemView.findViewById(R.id.amis);
            pul5=itemView.findViewById(R.id.pul5);
            time=itemView.findViewById(R.id.time71);
        }
    }
}
