package com.cmpinspector.app.ModelResponse.StepThreeAddPropertyImages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("propertyData")
    @Expose
    private PropertyData propertyData;
    @SerializedName("propertyImage")
    @Expose
    private List<PropertyImage> propertyImage = null;

    public Result(PropertyData propertyData, List<PropertyImage> propertyImage) {
        this.propertyData = propertyData;
        this.propertyImage = propertyImage;
    }

    public PropertyData getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(PropertyData propertyData) {
        this.propertyData = propertyData;
    }

    public List<PropertyImage> getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(List<PropertyImage> propertyImage) {
        this.propertyImage = propertyImage;
    }
}
