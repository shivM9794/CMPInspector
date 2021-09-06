package com.cmpinspector.app.ModelResponse.StepOneAndTwo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationDatum {

    @SerializedName("location_name")
    @Expose
    private String locationName;
    @SerializedName("location_slug")
    @Expose
    private String locationSlug;
    @SerializedName("location_web_image")
    @Expose
    private String locationWebImage;
    @SerializedName("location_web_image_alt")
    @Expose
    private String locationWebImageAlt;
    @SerializedName("location_app_image")
    @Expose
    private String locationAppImage;
    @SerializedName("location_app_image_alt")
    @Expose
    private String locationAppImageAlt;
    @SerializedName("location_id")
    @Expose
    private Long locationId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private Id__2 id;

    public LocationDatum(String locationName, String locationSlug, String locationWebImage, String locationWebImageAlt, String locationAppImage, String locationAppImageAlt, Long locationId, String status, Id__2 id) {
        this.locationName = locationName;
        this.locationSlug = locationSlug;
        this.locationWebImage = locationWebImage;
        this.locationWebImageAlt = locationWebImageAlt;
        this.locationAppImage = locationAppImage;
        this.locationAppImageAlt = locationAppImageAlt;
        this.locationId = locationId;
        this.status = status;
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationSlug() {
        return locationSlug;
    }

    public void setLocationSlug(String locationSlug) {
        this.locationSlug = locationSlug;
    }

    public String getLocationWebImage() {
        return locationWebImage;
    }

    public void setLocationWebImage(String locationWebImage) {
        this.locationWebImage = locationWebImage;
    }

    public String getLocationWebImageAlt() {
        return locationWebImageAlt;
    }

    public void setLocationWebImageAlt(String locationWebImageAlt) {
        this.locationWebImageAlt = locationWebImageAlt;
    }

    public String getLocationAppImage() {
        return locationAppImage;
    }

    public void setLocationAppImage(String locationAppImage) {
        this.locationAppImage = locationAppImage;
    }

    public String getLocationAppImageAlt() {
        return locationAppImageAlt;
    }

    public void setLocationAppImageAlt(String locationAppImageAlt) {
        this.locationAppImageAlt = locationAppImageAlt;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Id__2 getId() {
        return id;
    }

    public void setId(Id__2 id) {
        this.id = id;
    }
}
