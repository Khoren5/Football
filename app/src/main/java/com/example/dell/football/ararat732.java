package com.example.dell.football;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Created by DELL on 24.02.2018.
 */

public class ararat732 extends android.support.v4.app.Fragment {
    private ImageView ararat7320;
    private Context context;

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ararat732,container,false);
        ararat7320=view.findViewById(R.id.ararat7320);
        context=view.getContext();
        try {
            Firebas1("ararat73",ararat7320);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }
    public void  Firebas1(String child, final ImageView a)throws IOException {

        DatabaseReference condition=databaseReference.child(child);
        condition.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String  nn1 =dataSnapshot.getValue(String.class);
                Picasso.with(context).load(nn1).into(a);

            }  @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
