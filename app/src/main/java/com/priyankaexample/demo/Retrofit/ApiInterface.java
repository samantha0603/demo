package com.priyankaexample.demo.Retrofit;

import com.priyankaexample.demo.adapters.CourseData;
import com.priyankaexample.demo.adapters.LoginData;
import com.priyankaexample.demo.adapters.LoginDataBringer;
import com.priyankaexample.demo.adapters.MarksData;
import com.priyankaexample.demo.adapters.NoticeData;
import com.priyankaexample.demo.adapters.TeacherTimeTable;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    //login
    @GET("student_login/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    Call<List<LoginDataBringer>> studentLogin(@Query("q") String s);

    @GET("teacher_login/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    Call<List<LoginDataBringer>> teacherLogin(@Query("q") String s);

    @GET("parent_login/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    Call<List<LoginDataBringer>> parentLogin(@Query("q") String s);



    @GET("collections/{col}")
    Call<List<LoginData>> getPhone(@Path("col") String col, @Query("apiKey") String key, @Query("q") String q);

    @GET("collections/{coll}")
    Call<String> getAttendance(@Path("coll")String coll, @Query("apiKey") String key, @Query("q") String q);
    @GET("collections/{coll}")
    Call<String> getMarksData(@Path("coll")String coll, @Query("apiKey") String key, @Query("q") String q);

    @GET("marks/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    Call<List<MarksData>> getMarks();

    @GET("marks/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    Call<List<MarksData>> getMyMarks(@Query("q") String s);
    @GET("teachertimetable/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    Call<List<TeacherTimeTable>> getTeacherTime();

    @GET("everydaytimetable/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    Call<List<TeacherTimeTable>> getStudentTime();

    @GET("courses/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    Call<List<CourseData>> getStudentCourse();

    @GET("noti/?apiKey=PS-NhgOwgrqYOLhiMvrdHj_PW5rjXrpq")
    Call<List<NoticeData>> getStudentNotices();
}
