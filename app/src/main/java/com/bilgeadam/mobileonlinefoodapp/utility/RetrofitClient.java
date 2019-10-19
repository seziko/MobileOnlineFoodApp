package com.bilgeadam.mobileonlinefoodapp.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL="http://10.0.2.2:8034";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance (final Context context){

        final OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        SharedPreferences sharedPreferences =
                                context.getSharedPreferences("BILGEADAMPREF",Context.MODE_PRIVATE);
                        String token = sharedPreferences.getString("TOKEN", null);
                        if (token != null){
                            Request request = chain.request().newBuilder()
                                                .addHeader("Authorization","Baerer "+token)
                                                .build();
                            return chain.proceed(request);
                        }
                        return chain.proceed(chain.request());
                    }
                })
        .build();


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .client(okHttpClient)
            .build();
    return retrofit;

    }
}
