package com.app.retrofit.Service; /**
 * Created by djlophu on 02/03/15.
 */

import com.app.retrofit.Models.MainTable;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;


public interface EventEyeService {
    @GET("/sync")
    void getTags(@Header("Authorization") String authorization, Callback<MainTable> callback);

}
