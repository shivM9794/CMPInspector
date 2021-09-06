package com.cmpinspector.app.ModelResponse.StepThreeAddPropertyImages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("image_id")
    @Expose
    private Long imageId;
    @SerializedName("property_id")
    @Expose
    private Long propertyId;
    @SerializedName("property_image")
    @Expose
    private String propertyImage;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("_id")
    @Expose
    private Id id;
}
