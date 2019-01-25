package com.comaiot.net.library.device.inter;

import com.comaiot.net.library.device.bean.CheckPersonEntity;
import com.comaiot.net.library.device.bean.FaceverifyEntity;
import com.comaiot.net.library.device.bean.WeatherEntity;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

public interface BaiDuApiService {

    @POST("detect")
    Observable<CheckPersonEntity> checkPersonFace(@Query("access_token") String access_token, @Body RequestBody body);

    @POST("faceverify")
    Observable<FaceverifyEntity> faceverify(@Query("access_token") String access_token, @Body RequestBody body);
}
