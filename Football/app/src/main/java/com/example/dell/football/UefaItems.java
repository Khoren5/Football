package com.example.dell.football;



public class UefaItems {
    private String amis,komand1,komand2,pul1,time1;
    public UefaItems(){

    }
    public UefaItems(String amis,String komand1,String komand2,String pul1,String time1){
        this.komand1=komand1;
        this.komand2=komand2;
        this.time1=time1;
        this.pul1=pul1;
        this.amis=amis;
    }

    public String getKomand1() {
        return komand1;
    }

    public String getAmis() {
        return amis;
    }

    public String getKomand2() {
        return komand2;
    }

    public String getPul1() {
        return pul1;
    }

    public String getTime1() {
        return time1;
    }

    public void setKomand1(String komand1) {
        this.komand1 = komand1;
    }

    public void setAmis(String amis) {
        this.amis = amis;
    }

    public void setKomand2(String komand2) {
        this.komand2 = komand2;
    }

    public void setPul1(String pul1) {
        this.pul1 = pul1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }
}
