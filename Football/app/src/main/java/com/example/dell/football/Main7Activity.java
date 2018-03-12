package com.example.dell.football;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


public class Main7Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
private DrawerLayout drawer;
private NavigationView navigationView;
private int a=0;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    {

        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:
                        transaction.replace(R.id.layout, new Main2Activity()).commit();a++;
                        return true;
                    case R.id.alarm:
                        transaction.replace(R.id.layout, new Main5Activity()).commit();a++;
                        return true;
                    case R.id.video:
                        transaction.replace(R.id.layout, new Main3Activity()).commit();a++;
                        return true;
                    case R.id.hashiv:
                        transaction.replace(R.id.layout, new Main8Activity()).commit();a++;

                        return true;
default:
    return false;
            }
            }
            };}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        toolbar=findViewById(R.id.toolbar);
        if (a==0){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.layout, new Main2Activity()).commit();}
        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigationView=findViewById(R.id.nav_view);
        drawer=findViewById(R.id.drawer);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
    navigationView.setNavigationItemSelectedListener(this);}



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item1) {
        switch (item1.getItemId()){
            case R.id.uefach:
                Intent intent=new Intent(Main7Activity.this,Main9Activity.class);
                startActivity(intent);
        }
        return false;
    }
}
