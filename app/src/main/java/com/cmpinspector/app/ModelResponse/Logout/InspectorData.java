package com.cmpinspector.app.ModelResponse.Logout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InspectorData {

    @SerializedName("inspector_id")
    @Expose
    private Long inspectorId;

    public InspectorData(Long inspectorId) {
        this.inspectorId = inspectorId;
    }

    public Long getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(Long inspectorId) {
        this.inspectorId = inspectorId;
    }
}
