package com.cmpinspector.app.ModelResponse;

import com.cmpinspector.app.ModelResponse.CompleteInspectionData.ComInspectedpropertyDatum;
import com.cmpinspector.app.ModelResponse.CompleteInspectionData.PendInspectedpropertyDatum;
import com.cmpinspector.app.ModelResponse.StepThree.PropertyData3;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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





    @SerializedName("propertyData")
    @Expose
    private PropertyData3 propertyData;

    public Result(PropertyData3 propertyData) {
        this.propertyData = propertyData;
    }

    public PropertyData3 getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(PropertyData3 propertyData) {
        this.propertyData = propertyData;
    }


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
