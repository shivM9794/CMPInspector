package com.cmpinspector.app.ModelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PropertyData {

    @SerializedName("images")
    @Expose

    private ArrayList<Images> images;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("total_area")
    @Expose
    private String total_area;
    @SerializedName("property_holder_id")
    @Expose
    private String property_holder_id;
    @SerializedName("kind_of_property_name")
    @Expose
    private String kind_of_property_name;
    @SerializedName("inspectionTime")
    @Expose
    private String inspectionTime;
    @SerializedName("property_holder_name")
    @Expose
    private String property_holder_name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("creation_date")
    @Expose
    private String creation_date;
    @SerializedName("area_type")
    @Expose
    private String area_type;
    @SerializedName("property_id")
    @Expose
    private String property_id;
    @SerializedName("location_id")
    @Expose
    private String location_id;
    @SerializedName("kind_of_property_id")
    @Expose
    private String kind_of_property_id;
    @SerializedName("complete_property_step")
    @Expose
    private String complete_property_step;
    @SerializedName("property_type_id")
    @Expose
    private String property_type_id;
    @SerializedName("location_name")
    @Expose
    private String location_name;
    @SerializedName("no_of_bed")
    @Expose
    private String no_of_bed;
    @SerializedName("inspectionDate")
    @Expose
    private String inspectionDate;
    @SerializedName("seller_id")
    @Expose
    private String seller_id;
    @SerializedName("current_location")
    @Expose
    private String current_location;
    @SerializedName("property_type_name")
    @Expose
    private String property_type_name;

    public PropertyData(ArrayList<Images> images, String address, String total_area, String property_holder_id, String kind_of_property_name, String inspectionTime, String property_holder_name, String description, String creation_date, String area_type, String property_id, String location_id, String kind_of_property_id, String complete_property_step, String property_type_id, String location_name, String no_of_bed, String inspectionDate, String seller_id, String current_location, String property_type_name) {
        this.images = images;
        this.address = address;
        this.total_area = total_area;
        this.property_holder_id = property_holder_id;
        this.kind_of_property_name = kind_of_property_name;
        this.inspectionTime = inspectionTime;
        this.property_holder_name = property_holder_name;
        this.description = description;
        this.creation_date = creation_date;
        this.area_type = area_type;
        this.property_id = property_id;
        this.location_id = location_id;
        this.kind_of_property_id = kind_of_property_id;
        this.complete_property_step = complete_property_step;
        this.property_type_id = property_type_id;
        this.location_name = location_name;
        this.no_of_bed = no_of_bed;
        this.inspectionDate = inspectionDate;
        this.seller_id = seller_id;
        this.current_location = current_location;
        this.property_type_name = property_type_name;
    }

    public ArrayList<Images> getImages() {
        return images;
    }

    public void setImages(ArrayList<Images> images) {
        this.images = images;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal_area() {
        return total_area;
    }

    public void setTotal_area(String total_area) {
        this.total_area = total_area;
    }

    public String getProperty_holder_id() {
        return property_holder_id;
    }

    public void setProperty_holder_id(String property_holder_id) {
        this.property_holder_id = property_holder_id;
    }

    public String getKind_of_property_name() {
        return kind_of_property_name;
    }

    public void setKind_of_property_name(String kind_of_property_name) {
        this.kind_of_property_name = kind_of_property_name;
    }

    public String getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(String inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public String getProperty_holder_name() {
        return property_holder_name;
    }

    public void setProperty_holder_name(String property_holder_name) {
        this.property_holder_name = property_holder_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getArea_type() {
        return area_type;
    }

    public void setArea_type(String area_type) {
        this.area_type = area_type;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getKind_of_property_id() {
        return kind_of_property_id;
    }

    public void setKind_of_property_id(String kind_of_property_id) {
        this.kind_of_property_id = kind_of_property_id;
    }

    public String getComplete_property_step() {
        return complete_property_step;
    }

    public void setComplete_property_step(String complete_property_step) {
        this.complete_property_step = complete_property_step;
    }

    public String getProperty_type_id() {
        return property_type_id;
    }

    public void setProperty_type_id(String property_type_id) {
        this.property_type_id = property_type_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getNo_of_bed() {
        return no_of_bed;
    }

    public void setNo_of_bed(String no_of_bed) {
        this.no_of_bed = no_of_bed;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(String current_location) {
        this.current_location = current_location;
    }

    public String getProperty_type_name() {
        return property_type_name;
    }

    public void setProperty_type_name(String property_type_name) {
        this.property_type_name = property_type_name;
    }
}
