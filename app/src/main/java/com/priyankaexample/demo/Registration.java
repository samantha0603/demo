package com.priyankaexample.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.priyankaexample.demo.LogIns.StudentLogIn;
import com.priyankaexample.demo.Retrofit.ApiClient;
import com.priyankaexample.demo.Retrofit.ApiInterface;
import com.priyankaexample.demo.Retrofit.ApiInterfacePut;
import com.priyankaexample.demo.Retrofit.ApiService;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final EditText id,phn,mail,pwd,dept;
        Button reg;
        pwd = findViewById(R.id.editText2);
        phn = findViewById(R.id.editText3);
        mail = findViewById(R.id.editText4);
        id = findViewById(R.id.editText1);
        dept = findViewById(R.id.editText5);
        reg = findViewById(R.id.button1);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regpwd,regphn,regmail,regid,regdept;


                regpwd = pwd.getText().toString();
                regphn = phn.getText().toString();
                regmail = mail.getText().toString();
                regid = id.getText().toString();
                regdept = dept.getText().toString();
                int flag = 0;
                if(regid.length() != 10){
                    Toast.makeText(getApplicationContext(),"Your ID should be your registered number",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }if (regpwd.length() < 6){
                    Toast.makeText(getApplicationContext(),"Your password should be atleast 6 characters long",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }if (regdept.length() < 2){
                    Toast.makeText(getApplicationContext(),"Enter a valid dept",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }if (regphn.length() < 10){
                    Toast.makeText(getApplicationContext(),"Enter a valid phone number",Toast.LENGTH_SHORT).show();
                    flag = 1;
                }if(flag == 0){
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("username",regid);
                    jsonObject.put("password",regpwd);
                    jsonObject.put("phone",regphn);
                    jsonObject.put("mail",regmail);
                    jsonObject.put("dept",regdept);
                    if(Welcome.who.equals("student")){
                    ApiInterfacePut apiPut = ApiService.getService().create(ApiInterfacePut.class);
                    Call<ResponseBody> body=apiPut.StudentRegistration(jsonObject.toString());
                    body.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            Toast.makeText(getApplicationContext(), "successfully registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),StudentLogIn.class));
                            finish();
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "please check your network", Toast.LENGTH_SHORT).show();
                        }
                    });
                    }else if(Welcome.who.equals("teacher")){
                        ApiInterfacePut apiPut = ApiService.getService().create(ApiInterfacePut.class);
                        Call<ResponseBody> body=apiPut.TeacherRegistration(jsonObject.toString());
                        body.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                Toast.makeText(getApplicationContext(), "successfully registered", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), StudentLogIn.class));
                                finish();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "please check your network", Toast.LENGTH_SHORT).show();
                            }

                    });
                    }else if (Welcome.who.equals("parent")){
                        ApiInterfacePut apiPut = ApiService.getService().create(ApiInterfacePut.class);
                            Call<ResponseBody> body=apiPut.ParentRegistration(jsonObject.toString());
                            body.enqueue(new Callback<ResponseBody>() {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                    Toast.makeText(getApplicationContext(), "successfully registered", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),StudentLogIn.class));
                                    finish();
                                }

                                @Override
                                public void onFailure(Call<ResponseBody> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), "please check your network", Toast.LENGTH_SHORT).show();
                                }
                    });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }                }
            }
        });
    }
}
