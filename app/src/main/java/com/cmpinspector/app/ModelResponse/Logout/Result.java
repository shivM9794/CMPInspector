package com.cmpinspector.app.ModelResponse.Logout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("inspectorData")
    @Expose
    private InspectorData inspectorData;

    public Result(InspectorData inspectorData) {
        this.inspectorData = inspectorData;
    }

    public InspectorData getInspectorData() {
        return inspectorData;
    }

    public void setInspectorData(InspectorData inspectorData) {
        this.inspectorData = inspectorData;
    }
}
