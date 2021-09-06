package com.cmpinspector.app.ModelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InspectorData {
    @SerializedName("inspector_token")
    @Expose
    private String inspectorToken;
    @SerializedName("inspector_id")
    @Expose
    private Long inspectorId;
    @SerializedName("inspector_sequence_id")
    @Expose
    private String inspectorSequenceId;
    @SerializedName("inspector_name")
    @Expose
    private String inspectorName;
    @SerializedName("inspector_email")
    @Expose
    private String inspectorEmail;
    @SerializedName("inspector_mobile")
    @Expose
    private String inspectorMobile;
    @SerializedName("inspector_image")
    @Expose
    private String inspectorImage;

    public InspectorData(String inspectorToken, Long inspectorId, String inspectorSequenceId, String inspectorName, String inspectorEmail, String inspectorMobile, String inspectorImage) {
        this.inspectorToken = inspectorToken;
        this.inspectorId = inspectorId;
        this.inspectorSequenceId = inspectorSequenceId;
        this.inspectorName = inspectorName;
        this.inspectorEmail = inspectorEmail;
        this.inspectorMobile = inspectorMobile;
        this.inspectorImage = inspectorImage;
    }

    public String getInspectorToken() {
        return inspectorToken;
    }

    public void setInspectorToken(String inspectorToken) {
        this.inspectorToken = inspectorToken;
    }

    public Long getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(Long inspectorId) {
        this.inspectorId = inspectorId;
    }

    public String getInspectorSequenceId() {
        return inspectorSequenceId;
    }

    public void setInspectorSequenceId(String inspectorSequenceId) {
        this.inspectorSequenceId = inspectorSequenceId;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public String getInspectorEmail() {
        return inspectorEmail;
    }

    public void setInspectorEmail(String inspectorEmail) {
        this.inspectorEmail = inspectorEmail;
    }

    public String getInspectorMobile() {
        return inspectorMobile;
    }

    public void setInspectorMobile(String inspectorMobile) {
        this.inspectorMobile = inspectorMobile;
    }

    public String getInspectorImage() {
        return inspectorImage;
    }

    public void setInspectorImage(String inspectorImage) {
        this.inspectorImage = inspectorImage;
    }
}
