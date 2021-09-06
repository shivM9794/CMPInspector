package com.cmpinspector.app.ModelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("image_id")
    @Expose
    String image_id;

    @SerializedName("property_id")
    @Expose
    String property_id;

    @SerializedName("property_image")
    @Expose
    String property_image;

    @SerializedName("creation_date")
    @Expose
    String creation_date;

    @SerializedName("_id")
    @Expose
     _id _id;

    public Images(String image_id, String property_id, String property_image, String creation_date, com.cmpinspector.app.ModelResponse._id _id) {
        this.image_id = image_id;
        this.property_id = property_id;
        this.property_image = property_image;
        this.creation_date = creation_date;
        this._id = _id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public String getProperty_image() {
        return property_image;
    }

    public void setProperty_image(String property_image) {
        this.property_image = property_image;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public com.cmpinspector.app.ModelResponse._id get_id() {
        return _id;
    }

    public void set_id(com.cmpinspector.app.ModelResponse._id _id) {
        this._id = _id;
    }
}
