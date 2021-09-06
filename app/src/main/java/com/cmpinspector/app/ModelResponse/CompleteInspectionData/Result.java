package com.cmpinspector.app.ModelResponse.CompleteInspectionData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("comInspectedpropertyData")
    @Expose
    private List<ComInspectedpropertyDatum> comInspectedpropertyData = null;
    @SerializedName("pendInspectedpropertyData")
    @Expose
    private List<PendInspectedpropertyDatum> pendInspectedpropertyData = null;

    public Result(List<ComInspectedpropertyDatum> comInspectedpropertyData, List<PendInspectedpropertyDatum> pendInspectedpropertyData) {
        this.comInspectedpropertyData = comInspectedpropertyData;
        this.pendInspectedpropertyData = pendInspectedpropertyData;
    }

    public List<ComInspectedpropertyDatum> getComInspectedpropertyData() {
        return comInspectedpropertyData;
    }

    public void setComInspectedpropertyData(List<ComInspectedpropertyDatum> comInspectedpropertyData) {
        this.comInspectedpropertyData = comInspectedpropertyData;
    }

    public List<PendInspectedpropertyDatum> getPendInspectedpropertyData() {
        return pendInspectedpropertyData;
    }

    public void setPendInspectedpropertyData(List<PendInspectedpropertyDatum> pendInspectedpropertyData) {
        this.pendInspectedpropertyData = pendInspectedpropertyData;
    }
}
