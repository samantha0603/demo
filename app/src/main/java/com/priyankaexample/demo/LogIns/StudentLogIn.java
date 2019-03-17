package com.priyankaexample.demo.LogIns;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.priyankaexample.demo.ParentClasses.Parent;
import com.priyankaexample.demo.R;
import com.priyankaexample.demo.Registration;
import com.priyankaexample.demo.Retrofit.ApiClient;
import com.priyankaexample.demo.Retrofit.ApiInterface;
import com.priyankaexample.demo.StudentClasses.Student;
import com.priyankaexample.demo.TeacherClasses.DemoTeacher;
import com.priyankaexample.demo.TeacherClasses.Teacher;
import com.priyankaexample.demo.Welcome;
import com.priyankaexample.demo.adapters.LoginDataBringer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLogIn extends Activity {
    Button b;
    TextView error,regt;
    ProgressBar progressBar;

    EditText userid, pwd;
    public static String usr1;
    static String pass;
    String mlabusr=" ",mlabpwd=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_log_in);


        b = findViewById(R.id.login);
        regt=findViewById(R.id.newuserbtn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                userid = findViewById(R.id.editText1);
                pwd = findViewById(R.id.editText2);
                usr1 = userid.getText().toString();
                pass = pwd.getText().toString();

                //login
                if(usr1.length()>0 && pass.length()>0 ) {
                    if (Welcome.who.equals("student")) {
                        Toast.makeText(getApplicationContext(), "Logging in as " + Welcome.who, Toast.LENGTH_SHORT).show();
                        String s = "{\"username\":\"" + usr1 + "\"}" + "{\"password\":\"" + pass + "\"}";
                        ApiInterface apiCall = ApiClient.getApiClient().create(ApiInterface.class);
                        final Call<List<LoginDataBringer>> data = apiCall.studentLogin(s);
                        data.enqueue(new Callback<List<LoginDataBringer>>() {
                            @Override
                            public void onResponse(@NonNull Call<List<LoginDataBringer>> call, @NonNull Response<List<LoginDataBringer>> response) {

                                if (response.body().size() > 0) {
                                    mlabusr = response.body().get(0).getUsername();
                                    mlabpwd = response.body().get(0).getPassword();
                                }

                                if (usr1.equals(mlabusr) && pass.equals(mlabpwd)) {
                                    //shared preference
                                    SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("username", mlabusr);
                                    editor.putString("pwd", mlabpwd);
                                    editor.putString("logined", "true");
                                    editor.commit();
                                    startActivity(new Intent(getApplicationContext(), Student.class));
                                } else {
                                    Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();

                                }


                            }

                            @Override
                            public void onFailure(Call<List<LoginDataBringer>> call, Throwable t) {
                                Toast.makeText(v.getContext(), "kk", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else if (Welcome.who.equals("teacher")){
                        Toast.makeText(getApplicationContext(), "Logging in as " + Welcome.who, Toast.LENGTH_SHORT).show();
                        String s = "{\"username\":\"" + usr1 + "\"}" + "{\"password\":\"" + pass + "\"}";
                        ApiInterface apiCall = ApiClient.getApiClient().create(ApiInterface.class);
                        final Call<List<LoginDataBringer>> data = apiCall.teacherLogin(s);
                        data.enqueue(new Callback<List<LoginDataBringer>>() {
                            @Override
                            public void onResponse(@NonNull Call<List<LoginDataBringer>> call, @NonNull Response<List<LoginDataBringer>> response) {

                                if (response.body().size() > 0) {
                                    mlabusr = response.body().get(0).getUsername();
                                    mlabpwd = response.body().get(0).getPassword();
                                }

                                if (usr1.equals(mlabusr) && pass.equals(mlabpwd)) {
                                    //shared preference
                                    SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("username", mlabusr);
                                    editor.putString("pwd", mlabpwd);
                                    editor.putString("logined", "true");
                                    editor.commit();
                                    startActivity(new Intent(getApplicationContext(), Teacher.class));
                                } else {
                                    Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();

                                }


                            }

                            @Override
                            public void onFailure(Call<List<LoginDataBringer>> call, Throwable t) {
                                Toast.makeText(v.getContext(), "kk", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else if (Welcome.who.equals("parent")){
                        Toast.makeText(getApplicationContext(), "Logging in as " + Welcome.who, Toast.LENGTH_SHORT).show();
                        String s = "{\"username\":\"" + usr1 + "\"}" + "{\"password\":\"" + pass + "\"}";
                        ApiInterface apiCall = ApiClient.getApiClient().create(ApiInterface.class);
                        final Call<List<LoginDataBringer>> data = apiCall.parentLogin(s);
                        data.enqueue(new Callback<List<LoginDataBringer>>() {
                            @Override
                            public void onResponse(@NonNull Call<List<LoginDataBringer>> call, @NonNull Response<List<LoginDataBringer>> response) {

                                if (response.body().size() > 0) {
                                    mlabusr = response.body().get(0).getUsername();
                                    mlabpwd = response.body().get(0).getPassword();
                                }

                                if (usr1.equals(mlabusr) && pass.equals(mlabpwd)) {
                                    //shared preference
                                    SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("username", mlabusr);
                                    editor.putString("pwd", mlabpwd);
                                    editor.putString("logined", "true");
                                    editor.commit();
                                    startActivity(new Intent(getApplicationContext(), Parent.class));
                                } else {
                                    Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();

                                }


                            }

                            @Override
                            public void onFailure(Call<List<LoginDataBringer>> call, Throwable t) {
                                Toast.makeText(v.getContext(), "kk", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }/*

                if(Welcome.who.equals("teacher")){
                    startActivity(new Intent(getApplicationContext(),Teacher.class));
                }else if (Welcome.who.equals("student")){
                    startActivity(new Intent(getApplicationContext(),Student.class));
                }else if (Welcome.who.equals("parent")){
                    startActivity(new Intent(getApplicationContext(),Parent.class));
                }else if(usr1.isEmpty() && pass.isEmpty())
                {

                    Toast.makeText(getApplicationContext(),"Please provide username and password",Toast.LENGTH_SHORT).show();



                }*/


                //Toast.makeText(getApplicationContext(),"error login",Toast.LENGTH_LONG).show();

            }
        });
        regt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });
    }

}