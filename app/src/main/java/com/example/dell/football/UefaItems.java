package com.example.dell.football;



public class UefaItems {
    private String amis;
    private String komand1;
    private String komand2;
    private String pul1;
    private String time1;
    private String nkar1;
    private String nkar2;
    private String ut;
    private String gu;
    private String ua;
    private String uo;
    private String uj;
    private String ur;

    public UefaItems(){

    }



    public UefaItems(String amis, String komand1, String komand2,String gu, String pul1, String time1, String nkar1, String nkar2, String ut,
                     String ua, String uo,

                     String uj,
                     String ur){
        this.komand1=komand1;
        this.komand2=komand2;
        this.gu=gu;
        this.time1=time1;
        this.pul1=pul1;
        this.amis=amis;
        this.nkar1=nkar1;
        this.nkar2=nkar2;
        this.ut=ut;
        this.ua=ua;
        this.uo=uo;
        this.uj=uj;
        this.ur=ur;
    }

    public String getKomand1() {
        return komand1;
    }
    public String getGu() {
        return gu;
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

    public String getNkar1() {
        return nkar1;
    }

    public String getNkar2() {
        return nkar2;
    }
    public String getUt() {
        return ut;
    }

    public String getUa() {
        return ua;
    }

    public String getUo() {
        return uo;
    }

    public String getUj() {
        return uj;
    }

    public String getUr() {
        return ur;
    }

}
