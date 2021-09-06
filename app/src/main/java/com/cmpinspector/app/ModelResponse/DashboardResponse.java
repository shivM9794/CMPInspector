package com.cmpinspector.app.ModelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardResponse {
    @SerializedName("success")
    @Expose
    String success;

    @SerializedName("message")
    @Expose
    String message;

    @SerializedName("result")
    @Expose
    Result result;

    public DashboardResponse(String success, String message, Result result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
