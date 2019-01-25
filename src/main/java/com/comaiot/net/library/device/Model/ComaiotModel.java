package com.comaiot.net.library.device.Model;

import android.util.Log;

import com.comaiot.net.library.device.bean.ArogaBean;
import com.comaiot.net.library.device.bean.BaiduOauthEntity;
import com.comaiot.net.library.device.bean.CheckPersonEntity;
import com.comaiot.net.library.device.bean.DevLoginEntity;
import com.comaiot.net.library.device.bean.DevQueryTimeEntity;
import com.comaiot.net.library.device.bean.DevScanBarcodeEntity;
import com.comaiot.net.library.device.bean.FaceverifyEntity;
import com.comaiot.net.library.device.bean.WeatherEntity;
import com.comaiot.net.library.device.callback.CallBack;
import com.comaiot.net.library.device.utils.RetrofitUtil;
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
import com.comaiot.net.library.phone.inter.DESUtils;
import com.comaiot.net.library.phone.inter.MqttManager;
import com.comaiot.net.library.phone.inter.YDPreferences;
import com.comaiot.net.library.phone.okhttp.Logger;

import rx.Subscriber;

public class ComaiotModel {

    public static void getWeather(CallBack<WeatherEntity> callBack) {
        //获取天气
        Subscriber<WeatherEntity> mEntitySubscriber = new Subscriber<WeatherEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(WeatherEntity baseEntity) {
                if (baseEntity.getRt() != 0) {
                    callBack.onError(baseEntity.getMsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().getWeather(mEntitySubscriber);
    }

    public static void getWeatherByIp(String ipAddress, CallBack<WeatherEntity> callBack) {
        //获取天气
        Subscriber<WeatherEntity> mEntitySubscriber = new Subscriber<WeatherEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Test", "getWeatherByIp onError " + e.toString());
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(WeatherEntity baseEntity) {
                Log.e("Test", "getWeatherByIp onNext " + baseEntity.toString());
                if (baseEntity.getRt() != 0) {
                    callBack.onError(baseEntity.getMsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().getWeatherByIp(mEntitySubscriber, ipAddress);
    }

    public static void baiduOauth(String client_id, String client_secret, CallBack<BaiduOauthEntity> callBack) {
        //百度 api oauth
        Subscriber<BaiduOauthEntity> mEntitySubscriber = new Subscriber<BaiduOauthEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BaiduOauthEntity baseEntity) {
                if (baseEntity.getCode() != 0) {
                    callBack.onError(baseEntity.getMsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().baiduOauth(mEntitySubscriber, client_id, client_secret);
    }

    public static void checkPersonFace(String url, String image, CallBack<CheckPersonEntity> callBack) {
        //人脸检测
        Subscriber<CheckPersonEntity> mEntitySubscriber = new Subscriber<CheckPersonEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(CheckPersonEntity baseEntity) {
                if (baseEntity.getCode() != 0) {
                    callBack.onError(baseEntity.getMsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().checkPersonFace(mEntitySubscriber, url, image);
    }

    public static void faceverify(String url, String image, CallBack<FaceverifyEntity> callBack) {
        //在线活体检测
        Subscriber<FaceverifyEntity> mEntitySubscriber = new Subscriber<FaceverifyEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(FaceverifyEntity baseEntity) {
                if (baseEntity.getCode() != 0) {
                    callBack.onError(baseEntity.getMsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().faceverify(mEntitySubscriber, url, image);
    }

    public static void getStorageToken(String device_id, String device_token, String file_name, CallBack<StorageEntity> callBack) {
        //获取七牛云存储token
        Subscriber<StorageEntity> mEntitySubscriber = new Subscriber<StorageEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(StorageEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    if (null != baseEntity.getErrmsg())
                        callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().getStorageToken(mEntitySubscriber, device_id, device_token, file_name);
    }

    public static void queryAgoraSocketUserNumber(String channelName, CallBack<ArogaBean<ArogaBean.Data>> callBack) {
        //query user number
        Subscriber<ArogaBean<ArogaBean.Data>> mEntitySubscriber = new Subscriber<ArogaBean<ArogaBean.Data>>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                Logger.ii("queryAgoraSocketUserNumber " + e.toString());
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(ArogaBean<ArogaBean.Data> arogaBean) {
                if (arogaBean.isSuccess()) {
                    callBack.onSuccess(arogaBean);
                } else {
                    callBack.onError("null");
                    callBack.onComplete();
                }
            }
        };
        RetrofitUtil.getInstance().queryAgoraSocketUserNumber(mEntitySubscriber, channelName);
    }

    public static void agoraLicenses(String custom, String credential,CallBack<ArogaBean.Licenses> callBack) {
        //query user number
        Subscriber<ArogaBean.Licenses> mEntitySubscriber = new Subscriber<ArogaBean.Licenses>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                Logger.ii("agoraLicenses " + e.toString());
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(ArogaBean.Licenses licensesArogaBean) {
                if (null!= licensesArogaBean) {
                    callBack.onSuccess(licensesArogaBean);
                } else {
                    callBack.onError("null");
                    callBack.onComplete();
                }
            }
        };
        RetrofitUtil.getInstance().agoraLicenses(mEntitySubscriber, custom,credential);
    }

    public static void HeaderImageTokenReq(String appUid, String token, String file_name, CallBack<StorageEntity> callBack) {
        //获取七牛云存储token
        Subscriber<StorageEntity> mEntitySubscriber = new Subscriber<StorageEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(StorageEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().HeaderImageTokenReq(mEntitySubscriber, appUid, token, file_name);
    }

    public static void smsToPhone(String app_uid, String phone_num, String app_envid, CallBack<SmsEntity> callBack) {
        //发送验证码
        Subscriber<SmsEntity> mEntitySubscriber = new Subscriber<SmsEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(SmsEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().smsToPhone(mEntitySubscriber, app_uid, phone_num, app_envid);
    }

    public static void AppReg(String appak, long timestamp, String nonce, String sign, String brand, String type, CallBack<RegEntity> callBack) {
        //上传密钥
        Subscriber<RegEntity> mEntitySubscriber = new Subscriber<RegEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(RegEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    String app_envid = baseEntity.getContent().getApp_envid();
                    String app_uid = baseEntity.getContent().getApp_uid();
                    app_uid = DESUtils.encryptString(app_uid);
                    app_envid = DESUtils.encryptString(app_envid);
                    YDPreferences.get().saveAppEnvid(app_envid);
                    YDPreferences.get().saveAppUid(app_uid);
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppReg(mEntitySubscriber, appak, timestamp, nonce, sign, brand, type);
    }

    public static void AppReg(String appak, long timestamp, String nonce, String sign, String brand, String type, String jwt, CallBack<RegEntity> callBack) {
        //上传密钥
        Subscriber<RegEntity> mEntitySubscriber = new Subscriber<RegEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(RegEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppReg(mEntitySubscriber, appak, timestamp, nonce, sign, brand, type, jwt);
    }

    public static void bindPhone(String appUid, String appEnvid, String phoneNumber, String verify_code, String pwd, String email, CallBack<BindPhoneEntity> callBack) {
        //绑定手机号
        Subscriber<BindPhoneEntity> mEntitySubscriber = new Subscriber<BindPhoneEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BindPhoneEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().bindPhone(mEntitySubscriber, appUid, appEnvid, phoneNumber, verify_code, pwd, email);
    }

    public static void LoginByPassword(String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type, CallBack<AppSubscribeEntity> callBack) {
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().LoginByPassword(mEntitySubscriber, appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type);
    }

    public static void AppUnSubscribeReq(String appUid, String appEnvid, String token, CallBack<AppUnSubscribeEntity> callBack) {
        Subscriber<AppUnSubscribeEntity> mEntitySubscriber = new Subscriber<AppUnSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppUnSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppUnSubscribeReq(mEntitySubscriber, appUid, appEnvid, token);
    }

    public static void LoginByPhone(String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type, CallBack<AppSubscribeEntity> callBack) {
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().LoginByPhone(mEntitySubscriber, appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type);
    }

    public static void loginYD(String jwt_token, CallBack<AppSubscribeEntity> callBack) {
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    String app_uid = baseEntity.getContent().getApp_uid();
                    String app_envid = baseEntity.getContent().getApp_envid();
                    String token = baseEntity.getContent().getToken();
                    YDPreferences.get().saveAppUid(DESUtils.encryptString(app_uid));
                    YDPreferences.get().saveAppEnvid(DESUtils.encryptString(app_envid));
                    YDPreferences.get().saveToken(DESUtils.encryptString(token));

                    String clientId = app_uid + "-" + app_envid;
                    String host = baseEntity.getContent().getMqtt().getIp();
                    String port = baseEntity.getContent().getMqtt().getPort();
                    String user = baseEntity.getContent().getMqtt().getUser();
                    String pwd = baseEntity.getContent().getMqtt().getPass();
                    MqttManager.get().connect(host, clientId, port, user, pwd);
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().loginYD(mEntitySubscriber, jwt_token);
    }

    public static void AppAidReq(String appUid, String appEnvid, String token, CallBack<AppAidEntity> callBack) {
        Subscriber<AppAidEntity> mEntitySubscriber = new Subscriber<AppAidEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppAidEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppAidReq(mEntitySubscriber, appUid, appEnvid, token);
    }

    public static void AppBarcodeReq(String appUid, String appEnvid, String aid, String token, String ssid, String password, CallBack<AppBarcodeReqEntity> callBack) {
        Subscriber<AppBarcodeReqEntity> mEntitySubscriber = new Subscriber<AppBarcodeReqEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppBarcodeReqEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppBarcodeReq(mEntitySubscriber, appUid, appEnvid, aid, token, ssid, password);
    }

    public static void DevScanBarcodeReq(String scan_token, String appAk, long timestamp, String nonce, String sign, String sn, String mac, String imei, String product, String version, String network_type, String wifi_ssid, String wifi_password, String config, CallBack<DevScanBarcodeEntity> callBack) {
        Subscriber<DevScanBarcodeEntity> mEntitySubscriber = new Subscriber<DevScanBarcodeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(DevScanBarcodeEntity baseEntity) {
                if (baseEntity.getErrcode() == 1002) {
                    callBack.onSuccess(baseEntity);
                } else if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().DevScanBarcodeReq(mEntitySubscriber, scan_token, appAk, timestamp, nonce, sign, sn, mac, imei, product, version, network_type, wifi_ssid, wifi_password, config);
    }

    public static void DevLogoutReq(String devUid, String token, CallBack<AppUnSubscribeEntity> callBack) {
        Subscriber<AppUnSubscribeEntity> mEntitySubscriber = new Subscriber<AppUnSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppUnSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().DevLogoutReq(mEntitySubscriber, devUid, token);
    }

    public static void DevLoginReq(String dev_uid, String password, CallBack<DevLoginEntity> callBack) {
        Subscriber<DevLoginEntity> mEntitySubscriber = new Subscriber<DevLoginEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(DevLoginEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().DevLoginReq(mEntitySubscriber, dev_uid, password);
    }

    public static void AppQueryAidBindReq(String app_uid, String app_envid, String app_aid, String token, CallBack<AppQueryAidBindEntity> callBack) {
        Subscriber<AppQueryAidBindEntity> mEntitySubscriber = new Subscriber<AppQueryAidBindEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppQueryAidBindEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppQueryAidBindReq(mEntitySubscriber, app_uid, app_envid, app_aid, token);
    }

    public static void AppRemoveAidReq(String appUid, String appEnvid, String token, String appAid, CallBack<AppRemoveAidEntity> callBack) {
        Subscriber<AppRemoveAidEntity> mEntitySubscriber = new Subscriber<AppRemoveAidEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppRemoveAidEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppRemoveAidReq(mEntitySubscriber, appUid, appEnvid, token, appAid);
    }

    public static void AppShareDeviceReq(String appUid, String appEnvid, String appAid, String token, String devUid, CallBack<AppShareDeviceEntity> callBack) {
        Subscriber<AppShareDeviceEntity> mEntitySubscriber = new Subscriber<AppShareDeviceEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppShareDeviceEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppShareDeviceReq(mEntitySubscriber, appUid, appEnvid, appAid, token, devUid);
    }

    public static void LoginByWeChat(String appUid, String appEnvid, String subscribe_type, String weixin_code, String push_id, String type, CallBack<AppSubscribeEntity> callBack) {
        Subscriber<AppSubscribeEntity> mEntitySubscriber = new Subscriber<AppSubscribeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppSubscribeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrcode() + "");
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().LoginByWeChat(mEntitySubscriber, appUid, appEnvid, subscribe_type, weixin_code, push_id, type);
    }

    public static void AppBindWeixinReq(String appUid, String appEnvid, String phoneNumber, String verifyCode, String weixin_code, CallBack<AppBindWeixinEntity> callBack) {
        Subscriber<AppBindWeixinEntity> mEntitySubscriber = new Subscriber<AppBindWeixinEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                Log.i("AppBindWeixinReq", "onError " + e.toString());
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppBindWeixinEntity baseEntity) {
                Log.i("AppBindWeixinReq", "onNext " + baseEntity.toString());
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppBindWeixinReq(mEntitySubscriber, appUid, appEnvid, phoneNumber, verifyCode, weixin_code);
    }

    public static void DevUploadFileReq(String dev_uid, String token, String src_filename, String msg_type, String file_type, String from_where, String from_id, String url, CallBack<BaseAppEntity> callBack) {
        Subscriber<BaseAppEntity> mEntitySubscriber = new Subscriber<BaseAppEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BaseAppEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().DevUploadFileReq(mEntitySubscriber, dev_uid, token, src_filename, msg_type, file_type, from_where, from_id, url);
    }

    public static void CallOwnerReq(String devUid, String token, CallBack<BaseAppEntity> callBack) {
        Subscriber<BaseAppEntity> mEntitySubscriber = new Subscriber<BaseAppEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BaseAppEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().CallOwnerReq(mEntitySubscriber, devUid, token);
    }

    public static void AppReceiveShareReq(String appUid, String appEnvid, String token, String receive_type, String share_num, String share_token, CallBack<AppReceiveShareEntity> callBack) {
        Subscriber<AppReceiveShareEntity> mEntitySubscriber = new Subscriber<AppReceiveShareEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppReceiveShareEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppReceiveShareReq(mEntitySubscriber, appUid, appEnvid, token, receive_type, share_num, share_token);
    }

    public static void AppReceiveShareNumReq(String appUid, String appEnvid, String token, String receive_type, String share_num, String share_token, CallBack<AppReceiveShareNumEntity> callBack) {
        Subscriber<AppReceiveShareNumEntity> mEntitySubscriber = new Subscriber<AppReceiveShareNumEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppReceiveShareNumEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppReceiveShareNumReq(mEntitySubscriber, appUid, appEnvid, token, receive_type, share_num, share_token);
    }

    public static void AppChangePasswordReq(String appUid, String appEnvid, String token, String old_password, String new_password, CallBack<AppChangePasswordEntity> callBack) {
        Subscriber<AppChangePasswordEntity> mEntitySubscriber = new Subscriber<AppChangePasswordEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppChangePasswordEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppChangePasswordReq(mEntitySubscriber, appUid, appEnvid, token, old_password, new_password);
    }

    public static void AppResetPasswordByPhoneReq(String appUid, String appEnvid, String phone_num, String verify_code, String password, CallBack<AppResetPasswordByPhoneEntity> callBack) {
        Subscriber<AppResetPasswordByPhoneEntity> mEntitySubscriber = new Subscriber<AppResetPasswordByPhoneEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppResetPasswordByPhoneEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppResetPasswordByPhoneReq(mEntitySubscriber, appUid, appEnvid, phone_num, verify_code, password);
    }

    public static void AppChangeAccountInfoReq(String appUid, String appEnvid, String token, String email, String avatar, String push_id, String type, String nickname, CallBack<AppChangeAccountInfoEntity> callBack) {
        Subscriber<AppChangeAccountInfoEntity> mEntitySubscriber = new Subscriber<AppChangeAccountInfoEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppChangeAccountInfoEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppChangeAccountInfoReq(mEntitySubscriber, appUid, appEnvid, token, email, avatar, push_id, type, nickname);
    }

    public static void AppChangePhoneReq(String appUid, String appEnvid, String token, String old_phone_num, String old_verify_code, String new_phone_num, String new_verify_code, CallBack<AppChangePhoneEntity> callBack) {
        Subscriber<AppChangePhoneEntity> mEntitySubscriber = new Subscriber<AppChangePhoneEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppChangePhoneEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppChangePhoneReq(mEntitySubscriber, appUid, appEnvid, token, old_phone_num, old_verify_code, new_phone_num, new_verify_code);
    }

    public static void DevQueryTimeReq(String appAk, long timestamp, String nonce, String sign, CallBack<DevQueryTimeEntity> callBack) {
        Subscriber<DevQueryTimeEntity> mEntitySubscriber = new Subscriber<DevQueryTimeEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(DevQueryTimeEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().DevQueryTimeReq(mEntitySubscriber, appAk, timestamp, nonce, sign);
    }

    public static void AppRemoveSharedDeviceReq(String appUid, String appEnvid, String token, String appAid, CallBack<AppRemoveSharedDeviceEntity> callBack) {
        Subscriber<AppRemoveSharedDeviceEntity> mEntitySubscriber = new Subscriber<AppRemoveSharedDeviceEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(AppRemoveSharedDeviceEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AppRemoveSharedDeviceReq(mEntitySubscriber, appUid, appEnvid, token, appAid);
    }

    public static void PushMessageOwnerReq(String devUid, String token, String title, String content, int expire, CallBack<BaseAppEntity> callBack) {
        Subscriber<BaseAppEntity> mEntitySubscriber = new Subscriber<BaseAppEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BaseAppEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().PushMessageOwnerReq(mEntitySubscriber, devUid, token, title, content, expire);
    }

    public static void PushMessageOwnerReqIos(String devUid, String token, String title, String content, String sound, int expire, CallBack<BaseAppEntity> callBack) {
        Subscriber<BaseAppEntity> mEntitySubscriber = new Subscriber<BaseAppEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BaseAppEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().PushMessageOwnerReqIos(mEntitySubscriber, devUid, token, title, content, sound, expire);
    }

    public static void AccReadReq(String appUid, String appEnvid, String token, String devUid, CallBack<BaseAppEntity> callBack) {
        Subscriber<BaseAppEntity> mEntitySubscriber = new Subscriber<BaseAppEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BaseAppEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AccReadReq(mEntitySubscriber, appUid, appEnvid, token, devUid);
    }

    public static void AccDeleteReq(String appUid, String appEnvid, String token, String devUid, String accId, CallBack<BaseAppEntity> callBack) {
        Subscriber<BaseAppEntity> mEntitySubscriber = new Subscriber<BaseAppEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BaseAppEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AccDeleteReq(mEntitySubscriber, appUid, appEnvid, token, devUid, accId);
    }

    public static void AccCreateReq(String appUid, String appEnvid, String token, String devUid, String ydLockSn, String ydLockNickName, String ydLockMacAddress, String YDLockBtAddress, String ydLockDefaultName, String ydLockFirmVersion, String ydLockHwVersion, String config, CallBack<BaseAppEntity> callBack) {
        Subscriber<BaseAppEntity> mEntitySubscriber = new Subscriber<BaseAppEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BaseAppEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AccCreateReq(mEntitySubscriber, appUid, appEnvid, token, devUid, ydLockSn, ydLockNickName, ydLockMacAddress, YDLockBtAddress, ydLockDefaultName, ydLockFirmVersion, ydLockHwVersion, config);
    }

    public static void AccUpdateReq(String appUid, String appEnvid, String token, String devUid, String accId, String ydLockSn, String ydLockNickName, String ydLockMacAddress, String YDLockBtAddress, String ydLockDefaultName, String ydLockFirmVersion, String ydLockHwVersion, String config, CallBack<BaseAppEntity> callBack) {
        Subscriber<BaseAppEntity> mEntitySubscriber = new Subscriber<BaseAppEntity>() {

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
                callBack.onComplete();
            }

            @Override
            public void onNext(BaseAppEntity baseEntity) {
                if (baseEntity.getErrcode() != 0) {
                    callBack.onError(baseEntity.getErrmsg());
                    callBack.onComplete();
                } else {
                    callBack.onSuccess(baseEntity);
                }
            }
        };
        RetrofitUtil.getInstance().AccUpdateReq(mEntitySubscriber, appUid, appEnvid, token, devUid, accId, ydLockSn, ydLockNickName, ydLockMacAddress, YDLockBtAddress, ydLockDefaultName, ydLockFirmVersion, ydLockHwVersion, config);
    }
}
