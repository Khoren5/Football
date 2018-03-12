package com.example.dell.football;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by DELL on 01.02.2018.
 */

public class Items  {
    private String arajin,erkrord,jamanak,amisf,pulf;
    private String  nkar11;
    private String nkar22;
    private String t;
    private String a;
    private String o;
    private String ca;
    private String j;
    private String r;
    public Items(){}


    Items(String arajin,String jamanak,String erkrord,String nkar11,String nkar22,String pulf,
          String amisf,String t,String a,String j,String r,String o,String ca){
        this.arajin=arajin;
        this.nkar11=nkar11;
        this.t=t;
        this.a=a;
        this.o=o;
        this.ca=ca;
        this.j=j;
        this.r=r;
        this.amisf=amisf;
        this.pulf=pulf;
        this.nkar22=nkar22;
        this.erkrord=erkrord;
        this.jamanak=jamanak;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getArajin() {
        return arajin;
    }

    public String getAmisf() {
        return amisf;
    }

    public String getPulf() {
        return pulf;
    }

    public String getErkrord() {
        return erkrord;
    }

    public String getJamanak() {
        return jamanak;
    }

    public String getNkar22() {
        return nkar22;
    }

    public String getNkar11() {
        return nkar11;
    }

    public String getA() {
        return a;
    }

    public String getJ() {
        return j;
    }

    public String getO() {
        return o;
    }

    public String getR() {
        return r;
    }

    public String getT() {
        return t;
    }

}
