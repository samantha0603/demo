package com.priyankaexample.demo.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterfacePut{
    @POST("notices/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> saveNotice(@Body String body);

    @POST("courses/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> saveCourse(@Body String body);

    @POST("student_login/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> StudentRegistration(@Body String str);
    @POST("teacher_login/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> TeacherRegistration(@Body String str);

    @POST("parent_login/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> ParentRegistration(@Body String str);


}
