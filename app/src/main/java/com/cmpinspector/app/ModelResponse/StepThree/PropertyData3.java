package com.cmpinspector.app.ModelResponse.StepThree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyData3 {

    @SerializedName("propertyDetailsData")
    @Expose
    private PropertyDetailsData propertyDetailsData;

    public PropertyData3(PropertyDetailsData propertyDetailsData) {
        this.propertyDetailsData = propertyDetailsData;
    }

    public PropertyDetailsData getPropertyDetailsData() {
        return propertyDetailsData;
    }

    public void setPropertyDetailsData(PropertyDetailsData propertyDetailsData) {
        this.propertyDetailsData = propertyDetailsData;
    }
}
