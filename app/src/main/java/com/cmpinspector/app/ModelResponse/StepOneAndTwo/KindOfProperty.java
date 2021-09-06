package com.cmpinspector.app.ModelResponse.StepOneAndTwo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KindOfProperty {

    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_slug")
    @Expose
    private String categorySlug;
    @SerializedName("category_web_image")
    @Expose
    private String categoryWebImage;
    @SerializedName("category_web_image_alt")
    @Expose
    private String categoryWebImageAlt;
    @SerializedName("category_app_image")
    @Expose
    private String categoryAppImage;
    @SerializedName("category_app_image_alt")
    @Expose
    private String categoryAppImageAlt;
    @SerializedName("category_id")
    @Expose
    private Long categoryId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private Id id;
    @SerializedName("propertyType")
    @Expose
    private List<PropertyType> propertyType = null;

    public KindOfProperty(String categoryName, String categorySlug, String categoryWebImage, String categoryWebImageAlt, String categoryAppImage, String categoryAppImageAlt, Long categoryId, String status, Id id, List<PropertyType> propertyType) {
        this.categoryName = categoryName;
        this.categorySlug = categorySlug;
        this.categoryWebImage = categoryWebImage;
        this.categoryWebImageAlt = categoryWebImageAlt;
        this.categoryAppImage = categoryAppImage;
        this.categoryAppImageAlt = categoryAppImageAlt;
        this.categoryId = categoryId;
        this.status = status;
        this.id = id;
        this.propertyType = propertyType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    public String getCategoryWebImage() {
        return categoryWebImage;
    }

    public void setCategoryWebImage(String categoryWebImage) {
        this.categoryWebImage = categoryWebImage;
    }

    public String getCategoryWebImageAlt() {
        return categoryWebImageAlt;
    }

    public void setCategoryWebImageAlt(String categoryWebImageAlt) {
        this.categoryWebImageAlt = categoryWebImageAlt;
    }

    public String getCategoryAppImage() {
        return categoryAppImage;
    }

    public void setCategoryAppImage(String categoryAppImage) {
        this.categoryAppImage = categoryAppImage;
    }

    public String getCategoryAppImageAlt() {
        return categoryAppImageAlt;
    }

    public void setCategoryAppImageAlt(String categoryAppImageAlt) {
        this.categoryAppImageAlt = categoryAppImageAlt;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public List<PropertyType> getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(List<PropertyType> propertyType) {
        this.propertyType = propertyType;
    }
}
