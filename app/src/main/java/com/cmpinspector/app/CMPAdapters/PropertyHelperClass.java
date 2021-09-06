package com.cmpinspector.app.CMPAdapters;

public class PropertyHelperClass {
    int image,image1;
    String title, subtitle, loc, address, inspection_time;

    public PropertyHelperClass(int image) {
        this.image = image;
        this.image1= image1;
        this.title = title;
        this.subtitle = subtitle;
        this.loc = loc;
        this.address = address;
        this.inspection_time = inspection_time;

    }

    public int getImage() {
        return image;
    }
    public int getImage1(){
        return image1;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getLoc() {
        return loc;
    }
    public String getAddress(){
        return address;
    }
    public  String getInspection_time(){
        return inspection_time;
    }
}
