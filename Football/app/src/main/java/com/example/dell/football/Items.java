package com.example.dell.football;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by DELL on 01.02.2018.
 */

public class Items extends Drawable {
    private String arajin,erkrord,jamanak;
    private int nkar11,nkar22;
    Items(String arajin,String jamanak,String erkrord,int nkar11,int nkar22){
        this.arajin=arajin;
        this.nkar11=nkar11;
        this.nkar22=nkar22;
        this.erkrord=erkrord;
        this.jamanak=jamanak;
    }

    public String getArajin() {
        return arajin;
    }

    public String getErkrord() {
        return erkrord;
    }

    public String getJamanak() {
        return jamanak;
    }

    public int getNkar22() {
        return nkar22;
    }

    public int getNkar11() {
        return nkar11;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {

    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
