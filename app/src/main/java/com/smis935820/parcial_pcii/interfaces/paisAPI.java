package com.smis935820.parcial_pcii.interfaces;

import com.smis935820.parcial_pcii.models.Pais;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface paisAPI {
    @GET("apiPais/paisfilter.php/")
    Call<Pais> find(@Query("id") String id);

    @GET("apiPais/read.php/")
    Call<List<Pais>> getPais();

    @POST("apiPais/create.php/")
    Call<Pais> savePais(@Body Pais pais);

    @PUT("apiPais/update.php/")
    Call<Pais> updatePais(@Body Pais pais);

    @DELETE("apiPais/Delete.php/")
    Call<Pais> deletePais(@Query("id") Pais id);

}
