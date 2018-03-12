package com.example.dell.football;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class araraat733 extends Fragment {
    private ImageView ararat7333;
private Context context;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.araraat733k,container,false);
        ararat7333=view.findViewById(R.id.ararat7333);
        context=view.getContext();
        try {
            Firebas1("ararat731",ararat7333);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    } public void  Firebas1(String child, final ImageView a)throws IOException {

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
