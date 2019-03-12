package com.comaiot.net.library.device.inter;

import com.comaiot.net.library.device.bean.YDBase;
import com.comaiot.net.library.device.bean.YDShareUser;
import com.comaiot.net.library.phone.bean.StorageEntity;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface YdService {

    @POST("cat-eye/updateDeviceName")
    Observable<YDBase> updateDeviceName(@Header("token") String token, @Body RequestBody body);

    @POST("cat-eye-users/share")
    Observable<YDBase> shareDevice(@Header("token") String token, @Body RequestBody body);

    @POST("cat-eye-users/delete")
    Observable<YDBase> deleteShare(@Header("token") String token, @Body RequestBody body);

    @POST("cat-eye/delete/{sn}")
    Observable<YDBase> deleteDevice(@Header("token") String token, @Path("sn") String sn);

    @GET("cat-eye-users/list/{sn}")
    Observable<YDBase<YDShareUser[]>> getShareList(@Header("token") String token, @Path("sn") String sn);
}
