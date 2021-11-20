package com.example.universities;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("search?country=India")
    Call<List<Model>> getAllUniversities();
}
