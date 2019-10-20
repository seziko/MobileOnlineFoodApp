package com.bilgeadam.mobileonlinefoodapp.services;


import com.bilgeadam.mobileonlinefoodapp.dto.JwtTokenRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationService {

    @POST ("/authenticate")
    Call<ResponseBody> authenticate(@Body JwtTokenRequest request);

}
