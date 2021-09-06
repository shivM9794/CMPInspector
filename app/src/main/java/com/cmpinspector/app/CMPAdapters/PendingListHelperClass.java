package com.cmpinspector.app.CMPAdapters;

public class PendingListHelperClass {
    int image,image1;
    String title, subtitle,subtitle1, loc, inspection_date, inspection_time;



    public PendingListHelperClass(int image) {
        this.image = image;
        this.image1 = image1;
        this.title = title;
        this.subtitle = subtitle;
        this.subtitle1 = subtitle1;
        this.loc = loc;
        this.inspection_date = inspection_date;
        this.inspection_time = inspection_time;
    }

    public int getImage() {
        return image;
    }

    public int getImage1() {
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

    public String getInspection_date() {
        return inspection_date;
    }

    public String getInspection_time() {
        return inspection_time;
    }

    public String getSubtitle1() {
        return subtitle1;
    }

}
