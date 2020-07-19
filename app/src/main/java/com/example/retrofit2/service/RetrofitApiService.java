package com.example.retrofit2.service;

import com.example.retrofit2.entity.Articulo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApiService {
    @GET("posts/{id}")
    Call<Articulo> getArticuloId(@Path("id") int id);

    @GET("posts")
    Call<List<Articulo>> getArticulosUderId(@Query("userId") int userId);
}
