package com.bizhawkz.retrofitregistartion;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Heena on 5/15/2017.
 */
public interface AllApi {
    @FormUrlEncoded
    @POST("insert_data.php")
    public Call<ResponseBody> loginUser(@Field("case_id") String caseid,@Field("name") String firstname,
                                        @Field("email") String email,
                                        @Field("lstname") String lastname,@Field("password")String password,@Field("phone") String Phone);
    @FormUrlEncoded
    @POST("insert_data.php")
    public Call<ResponseBody>login(@Field("case_id")String caseid,@Field("email") String email,
                                   @Field("password") String password);

}
