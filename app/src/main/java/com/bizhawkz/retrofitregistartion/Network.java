package com.bizhawkz.retrofitregistartion;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Heena on 5/15/2017.
 */
public class Network {
    private static AllApi allApi = null;
    static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    static {
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        httpClient.readTimeout(60, TimeUnit.SECONDS);
        httpClient.connectTimeout(60, TimeUnit.SECONDS);
    }

    public static AllApi getBaseInstance() {
        if (allApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            allApi = retrofit.create(AllApi.class);
        }
        return allApi;
    }
}
