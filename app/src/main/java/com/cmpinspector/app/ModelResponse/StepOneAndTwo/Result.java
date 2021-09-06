package com.cmpinspector.app.ModelResponse.StepOneAndTwo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("kindOfProperty")
    @Expose
    private List<KindOfProperty> kindOfProperty = null;
    @SerializedName("locationData")
    @Expose
    private List<LocationDatum> locationData = null;
    @SerializedName("propertyHolder")
    @Expose
    private List<PropertyHolder> propertyHolder = null;
    @SerializedName("areaMeasurement")
    @Expose
    private List<AreaMeasurement> areaMeasurement = null;
    @SerializedName("propertyData")
    @Expose
    private PropertyData propertyData;

    public Result(List<KindOfProperty> kindOfProperty, List<LocationDatum> locationData, List<PropertyHolder> propertyHolder, List<AreaMeasurement> areaMeasurement, PropertyData propertyData) {
        this.kindOfProperty = kindOfProperty;
        this.locationData = locationData;
        this.propertyHolder = propertyHolder;
        this.areaMeasurement = areaMeasurement;
        this.propertyData = propertyData;
    }

    public List<KindOfProperty> getKindOfProperty() {
        return kindOfProperty;
    }

    public void setKindOfProperty(List<KindOfProperty> kindOfProperty) {
        this.kindOfProperty = kindOfProperty;
    }

    public List<LocationDatum> getLocationData() {
        return locationData;
    }

    public void setLocationData(List<LocationDatum> locationData) {
        this.locationData = locationData;
    }

    public List<PropertyHolder> getPropertyHolder() {
        return propertyHolder;
    }

    public void setPropertyHolder(List<PropertyHolder> propertyHolder) {
        this.propertyHolder = propertyHolder;
    }

    public List<AreaMeasurement> getAreaMeasurement() {
        return areaMeasurement;
    }

    public void setAreaMeasurement(List<AreaMeasurement> areaMeasurement) {
        this.areaMeasurement = areaMeasurement;
    }

    public PropertyData getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(PropertyData propertyData) {
        this.propertyData = propertyData;
    }
}
