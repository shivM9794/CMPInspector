package com.cmpinspector.app.ModelResponse;

import com.cmpinspector.app.ModelResponse.CompleteInspectionData.ComInspectedpropertyDatum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Dash_Result {

    @SerializedName("approvedInquery")
    @Expose
    String approvedInquery;

    @SerializedName("latestInquery")
    @Expose
    String latestInquery;

    @SerializedName("totalInquery")
    @Expose
    String totalInquery;

    @SerializedName("PropertyData")
    @Expose
    ArrayList<PropertyData> propertyData;

    public Dash_Result(String approvedInquery, String latestInquery, String totalInquery, ArrayList<PropertyData> propertyData) {
        this.approvedInquery = approvedInquery;
        this.latestInquery = latestInquery;
        this.totalInquery = totalInquery;
        this.propertyData = propertyData;
    }

    public String getApprovedInquery() {
        return approvedInquery;
    }

    public void setApprovedInquery(String approvedInquery) {
        this.approvedInquery = approvedInquery;
    }

    public String getLatestInquery() {
        return latestInquery;
    }

    public void setLatestInquery(String latestInquery) {
        this.latestInquery = latestInquery;
    }

    public String getTotalInquery() {
        return totalInquery;
    }

    public void setTotalInquery(String totalInquery) {
        this.totalInquery = totalInquery;
    }

    public ArrayList<PropertyData> getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(ArrayList<PropertyData> propertyData) {
        this.propertyData = propertyData;
    }
}
