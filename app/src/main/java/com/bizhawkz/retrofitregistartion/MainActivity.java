package com.bizhawkz.retrofitregistartion;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // RegisterUSer("heena","abcq1@gmail.com","aaa","1","0");
        LoginUser("abc12heena@gmail.com","1");
    }

    private void LoginUser(String email, String pass) {
        Call<ResponseBody> callback=Network.getBaseInstance().login(Constants.CASE_ID2,email,pass);
        callback.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String res = response.body().string();
                    Log.e(TAG,"my response"+res);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }

    private void RegisterUSer(String fname, String lstname, String mail, String passw, String phone) {
        Call<ResponseBody> callback= Network.getBaseInstance().loginUser(Constants.CASE_ID,fname,mail,lstname,passw,phone);
        callback.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String res = response.body().string();
                    Log.e(TAG,"my response"+res);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });

    }


}
