package com.cmpinspector.app.ModelResponse.StepOneAndTwo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AreaMeasurement {

    @SerializedName("measurment")
    @Expose
    private String measurment;

    public AreaMeasurement(String measurment) {
        this.measurment = measurment;
    }

    public String getMeasurment() {
        return measurment;
    }

    public void setMeasurment(String measurment) {
        this.measurment = measurment;
    }
}
