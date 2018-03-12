package com.example.dell.football;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.Executor;

public class Main9Activity extends AppCompatActivity {
    private static final String TAG="FileLog";
    FirebaseFirestore firestore1;
private RecyclerView recyclerView;
private ImageButton het;
ProgressDialog progressDialog;
private  MyUefaAdapter myUefaAdapter;
private ArrayList<UefaItems> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        recyclerView=findViewById(R.id.recycleruefa);
        arrayList=new ArrayList<>();
        progressDialog=new ProgressDialog(Main9Activity.this);
        progressDialog.setMessage("Wi-Fi");
        progressDialog.show();
        recyclerView.setLayoutManager(new LinearLayoutManager(Main9Activity.this));
        myUefaAdapter=new MyUefaAdapter(arrayList,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myUefaAdapter);
        het=findViewById(R.id.het);

firestore1=FirebaseFirestore.getInstance();
het.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Main9Activity.this,Main7Activity.class);
        startActivity(intent);
    }
});
firestore1.collection("UEF").addSnapshotListener(new EventListener<QuerySnapshot>() {
    @Override
    public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
        if (e != null) {
            Log.d(TAG, "Error" + e.getMessage());
        } for (DocumentChange doc: documentSnapshots.getDocumentChanges()) {
            if (doc.getType() == DocumentChange.Type.ADDED ) {
                progressDialog.dismiss();
                UefaItems uefaItems = doc.getDocument().toObject(UefaItems.class);
                arrayList.add(uefaItems);
                myUefaAdapter.notifyDataSetChanged();

            }
        }
    }
});
    }
}
