package com.example.dell.football;

/**
 * Created by DELL on 11.02.2018.
 */

public class Users {
    String hashiv,tim1,tim2;
    public Users(){

    }
    public Users(String hashiv,String tim1,String tim2){
        this.tim1=tim1;
        this.tim2=tim2;
        this.hashiv=hashiv;
    }

    public String getHashiv() {
        return hashiv;
    }

    public String getTim1() {
        return tim1;
    }

    public String getTim2() {
        return tim2;
    }

    public void setHashiv(String hashiv) {
        this.hashiv = hashiv;
    }

    public void setTim1(String tim1) {
        this.tim1 = tim1;
    }

    public void setTim2(String tim2) {
        this.tim2 = tim2;
    }
}
