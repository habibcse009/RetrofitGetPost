package com.bd.habib.retrofitgetpost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("server_side_code.php")
    Call<ServerResponse> verifyUser(@Body User userCredential);

    @GET("server_side_code.php")
    Call<ServerResponse> getMessage(@Query("user_id") String ussername);
}
