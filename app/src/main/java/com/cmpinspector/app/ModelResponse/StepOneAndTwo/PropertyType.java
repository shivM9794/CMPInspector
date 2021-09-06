package com.cmpinspector.app.ModelResponse.StepOneAndTwo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyType {

    @SerializedName("sub_category_name")
    @Expose
    private String subCategoryName;
    @SerializedName("sub_category_slug")
    @Expose
    private String subCategorySlug;
    @SerializedName("sub_category_web_image")
    @Expose
    private String subCategoryWebImage;
    @SerializedName("sub_category_web_image_alt")
    @Expose
    private String subCategoryWebImageAlt;
    @SerializedName("sub_category_app_image")
    @Expose
    private String subCategoryAppImage;
    @SerializedName("sub_category_app_image_alt")
    @Expose
    private String subCategoryAppImageAlt;
    @SerializedName("sub_category_id")
    @Expose
    private Long subCategoryId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private Id__1 id;

    public PropertyType(String subCategoryName, String subCategorySlug, String subCategoryWebImage, String subCategoryWebImageAlt, String subCategoryAppImage, String subCategoryAppImageAlt, Long subCategoryId, String status, Id__1 id) {
        this.subCategoryName = subCategoryName;
        this.subCategorySlug = subCategorySlug;
        this.subCategoryWebImage = subCategoryWebImage;
        this.subCategoryWebImageAlt = subCategoryWebImageAlt;
        this.subCategoryAppImage = subCategoryAppImage;
        this.subCategoryAppImageAlt = subCategoryAppImageAlt;
        this.subCategoryId = subCategoryId;
        this.status = status;
        this.id = id;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategorySlug() {
        return subCategorySlug;
    }

    public void setSubCategorySlug(String subCategorySlug) {
        this.subCategorySlug = subCategorySlug;
    }

    public String getSubCategoryWebImage() {
        return subCategoryWebImage;
    }

    public void setSubCategoryWebImage(String subCategoryWebImage) {
        this.subCategoryWebImage = subCategoryWebImage;
    }

    public String getSubCategoryWebImageAlt() {
        return subCategoryWebImageAlt;
    }

    public void setSubCategoryWebImageAlt(String subCategoryWebImageAlt) {
        this.subCategoryWebImageAlt = subCategoryWebImageAlt;
    }

    public String getSubCategoryAppImage() {
        return subCategoryAppImage;
    }

    public void setSubCategoryAppImage(String subCategoryAppImage) {
        this.subCategoryAppImage = subCategoryAppImage;
    }

    public String getSubCategoryAppImageAlt() {
        return subCategoryAppImageAlt;
    }

    public void setSubCategoryAppImageAlt(String subCategoryAppImageAlt) {
        this.subCategoryAppImageAlt = subCategoryAppImageAlt;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
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
