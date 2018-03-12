package com.example.dell.football;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {
    private static final String TAG="FileLog";
    private ImageButton het1;
    FirebaseFirestore firestore2;
private RecyclerView recyclerView;
   private ArrayList<Items> arrayList;
ProgressDialog progressDialog;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    recyclerView=findViewById(R.id.recycler);
    het1=findViewById(R.id.het1);
    progressDialog=new ProgressDialog(Main5Activity.this);
    progressDialog.setMessage("Wi-Fi");
    progressDialog.show();
    het1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Main5Activity.this,Main7Activity.class);
            startActivity(intent);
        }
    });
        arrayList=new ArrayList<>();
        final MyAdapter myAdapter=new MyAdapter(arrayList,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
        firestore2=FirebaseFirestore.getInstance();
        firestore2.collection("FIFA").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
           if (e!=null){
               Log.d(TAG,e.getMessage());
           }for (DocumentChange doc1: documentSnapshots.getDocumentChanges()) {
                    if (doc1.getType() == DocumentChange.Type.ADDED ) {
                        progressDialog.dismiss();
                        Items items = doc1.getDocument().toObject(Items.class);
                        arrayList.add(items);
                        myAdapter.notifyDataSetChanged();

                    }
                }
            }
        });

}

}
