package com.example.tm;

public class dataModel {

    String district;
    String place;
    String descr;
    private byte[] image;
    private int id;
    public dataModel( String district, String place, String descr, byte[] image, int id) {
        this.district=district;
        this.place=place;
        this.descr=descr;
        this.image = image;
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getPlace() {
        return place;
    }


    public String getDescr() {
        return descr;
    }


    public String getDistrict(){return district;}
    public byte[] getImage() {
        return image;
    }
    public void setPlace(String name) {
        this.place = place;
    }
    public void setDescr(String descr) {
        this.descr =descr ;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


    public void setImage(byte[] image) {
        this.image = image;
    }

}
