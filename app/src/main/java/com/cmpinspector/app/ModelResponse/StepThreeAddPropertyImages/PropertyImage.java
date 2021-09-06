package com.cmpinspector.app.ModelResponse.StepThreeAddPropertyImages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyImage {

    @SerializedName("image_id")
    @Expose
    private Long imageId;
    @SerializedName("property_image")
    @Expose
    private String propertyImage;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private Id__1 id;

    public PropertyImage(Long imageId, String propertyImage, String status, Id__1 id) {
        this.imageId = imageId;
        this.propertyImage = propertyImage;
        this.status = status;
        this.id = id;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(String propertyImage) {
        this.propertyImage = propertyImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Id__1 getId() {
        return id;
    }

    public void setId(Id__1 id) {
        this.id = id;
    }
}
