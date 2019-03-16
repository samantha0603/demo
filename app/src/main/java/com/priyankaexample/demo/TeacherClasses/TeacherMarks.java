package com.priyankaexample.demo.TeacherClasses;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.priyankaexample.demo.R;
import com.priyankaexample.demo.Retrofit.ApiClient;
import com.priyankaexample.demo.Retrofit.ApiInterface;
import com.priyankaexample.demo.Retrofit.RetroServer;
import com.priyankaexample.demo.adapters.LoginData;
import com.priyankaexample.demo.adapters.LoginStaticData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherMarks extends Activity {
    EditText userName;
    Button login_button;
    ProgressBar progressBar;
    String username;
    ApiInterface retroGet;
    List<LoginData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_marks);

        // Inflate the layout for this fragment
        userName=findViewById(R.id.usrname);
        login_button=findViewById(R.id.login);

        progressBar=findViewById(R.id.progressBar);
        //toolbar=v.findViewById(R.id.mycustom_tool_bar);
        // ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (userName.getText().toString().equals("")|| userName.getText().length()<=9) {
                    Toast.makeText(getApplicationContext(),"please enter valid number",Toast.LENGTH_SHORT).show();
                }

                else{
                    progressBar.setIndeterminate(true);
                    progressBar.setVisibility(View.VISIBLE);

                    //pass.setEnabled(false);
                    //phoneNo = phone.getText().toString();
                    username=userName.getText().toString().toUpperCase();

                    // passWord=password.getText().toString();
                    Log.d("Fragment_Marks_Debug","reached here1");
                    String q = "{\"regno\":{$eq:\""+ username+"\"}}";
                    Log.d("Fragment_Marks_Debug","reached here2");
                    retroGet = RetroServer.getRetrofit().create(ApiInterface.class);
                    Call<List<LoginData>> dataCall = retroGet.getPhone("LOGIN", "AKPhEaFsE8c1f98hiX1VXa0dj5_7KFq0", q);
                    progressBar.setVisibility(View.VISIBLE);
                    Log.d("Fragment_Marks_Debug","reached here 3");

                    // SharedPreferences sharedPreferences = getSharedPreferences("MyLogin", MODE_PRIVATE);
                    //final SharedPreferences.Editor editor = sharedPreferences.edit();
                    //   userName.setEnabled(false);
                    // login.setEnabled(false);
                    dataCall.enqueue(new Callback<List<LoginData>>() {

                        @Override
                        public void onResponse(@NonNull Call<List<LoginData>> call, @NonNull Response<List<LoginData>> response) {
                            list = response.body();
                            assert response.body() != null;
                            try{
                                if (!(list == null || list.isEmpty())) {

                                    LoginStaticData.setRegno(list.get(0).regno);
                                    LoginStaticData.setProfile(list.get(0).getProfile());
                                    LoginStaticData.setAttendance(list.get(0).attendance);
                                    LoginStaticData.setMarks(list.get(0).getMarks());
                                    Bundle regBundle=new Bundle();
                                    regBundle.putString("regNo",username);

                                    Intent i = new Intent(getApplicationContext(),TeacherMarksShow.class);
                                    i.putExtra("user",username);
                                    startActivity(i);
                                    progressBar.setVisibility(View.INVISIBLE);
                                }
                                else{
                                    // fun();
                                }}
                            catch (Exception e){

                            }

                        }
                        @Override
                        public void onFailure(@NonNull Call<List<LoginData>> call, @NonNull Throwable t) {
                            progressBar.setVisibility(View.INVISIBLE);

                            // userName.setEnabled(true);
                            // password.setEnabled(true);
                            // login.setEnabled(true);
                            Toast.makeText(getApplicationContext(),"please connect to active network",Toast.LENGTH_SHORT).show();
                        }

                    });
                }
            }
        });

    }
}
