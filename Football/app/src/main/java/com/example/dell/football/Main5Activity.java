package com.example.dell.football;

import android.app.FragmentManager;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main5Activity extends Fragment {
private RecyclerView recyclerView;

    DatabaseReference mRootRef= FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef= mRootRef.child("condition");
    DatabaseReference [] gg={mRootRef.child("a1"),mRootRef.child("a2"),mRootRef.child("a3")};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View view=inflater.inflate(R.layout.activity_main5,container,false);

    recyclerView=view.findViewById(R.id.recycler);
        ArrayList<Items> arrayList=new ArrayList<>();
        MyAdapter myAdapter=new MyAdapter(arrayList,getContext());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
        arrayList.add(new Items("RUSSIA","19:00\n14/Jun","SAUDI ARABIA",R.drawable.rus,R.drawable.ksa));
    arrayList.add(new Items("EGYPT","16:00\n15/Jun","URUGUAY",R.drawable.egy,R.drawable.uru));
    arrayList.add(new Items("MOROCCO","19:00\n15Jun","IR IRAN",R.drawable.mar,R.drawable.irn));
    arrayList.add(new Items("PORTUGAL","22:00\n15/Jun","SPAIN",R.drawable.por,R.drawable.esp));
    arrayList.add(new Items("FRANCE","14:00\n16/Jun","AUSTRALIA",R.drawable.fra,R.drawable.aus));
    arrayList.add(new Items("ARGENTINA","17:00\n16/Jun","ICELAND",R.drawable.arg,R.drawable.isl));
    arrayList.add(new Items("PERU","20:00\n16Jun","DENMARK",R.drawable.per,R.drawable.den));
    arrayList.add(new Items("CROATIA","14:00\n16/Jun","NIGERIA",R.drawable.cro,R.drawable.nga));
    arrayList.add(new Items("COSTA RICA","16:00\n17/Jun","SERBIA",R.drawable.crc,R.drawable.srb));
    arrayList.add(new Items("GERMANY","19:00\n17/Jun","MEXICO",R.drawable.ger,R.drawable.mex));
    arrayList.add(new Items("BRAZIL","22:00\n17/Jun","SWITZER",R.drawable.bra,R.drawable.sui));
    arrayList.add(new Items("SWEDEN","16:00\n18/Jun","KOREA",R.drawable.swe,R.drawable.kor));
    arrayList.add(new Items("BELGIUM","19:00\n18/Jun","PANAMA",R.drawable.bel,R.drawable.pan));
    arrayList.add(new Items("TUNISIA","22:00\n18/Jun","ENGLAND",R.drawable.tun,R.drawable.eng));
    arrayList.add(new Items("COLOMBIA","16:00\n19/Jun","JAPAN",R.drawable.col,R.drawable.jpn));
    arrayList.add(new Items("POLAND","19:00\n19/Jun","SENEGAL",R.drawable.pol,R.drawable.sen));
    arrayList.add(new Items("RUSSIA","22:00\n19/Jun","EGYPT",R.drawable.rus,R.drawable.egy));
    arrayList.add(new Items("PORTUGAL","16:00\n20/Jun","MOROCCO",R.drawable.por,R.drawable.mar));
    arrayList.add(new Items("URUGUAY","19:00\n20/Jun","SA ARABIA",R.drawable.uru,R.drawable.ksa));
    arrayList.add(new Items("IR IRAN","22:00\n20/Jun","SPAIN",R.drawable.irn,R.drawable.esp));
    arrayList.add(new Items("DENMARK","16:00\n21/Jun","AUSTRALIA",R.drawable.den,R.drawable.aus));
    arrayList.add(new Items("FRANCE","19:00\n21/Jun","PERU",R.drawable.fra,R.drawable.per));
    arrayList.add(new Items("ARGENTINA","22:00\n21/Jun","CROATIA",R.drawable.arg,R.drawable.cro));
    arrayList.add(new Items("BRAZIL","16:00\n22/Jun","COSTA RICA",R.drawable.bra,R.drawable.crc));
    arrayList.add(new Items("NIGERIA","19:00\n22/Jun","ICELAND",R.drawable.nga,R.drawable.isl));
    arrayList.add(new Items("SERBIA","22:00\n22/Jun","SWITZER",R.drawable.srb,R.drawable.sui));
    arrayList.add(new Items("BELGIUM","16:00\n23/Jun","TUNISIA",R.drawable.bel,R.drawable.tun));
    arrayList.add(new Items("KOREA","19:00\n23/Jun","MEXICO",R.drawable.kor,R.drawable.mex));
    arrayList.add(new Items("GERMANY","22:00\n23/Jun","SWEDEN",R.drawable.ger,R.drawable.swe));
    arrayList.add(new Items("ENGLAND","16:00\n24/Jun","PANAMA",R.drawable.eng,R.drawable.pan));
    arrayList.add(new Items("JAPAN","19:00\n24/Jun","SENEGAL",R.drawable.jpn,R.drawable.sen));
    arrayList.add(new Items("POLAND","22:00\n24/Jun","COLOMBIA",R.drawable.pol,R.drawable.col));
    arrayList.add(new Items("URUGUAY","18:00\n25/Jun","RUSSIA",R.drawable.uru,R.drawable.rus));
    arrayList.add(new Items("SA ARABIA","18:00\n25/Jun","EGYPT",R.drawable.ksa,R.drawable.egy));
    arrayList.add(new Items("IR IRAN","22:00\n25/Jun","PORTUGAL",R.drawable.irn,R.drawable.por));
    arrayList.add(new Items("SPAIN","22:00\n25/Jun","MOROCCO",R.drawable.esp,R.drawable.mar));
arrayList.add(new Items("DENMARK","18:00\n26/Jun","FRANCE",R.drawable.den,R.drawable.fra));
arrayList.add(new Items("AUSTRALIA","18:00\n26/Jun","PERU",R.drawable.aus,R.drawable.per));
arrayList.add(new Items("NIGERIA","22:00\n26/Jun","ARGENTINA",R.drawable.nga,R.drawable.arg));
arrayList.add(new Items("ICELAND","22:00\n26/Jun","CROATIA",R.drawable.isl,R.drawable.cro));
arrayList.add(new Items("MEXICO","18:00\n27/Jun","SWEDEN",R.drawable.mex,R.drawable.swe));
arrayList.add(new Items("KOREA","18:00\n27/Jun","GERMANY",R.drawable.kor,R.drawable.ger));
arrayList.add(new Items("SERBIA","22:00\n27/Jun","BRAZIL",R.drawable.srb,R.drawable.bra));
arrayList.add(new Items("SWITZER","22:00\n27/Jun","COSTA RICA",R.drawable.sui,R.drawable.crc));
arrayList.add(new Items("JAPAN","18:00\n28/Jun","POLAND",R.drawable.jpn,R.drawable.pol));
arrayList.add(new Items("SENEGAL","18:00\n28/Jun","COLOMBIA",R.drawable.sen,R.drawable.col));
arrayList.add(new Items("PANAMA","22:00\n28/Jun","TUNISIA",R.drawable.pan,R.drawable.tun));
arrayList.add(new Items("ENGLAND","22:00\n28/Jun","BELGIUM",R.drawable.eng,R.drawable.bel));
    return view;}

}
