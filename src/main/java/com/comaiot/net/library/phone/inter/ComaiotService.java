package com.comaiot.net.library.phone.inter;

import com.comaiot.net.library.device.bean.DevLoginEntity;
import com.comaiot.net.library.device.bean.DevQueryTimeEntity;
import com.comaiot.net.library.device.bean.DevScanBarcodeEntity;
import com.comaiot.net.library.phone.bean.AppAidEntity;
import com.comaiot.net.library.phone.bean.AppBarcodeReqEntity;
import com.comaiot.net.library.phone.bean.AppBindWeixinEntity;
import com.comaiot.net.library.phone.bean.AppChangeAccountInfoEntity;
import com.comaiot.net.library.phone.bean.AppChangePasswordEntity;
import com.comaiot.net.library.phone.bean.AppChangePhoneEntity;
import com.comaiot.net.library.phone.bean.AppQueryAidBindEntity;
import com.comaiot.net.library.phone.bean.AppQuerySharedDeviceEntity;
import com.comaiot.net.library.phone.bean.AppReceiveShareEntity;
import com.comaiot.net.library.phone.bean.AppReceiveShareNumEntity;
import com.comaiot.net.library.phone.bean.AppRemoveAidEntity;
import com.comaiot.net.library.phone.bean.AppRemoveSharedDeviceEntity;
import com.comaiot.net.library.phone.bean.AppResetPasswordByPhoneEntity;
import com.comaiot.net.library.phone.bean.AppShareDeviceEntity;
import com.comaiot.net.library.phone.bean.AppSubscribeEntity;
import com.comaiot.net.library.phone.bean.AppUnSubscribeEntity;
import com.comaiot.net.library.phone.bean.BaseAppEntity;
import com.comaiot.net.library.phone.bean.BindPhoneEntity;
import com.comaiot.net.library.phone.bean.RegEntity;
import com.comaiot.net.library.phone.bean.SmsEntity;
import com.comaiot.net.library.phone.bean.StorageEntity;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface ComaiotService {

    @POST("api/v2/StoreTokenReq")
    Observable<StorageEntity> getStorageToken(@Body RequestBody body);

    @POST("api/v2/HeaderImageTokenReq")
    Observable<StorageEntity> HeaderImageTokenReq(@Body RequestBody body);

    @POST("api/v2/SmsTokenReq")
    Observable<SmsEntity> smsToPhone(@Body RequestBody body);

    @POST("api/v2/AppRegReq")
    Observable<RegEntity> AppReg(@Body RequestBody body);

    @POST("api/v2/AppBindphoneReq")
    Observable<BindPhoneEntity> bindPhone(@Body RequestBody body);

    @POST("api/v2/AppSubscribeReq")
    Observable<AppSubscribeEntity> LoginByPassword(@Body RequestBody body);

    @POST("api/v2/PartnerSubscribeReq")
    Observable<AppSubscribeEntity> loginYD(@Body RequestBody body);

    @POST("api/v2/AppUnsubscribeReq")
    Observable<AppUnSubscribeEntity> AppUnSubscribeReq(@Body RequestBody body);

    @POST("api/v2/AppAidReq")
    Observable<AppAidEntity> AppAidReq(@Body RequestBody body);

    @POST("api/v2/AppBarcodeReq")
    Observable<AppBarcodeReqEntity> AppBarcodeReq(@Body RequestBody body);

    @POST("api/v2/DevScanBarcodeReq")
    Observable<DevScanBarcodeEntity> DevScanBarcodeReq(@Body RequestBody body);

    @POST("api/v2/DevLogoutReq")
    Observable<AppUnSubscribeEntity> DevLogoutReq(@Body RequestBody body);

    @POST("api/v2/DevLoginReq")
    Observable<DevLoginEntity> DevLoginReq(@Body RequestBody body);

    @POST("api/v2/AppQueryAidBindReq")
    Observable<AppQueryAidBindEntity> AppQueryAidBindReq(@Body RequestBody body);

    @POST("api/v2/AppRemoveAidReq")
    Observable<AppRemoveAidEntity> AppRemoveAidReq(@Body RequestBody body);

    @POST("api/v2/AppShareDeviceReq")
    Observable<AppShareDeviceEntity> AppShareDeviceReq(@Body RequestBody body);

    @POST("api/v2/AppSubscribeReq")
    Observable<AppSubscribeEntity> LoginByWeChat(@Body RequestBody body);

    @POST("api/v2/AppBindWeixinReq")
    Observable<AppBindWeixinEntity> AppBindWeixinReq(@Body RequestBody body);

    @POST("api/v2/DevUploadFileReq")
    Observable<BaseAppEntity> DevUploadFileReq(@Body RequestBody body);

    @POST("api/v2/CallOwnerReq")
    Observable<BaseAppEntity> CallOwnerReq(@Body RequestBody body);

    @POST("api/v2/AppResetPasswordByPhoneReq")
    Observable<AppResetPasswordByPhoneEntity> AppResetPasswordByPhoneReq(@Body RequestBody body);

    @POST("api/v2/AppReceiveShareReq")
    Observable<AppReceiveShareEntity> AppReceiveShareReq(@Body RequestBody body);

    @POST("api/v2/AppReceiveShareReq")
    Observable<AppReceiveShareNumEntity> AppReceiveShareNumReq(@Body RequestBody body);

    @POST("api/v2/AppChangePasswordReq")
    Observable<AppChangePasswordEntity> AppChangePasswordReq(@Body RequestBody body);

    @POST("api/v2/AppChangeAccountInfoReq")
    Observable<AppChangeAccountInfoEntity> AppChangeAccountInfoReq(@Body RequestBody body);

    @POST("api/v2/AppChangePhoneReq")
    Observable<AppChangePhoneEntity> AppChangePhoneReq(@Body RequestBody body);

    @POST("api/v2/DevQueryTimeReq")
    Observable<DevQueryTimeEntity> DevQueryTimeReq(@Body RequestBody body);

    @POST("api/v2/AppRemoveSharedDeviceReq")
    Observable<AppRemoveSharedDeviceEntity> AppRemoveSharedDeviceReq(@Body RequestBody body);

    @POST("api/v2/PushMessageOwnerReq")
    Observable<BaseAppEntity> PushMessageOwnerReq(@Body RequestBody body);

    @POST("api/v2/PushMessageOwnerReq")
    Observable<BaseAppEntity> PushMessageOwnerReqIos(@Body RequestBody body);

    @POST("api/v2/AccReadReq")
    Observable<BaseAppEntity> AccReadReq(@Body RequestBody body);

    @POST("api/v2/AccDeleteReq")
    Observable<BaseAppEntity> AccDeleteReq(@Body RequestBody body);

    @POST("api/v2/AccCreateReq")
    Observable<BaseAppEntity> AccCreateReq(@Body RequestBody body);

    @POST("api/v2/AccUpdateReq")
    Observable<BaseAppEntity> AccUpdateReq(@Body RequestBody body);
}
