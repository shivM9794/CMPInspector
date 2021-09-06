package com.cmpinspector.app.ModelResponse.StepThreeSubmit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyDetailsData {

    @SerializedName("property_id")
    @Expose
    private Long propertyId;
    @SerializedName("seller_id")
    @Expose
    private Long sellerId;
    @SerializedName("property_sequence_id")
    @Expose
    private String propertySequenceId;
    @SerializedName("kind_of_property")
    @Expose
    private Long kindOfProperty;
    @SerializedName("property_type")
    @Expose
    private Long propertyType;
    @SerializedName("complete_property_step")
    @Expose
    private Integer completePropertyStep;
    @SerializedName("property_assigned")
    @Expose
    private String propertyAssigned;
    @SerializedName("basic_details_verify")
    @Expose
    private String basicDetailsVerify;
    @SerializedName("property_details_verify")
    @Expose
    private String propertyDetailsVerify;
    @SerializedName("property_image_verify")
    @Expose
    private String propertyImageVerify;
    @SerializedName("property_verified")
    @Expose
    private String propertyVerified;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("area_type")
    @Expose
    private String areaType;
    @SerializedName("current_location")
    @Expose
    private String currentLocation;
    @SerializedName("eid_or_passport")
    @Expose
    private String eidOrPassport;
    @SerializedName("location")
    @Expose
    private Long location;
    @SerializedName("no_of_bed")
    @Expose
    private Integer noOfBed;
    @SerializedName("property_holder")
    @Expose
    private Long propertyHolder;
    @SerializedName("property_name")
    @Expose
    private String propertyName;
    @SerializedName("title_deed")
    @Expose
    private String titleDeed;
    @SerializedName("total_area")
    @Expose
    private Integer totalArea;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("property_noc")
    @Expose
    private String propertyNoc;
    @SerializedName("kind_of_property_id")
    @Expose
    private Long kindOfPropertyId;
    @SerializedName("kind_of_property_name")
    @Expose
    private String kindOfPropertyName;
    @SerializedName("property_type_id")
    @Expose
    private Long propertyTypeId;
    @SerializedName("property_type_name")
    @Expose
    private String propertyTypeName;
    @SerializedName("location_id")
    @Expose
    private Long locationId;
    @SerializedName("location_name")
    @Expose
    private String locationName;
    @SerializedName("property_holder_id")
    @Expose
    private Long propertyHolderId;
    @SerializedName("property_holder_name")
    @Expose
    private String propertyHolderName;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;

    public PropertyDetailsData(Long propertyId, Long sellerId, String propertySequenceId, Long kindOfProperty, Long propertyType, Integer completePropertyStep, String propertyAssigned, String basicDetailsVerify, String propertyDetailsVerify, String propertyImageVerify, String propertyVerified, Integer creationDate, String address, String areaType, String currentLocation, String eidOrPassport, Long location, Integer noOfBed, Long propertyHolder, String propertyName, String titleDeed, Integer totalArea, String description, String propertyNoc, Long kindOfPropertyId, String kindOfPropertyName, Long propertyTypeId, String propertyTypeName, Long locationId, String locationName, Long propertyHolderId, String propertyHolderName, List<Image> images) {
        this.propertyId = propertyId;
        this.sellerId = sellerId;
        this.propertySequenceId = propertySequenceId;
        this.kindOfProperty = kindOfProperty;
        this.propertyType = propertyType;
        this.completePropertyStep = completePropertyStep;
        this.propertyAssigned = propertyAssigned;
        this.basicDetailsVerify = basicDetailsVerify;
        this.propertyDetailsVerify = propertyDetailsVerify;
        this.propertyImageVerify = propertyImageVerify;
        this.propertyVerified = propertyVerified;
        this.creationDate = creationDate;
        this.address = address;
        this.areaType = areaType;
        this.currentLocation = currentLocation;
        this.eidOrPassport = eidOrPassport;
        this.location = location;
        this.noOfBed = noOfBed;
        this.propertyHolder = propertyHolder;
        this.propertyName = propertyName;
        this.titleDeed = titleDeed;
        this.totalArea = totalArea;
        this.description = description;
        this.propertyNoc = propertyNoc;
        this.kindOfPropertyId = kindOfPropertyId;
        this.kindOfPropertyName = kindOfPropertyName;
        this.propertyTypeId = propertyTypeId;
        this.propertyTypeName = propertyTypeName;
        this.locationId = locationId;
        this.locationName = locationName;
        this.propertyHolderId = propertyHolderId;
        this.propertyHolderName = propertyHolderName;
        this.images = images;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getPropertySequenceId() {
        return propertySequenceId;
    }

    public void setPropertySequenceId(String propertySequenceId) {
        this.propertySequenceId = propertySequenceId;
    }

    public Long getKindOfProperty() {
        return kindOfProperty;
    }

    public void setKindOfProperty(Long kindOfProperty) {
        this.kindOfProperty = kindOfProperty;
    }

    public Long getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Long propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getCompletePropertyStep() {
        return completePropertyStep;
    }

    public void setCompletePropertyStep(Integer completePropertyStep) {
        this.completePropertyStep = completePropertyStep;
    }

    public String getPropertyAssigned() {
        return propertyAssigned;
    }

    public void setPropertyAssigned(String propertyAssigned) {
        this.propertyAssigned = propertyAssigned;
    }

    public String getBasicDetailsVerify() {
        return basicDetailsVerify;
    }

    public void setBasicDetailsVerify(String basicDetailsVerify) {
        this.basicDetailsVerify = basicDetailsVerify;
    }

    public String getPropertyDetailsVerify() {
        return propertyDetailsVerify;
    }

    public void setPropertyDetailsVerify(String propertyDetailsVerify) {
        this.propertyDetailsVerify = propertyDetailsVerify;
    }

    public String getPropertyImageVerify() {
        return propertyImageVerify;
    }

    public void setPropertyImageVerify(String propertyImageVerify) {
        this.propertyImageVerify = propertyImageVerify;
    }

    public String getPropertyVerified() {
        return propertyVerified;
    }

    public void setPropertyVerified(String propertyVerified) {
        this.propertyVerified = propertyVerified;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getEidOrPassport() {
        return eidOrPassport;
    }

    public void setEidOrPassport(String eidOrPassport) {
        this.eidOrPassport = eidOrPassport;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public Integer getNoOfBed() {
        return noOfBed;
    }

    public void setNoOfBed(Integer noOfBed) {
        this.noOfBed = noOfBed;
    }

    public Long getPropertyHolder() {
        return propertyHolder;
    }

    public void setPropertyHolder(Long propertyHolder) {
        this.propertyHolder = propertyHolder;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getTitleDeed() {
        return titleDeed;
    }

    public void setTitleDeed(String titleDeed) {
        this.titleDeed = titleDeed;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Integer totalArea) {
        this.totalArea = totalArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyNoc() {
        return propertyNoc;
    }

    public void setPropertyNoc(String propertyNoc) {
        this.propertyNoc = propertyNoc;
    }

    public Long getKindOfPropertyId() {
        return kindOfPropertyId;
    }

    public void setKindOfPropertyId(Long kindOfPropertyId) {
        this.kindOfPropertyId = kindOfPropertyId;
    }

    public String getKindOfPropertyName() {
        return kindOfPropertyName;
    }

    public void setKindOfPropertyName(String kindOfPropertyName) {
        this.kindOfPropertyName = kindOfPropertyName;
    }

    public Long getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(Long propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Long getPropertyHolderId() {
        return propertyHolderId;
    }

    public void setPropertyHolderId(Long propertyHolderId) {
        this.propertyHolderId = propertyHolderId;
    }

    public String getPropertyHolderName() {
        return propertyHolderName;
    }

    public void setPropertyHolderName(String propertyHolderName) {
        this.propertyHolderName = propertyHolderName;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
