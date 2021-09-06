package com.cmpinspector.app.ModelResponse.StepFourSubmit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("propertyData")
    @Expose
    private PropertyData propertyData;

    public Result(PropertyData propertyData) {
        this.propertyData = propertyData;
    }

    public PropertyData getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(PropertyData propertyData) {
        this.propertyData = propertyData;
    }
}
