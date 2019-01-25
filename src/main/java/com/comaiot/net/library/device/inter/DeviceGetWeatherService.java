package com.comaiot.net.library.device.inter;

import com.comaiot.net.library.device.bean.WeatherEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface DeviceGetWeatherService {

    @GET("s6/weather/now")
    Observable<WeatherEntity> getWeather(@Query("location") String location, @Query("key") String key);

    @GET("weather/query")
    Observable<WeatherEntity> getWeatherByIp(@Query("ip") String ip);
}
