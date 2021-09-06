package com.cmpinspector.app.ModelResponse.StepThreeAddPropertyImages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StepThreeAddImagesResponse {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private Boolean message;
    @SerializedName("result")
    @Expose
    private Result result;

    public StepThreeAddImagesResponse(Integer success, Boolean message, Result result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Boolean getMessage() {
        return message;
    }

    public void setMessage(Boolean message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
