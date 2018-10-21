package com.bd.habib.retrofitgetpost;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static final String BASE_URL = "http://biswajitdas.me/projects/retrofit_get_post/";
    private static final Gson gson = new GsonBuilder().setLenient().create();
    private static Retrofit retrofit = null;

    private ApiClient() {

    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
