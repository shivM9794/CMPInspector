package com.cmpinspector.app;

import com.cmpinspector.app.ModelResponse.DashboardResponse;
import com.cmpinspector.app.ModelResponse.LoginResponse;
import com.cmpinspector.app.ModelResponse.Logout.LogoutResponse;
import com.cmpinspector.app.ModelResponse.StepFourSubmit.StepFourResponse;
import com.cmpinspector.app.ModelResponse.StepOneAndTwo.StepOneAndTwoResponse;
import com.cmpinspector.app.ModelResponse.StepOneAndTwoSave.StepOneAndTwoSaveResponse;
import com.cmpinspector.app.ModelResponse.StepThree.StepThreeResponse;
import com.cmpinspector.app.ModelResponse.StepThreeAddPropertyImages.StepThreeAddImagesResponse;
import com.cmpinspector.app.ModelResponse.StepThreeSubmit.StepThreeSubmitResponse;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface Api {

    @FormUrlEncoded
    @POST("inspector/setLogin")
    Call<LoginResponse> login(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("inspector/getInspectorHomePagePropertyData")
    Call<DashboardResponse> dashboard(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("inspector/getProfileData")
    Call<LoginResponse> profile(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("inspector/getPropertyStepThreeData")
    Call<StepThreeResponse> step_threeResponse(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @POST("inspector/addPropertyImageData")
    @Multipart
    Call<StepThreeAddImagesResponse> add_property(@HeaderMap Map<String,String> headers, @PartMap Map<String, String> map, @Part List<MultipartBody.Part> files);

    @FormUrlEncoded
    @POST("inspector/setLogout")
    Call<LogoutResponse> logout(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("inspector/getPropertyStepOneTwoData")
    Call<StepOneAndTwoResponse> step_one_and_two_Response(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("inspector/addPropertyStepThreeData")
    Call<StepThreeSubmitResponse> step_three_sub(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("inspector/addPropertyStepFourData")
    Call<StepFourResponse> step_four_sub(@HeaderMap Map<String,String> headers, @FieldMap Map<String, String> params);

    @Multipart
    @POST("inspector/addPropertyStepOneTwoData")
    Call<StepOneAndTwoSaveResponse> step_one_two_save(@HeaderMap Map<String,String> headers,
                                                      @PartMap Map<String, String> map,
                                                      @Part List<MultipartBody.Part> title_deed,
                                                      @Part List<MultipartBody.Part> eid,
                                                      @Part List<MultipartBody.Part> trade_license,
                                                      @Part List<MultipartBody.Part> eid_passport,
                                                      @Part List<MultipartBody.Part> poa);






}
