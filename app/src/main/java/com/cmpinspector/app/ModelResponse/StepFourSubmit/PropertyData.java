package com.cmpinspector.app.ModelResponse.StepFourSubmit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyData {

    @SerializedName("propertyDetailsData")
    @Expose
    private PropertyDetailsData propertyDetailsData;

    public PropertyData(PropertyDetailsData propertyDetailsData) {
        this.propertyDetailsData = propertyDetailsData;
    }


    public PropertyDetailsData getPropertyDetailsData() {
        return propertyDetailsData;
    }

    public void setPropertyDetailsData(PropertyDetailsData propertyDetailsData) {
        this.propertyDetailsData = propertyDetailsData;
    }
}
