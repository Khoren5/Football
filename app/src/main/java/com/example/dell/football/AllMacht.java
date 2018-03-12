package com.example.dell.football;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AllMacht extends AppCompatActivity {
private ImageButton het2;
private final String TAG="ERROR";
private RecyclerView recyclerView;
private ArrayList<Glavni> arrayList;
FirebaseFirestore firestore;
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_macht);
        recyclerView=findViewById(R.id.allmacht);
        het2=findViewById(R.id.het2);
        progressDialog=new ProgressDialog(AllMacht.this);
        progressDialog.setMessage("Wi-Fi...");
        progressDialog.show();
        arrayList=new ArrayList<>();
        final AllmatchAdapter allmatchAdpter=new AllmatchAdapter(arrayList,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(allmatchAdpter);
        het2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AllMacht.this,Main7Activity.class);
                startActivity(intent);
            }
        });
        firestore=FirebaseFirestore.getInstance();
        firestore.collection("AllMacht").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e!=null){
                    Log.d(TAG,e.getMessage());
                    progressDialog.dismiss();
                }for (DocumentChange doc: documentSnapshots.getDocumentChanges()) {
                    if (doc.getType() == DocumentChange.Type.ADDED ) {
                        progressDialog.dismiss();
    progressDialog.dismiss();
                        Glavni glavni = doc.getDocument().toObject(Glavni.class);
                        arrayList.add(glavni);
                        allmatchAdpter.notifyDataSetChanged();

                    }
                }
            }
        });
    }
}
