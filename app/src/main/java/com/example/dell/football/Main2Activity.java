package com.example.dell.football;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.google.firebase.firestore.FirebaseFirestore.getInstance;

public class Main2Activity extends Fragment {
    private ImageButton youtube,instagram,facebook;
    private ImageView n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,fif18,fif14,fif10,fif06,fif02,fif98;
private ViewPager ararat737;
    private ArrayList<Glavni> arrayListg;
    private ProgressDialog progressDialog;
private TextView fif2018text;
Handler handler;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main2,container,false);
youtube=view.findViewById(R.id.youtube);
fif2018text=view.findViewById(R.id.fif2018text);
        n1=view.findViewById(R.id.n1);
        n2=view.findViewById(R.id.n2);
        n3=view.findViewById(R.id.n3);
        n4=view.findViewById(R.id.n4);
        n5=view.findViewById(R.id.n5);
        n6=view.findViewById(R.id.n6);
        n7=view.findViewById(R.id.n7);
        n8=view.findViewById(R.id.n8);
        ararat737=view.findViewById(R.id.ararat737);
        fif14=view.findViewById(R.id.fif14);
        fif18=view.findViewById(R.id.fif18);
        fif02=view.findViewById(R.id.fif02);
        fif06=view.findViewById(R.id.fif06);
        fif98=view.findViewById(R.id.fif98);
        fif10=view.findViewById(R.id.fif10);
        n9=view.findViewById(R.id.n9);
        n10=view.findViewById(R.id.n10);
ararat737.setAdapter(new ARARATADAPTER(getChildFragmentManager()));
         progressDialog=new ProgressDialog(getContext());
progressDialog.setMessage("Wi-Fi...");
progressDialog.show();


                try {    Firebas1("n1",n1);
                   Firebas1("n2",n2);
                    Firebas1("n3",n3);
                    Firebas1("n4",n4);
                    Firebas1("n5",n5);
                    Firebas1("n6",n6);
                    Firebas1("n7",n7);
                    Firebas1("n8",n8);
                    Firebas1("n9",n9);
                    Firebas1("n10",n10);
                    Firebas1("fif18",fif18);
                    Firebas1("fif14",fif14);
                    Firebas1("fif10",fif10);
                    Firebas1("fif02",fif02);
                    Firebas1("fif06",fif06);
                    Firebas1("fif98",fif98);
                    Firebas2("fif2018text",fif2018text); } catch (IOException e) {
                    e.printStackTrace();
                }




instagram=view.findViewById(R.id.instagram);
facebook=view.findViewById(R.id.facebook);
        arrayListg=new ArrayList<>();



youtube.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(),Main6Activity.class);
        intent.putExtra("kayq","https://www.youtube.com/FIFATV");
        startActivity(intent);
    }
});facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Main6Activity.class);
                intent.putExtra("kayq","https://www.facebook.com/Football-1590526550993501/");
                startActivity(intent);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Main6Activity.class);
                intent.putExtra("kayq","https://www.instagram.com/alarm.football/?hl=ru");
                startActivity(intent);

            }
        });


        return view;
    }
   public void  Firebas1(String child, final ImageView a1)throws IOException{



        DatabaseReference condition=databaseReference.child(child);
        condition.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String  nn1 =dataSnapshot.getValue(String.class);

                  Picasso.with(getContext()).load(nn1).into(a1);


              progressDialog.dismiss();

            }  @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });

    }   public void  Firebas2(String child, final TextView b)throws IOException{

        DatabaseReference condition=databaseReference.child(child);
        condition.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String  nn1 =dataSnapshot.getValue(String.class);
             b.setText(nn1);

            }  @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });}


}
    