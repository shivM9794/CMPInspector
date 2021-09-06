package com.cmpinspector.app.ModelResponse.StepOneAndTwo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyHolder {

    @SerializedName("property_holder_name")
    @Expose
    private String propertyHolderName;
    @SerializedName("property_holder_slug")
    @Expose
    private String propertyHolderSlug;
    @SerializedName("property_holder_web_image_alt")
    @Expose
    private String propertyHolderWebImageAlt;
    @SerializedName("property_holder_app_image_alt")
    @Expose
    private String propertyHolderAppImageAlt;
    @SerializedName("property_holder_id")
    @Expose
    private Long propertyHolderId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private Id__3 id;

    public PropertyHolder(String propertyHolderName, String propertyHolderSlug, String propertyHolderWebImageAlt, String propertyHolderAppImageAlt, Long propertyHolderId, String status, Id__3 id) {
        this.propertyHolderName = propertyHolderName;
        this.propertyHolderSlug = propertyHolderSlug;
        this.propertyHolderWebImageAlt = propertyHolderWebImageAlt;
        this.propertyHolderAppImageAlt = propertyHolderAppImageAlt;
        this.propertyHolderId = propertyHolderId;
        this.status = status;
        this.id = id;
    }

    public String getPropertyHolderName() {
        return propertyHolderName;
    }

    public void setPropertyHolderName(String propertyHolderName) {
        this.propertyHolderName = propertyHolderName;
    }

    public String getPropertyHolderSlug() {
        return propertyHolderSlug;
    }

    public void setPropertyHolderSlug(String propertyHolderSlug) {
        this.propertyHolderSlug = propertyHolderSlug;
    }

    public String getPropertyHolderWebImageAlt() {
        return propertyHolderWebImageAlt;
    }

    public void setPropertyHolderWebImageAlt(String propertyHolderWebImageAlt) {
        this.propertyHolderWebImageAlt = propertyHolderWebImageAlt;
    }

    public String getPropertyHolderAppImageAlt() {
        return propertyHolderAppImageAlt;
    }

    public void setPropertyHolderAppImageAlt(String propertyHolderAppImageAlt) {
        this.propertyHolderAppImageAlt = propertyHolderAppImageAlt;
    }

    public Long getPropertyHolderId() {
        return propertyHolderId;
    }

    public void setPropertyHolderId(Long propertyHolderId) {
        this.propertyHolderId = propertyHolderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Id__3 getId() {
        return id;
    }

    public void setId(Id__3 id) {
        this.id = id;
    }
}
