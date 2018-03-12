package com.example.dell.football;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
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
                    case R.id.video:
                        transaction.replace(R.id.layout, new Main3Activity()).commit();a++;
                        return true;
                    case R.id.league:
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

        if (ActivityCompat.checkSelfPermission(Main7Activity.this, Manifest.permission.VIBRATE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Main7Activity.this,new String[]{Manifest.permission.VIBRATE},1);
        }
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
                return true;
            case R.id.fwc:Intent intent1=new Intent(Main7Activity.this,Main5Activity.class);
            startActivity(intent1);
        return  true;
            case R.id.fifa:
                Intent intent2=new Intent(Main7Activity.this,Main6Activity.class);
                intent2.putExtra("kayq","http://www.fifa.com/fifa-world-ranking/index.html");
                startActivity(intent2);
                return true;
            case R.id.uefamenu:
                Intent intent4=new Intent(Main7Activity.this,Main6Activity.class);
                intent4.putExtra("kayq","http://www.uefa.com/uefachampionsleague/season=2018/statistics/index.html#/");
                startActivity(intent4);
                return true;
            case R.id.aylxax:Intent intent3=new Intent(Main7Activity.this,AllMacht.class);
            startActivity(intent3);return true;
            case R.id.uefaeuro:
                Intent intent5=new Intent(Main7Activity.this,Main6Activity.class);
               intent5.putExtra("kayq","http://www.uefa.com/uefaeuropaleague/season=2018/statistics/index.html#/");
                startActivity(intent5);
        }
        return false;
    }
}
