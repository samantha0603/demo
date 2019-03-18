package com.priyankaexample.demo.TeacherClasses;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.priyankaexample.demo.R;
import com.priyankaexample.demo.Retrofit.ApiInterfacePut;
import com.priyankaexample.demo.Retrofit.ApiService;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherNotice extends Activity {
    EditText heading,notice;
    Button submit;
    String head,detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_notice);
        heading = findViewById(R.id.heading_notice);
        notice = findViewById(R.id.notice_details);
        submit = findViewById(R.id.submit_notice);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submit.setEnabled(false);
                    InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);


                    head = heading.getText().toString();
                    detail = notice.getText().toString();
                    if (head.length() > 0 && detail.length() > 0) {
                        //put operation
                        JSONObject j = new JSONObject();
                        try {
                            j.put("heading", head);
                            j.put("details", detail);

                            ApiInterfacePut apiPut = ApiService.getService().create(ApiInterfacePut.class);
                            System.out.println("Hello" + j.toString());
                            Call<ResponseBody> body = apiPut.saveNotice(j.toString());
                            body.enqueue(new Callback<ResponseBody>() {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                                    Toast.makeText(getApplicationContext(), "Notice Posted Successfully", Toast.LENGTH_SHORT).show();
                                    submit.setEnabled(true);
                                }

                                @Override
                                public void onFailure(Call<ResponseBody> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_SHORT).show();
                                    submit.setEnabled(true);
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }


            });
        }

}
