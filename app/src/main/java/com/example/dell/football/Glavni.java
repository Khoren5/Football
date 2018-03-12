package com.example.dell.football;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by DELL on 19.02.2018.
 */

public class Glavni {
    private String tim1;
    private String tim2;
    private String jamanak;
    private String amsativ;
    private String pul;
    private String nkar1;
    private String nkar2;
    private String tm;
    private String am;
    private String om;
    private String jm;
    private String rm;
    private String g;



    public Glavni(){}

    public String getTim1() {
        return tim1;
    }

    public String getTim2() {
        return tim2;
    }

    public String getJamanak() {
        return jamanak;
    }

    public String getAmsativ() {
        return amsativ;
    }

    public String getPul() {
        return pul;
    }

    public String getNkar1() {
        return nkar1;
    }

    public String getNkar2() {
        return nkar2;
    }

    public String getTm() {
        return tm;
    }

    public String getAm() {
        return am;
    }
    public String getG() {
        return g;
    }

    public String getOm() {
        return om;
    }

    public String getJm() {
        return jm;
    }

    public String getRm() {
        return rm;
    }


    public Glavni(String tim1, String tim2, String jamanak, String amsativ, String pul, String nkar1,
                  String nkar2, String tm, String am, String om, String jm, String rm,String g) {
        this.tim1 = tim1;
        this.tim2 = tim2;
        this.jamanak = jamanak;
        this.amsativ = amsativ;
        this.pul = pul;
        this.nkar1 = nkar1;
        this.nkar2 = nkar2;
        this.tm = tm;
        this.g = g;
        this.am = am;
        this.om = om;
        this.jm = jm;
        this.rm = rm;
    }




}
