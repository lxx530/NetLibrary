package com.comaiot.net.library.device.controller;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;

import com.comaiot.net.library.device.Model.ComaiotModel;
import com.comaiot.net.library.device.bean.ArogaBean;
import com.comaiot.net.library.device.bean.BaiduOauthEntity;
import com.comaiot.net.library.device.bean.CheckPersonEntity;
import com.comaiot.net.library.device.bean.DevLoginEntity;
import com.comaiot.net.library.device.bean.DevQueryTimeEntity;
import com.comaiot.net.library.device.bean.DevScanBarcodeEntity;
import com.comaiot.net.library.device.bean.FaceverifyEntity;
import com.comaiot.net.library.device.bean.PushEvent;
import com.comaiot.net.library.device.bean.WeatherEntity;
import com.comaiot.net.library.device.callback.CallBack;
import com.comaiot.net.library.device.utils.AppUtils;
import com.comaiot.net.library.device.view.AgoraLicensesView;
import com.comaiot.net.library.device.view.BaiduOauthView;
import com.comaiot.net.library.device.view.CallOwnerReqView;
import com.comaiot.net.library.device.view.CheckPersonFaceView;
import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.device.view.DevLoginReqView;
import com.comaiot.net.library.device.view.DevLogoutReqView;
import com.comaiot.net.library.device.view.DevQueryTimeReqView;
import com.comaiot.net.library.device.view.DevScanBarcodeReqView;
import com.comaiot.net.library.device.view.DevUploadFileReqView;
import com.comaiot.net.library.device.view.FaceverifyView;
import com.comaiot.net.library.device.view.GetIpWeatherView;
import com.comaiot.net.library.device.view.GetWeatherView;
import com.comaiot.net.library.device.view.PushMessageView;
import com.comaiot.net.library.device.view.QueryArogaUserView;
import com.comaiot.net.library.phone.bean.AppAidEntity;
import com.comaiot.net.library.phone.bean.AppBarcodeReqEntity;
import com.comaiot.net.library.phone.bean.AppBindWeixinEntity;
import com.comaiot.net.library.phone.bean.AppChangeAccountInfoEntity;
import com.comaiot.net.library.phone.bean.AppChangePasswordEntity;
import com.comaiot.net.library.phone.bean.AppChangePhoneEntity;
import com.comaiot.net.library.phone.bean.AppQueryAidBindEntity;
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
import com.comaiot.net.library.phone.inter.YDPreferences;
import com.comaiot.net.library.phone.view.AccCreateReqView;
import com.comaiot.net.library.phone.view.AccDeleteReqView;
import com.comaiot.net.library.phone.view.AccReadReqView;
import com.comaiot.net.library.phone.view.AccUpdateReqView;
import com.comaiot.net.library.phone.view.AppAidReqView;
import com.comaiot.net.library.phone.view.AppBarcodeReqView;
import com.comaiot.net.library.phone.view.AppBindWeixinReqView;
import com.comaiot.net.library.phone.view.AppChangeAccountInfoReqView;
import com.comaiot.net.library.phone.view.AppChangePasswordReqView;
import com.comaiot.net.library.phone.view.AppChangePhoneReqView;
import com.comaiot.net.library.phone.view.AppQueryAidBindRquView;
import com.comaiot.net.library.phone.view.AppReceiveShareReqView;
import com.comaiot.net.library.phone.view.AppRemoveAidReqView;
import com.comaiot.net.library.phone.view.AppRemoveSharedDeviceReqView;
import com.comaiot.net.library.phone.view.AppResetPasswordByPhoneReqView;
import com.comaiot.net.library.phone.view.AppShareDeviceReqView;
import com.comaiot.net.library.phone.view.AppSubscribeReqView;
import com.comaiot.net.library.phone.view.AppUnSubscribeReqView;
import com.comaiot.net.library.phone.view.AppWeChatSubscribeReqView;
import com.comaiot.net.library.phone.view.BindPhoneView;
import com.comaiot.net.library.phone.view.GetSmsView;
import com.comaiot.net.library.phone.view.GetStorageView;
import com.comaiot.net.library.phone.view.RegView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Logger;


public class ComaiotController<V extends ComaiotView> {

    // 持有 MVP 中 View 的引用
    private V iMvpView;


    public ComaiotController() {
    }

    public void attachView(V view) {
        this.iMvpView = view;
    }

    public void detachView() {
        this.iMvpView = null;
    }

    public boolean isViewAttached() {
        return iMvpView != null;
    }

    public V getView() {
        return iMvpView;
    }

    public void getWeather() {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.getWeather(new CallBack<WeatherEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "getWeather");
            }

            @Override
            public void onSuccess(WeatherEntity data) {
                if (isViewAttached())
                    ((GetWeatherView) iMvpView).onGetWeatherSuccess(data);
            }
        });
    }

    public void getWeatherByIp(final String ipAddress) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.getWeatherByIp(ipAddress, new CallBack<WeatherEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("Test", "getWeatherByIp onError " + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "getWeatherByIp");
            }

            @Override
            public void onSuccess(WeatherEntity data) {
                Log.e("Test", "getWeatherByIp onSuccess " + isViewAttached() + " " + data.toString());
                if (isViewAttached()) {
                    ((GetIpWeatherView) iMvpView).onGetIpWeatherSuccess(data);
                }
            }
        });
    }

    public void baiduOauth(final String client_id, String client_secret, boolean showLoading) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.baiduOauth(client_id, client_secret, new CallBack<BaiduOauthEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && showLoading)
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "baiduOauth");
            }

            @Override
            public void onSuccess(BaiduOauthEntity data) {
                if (isViewAttached())
                    ((BaiduOauthView) iMvpView).onBaiduOauthSuccess(data);
            }
        });
    }

    public void checkPersonFace(final String url, final String image, boolean showLoading) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.checkPersonFace(url, image, new CallBack<CheckPersonEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && showLoading)
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "checkPersonFace");
            }

            @Override
            public void onSuccess(CheckPersonEntity data) {
                if (isViewAttached())
                    ((CheckPersonFaceView) iMvpView).onCheckPersonFaceSuccess(data);
            }
        });
    }

    public void faceverify(final String url, final String image, boolean showLoading) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.faceverify(url, image, new CallBack<FaceverifyEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && showLoading)
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "faceverify");
            }

            @Override
            public void onSuccess(FaceverifyEntity data) {
                if (isViewAttached())
                    ((FaceverifyView) iMvpView).onFaceVerity(data);
            }
        });
    }

    public void getStorageToken(String device_id, String device_token, String file_name, String msg_type, String file_type, String from_where, String filePath, int msgType) {
        if (iMvpView instanceof Activity) {
            if (!AppUtils.isWifiConnected((Context) iMvpView)) {
                return;
            }
        } else if (iMvpView instanceof Fragment) {
            Fragment fragment = (Fragment) iMvpView;
            if (!AppUtils.isWifiConnected(fragment.getActivity())) {
                return;
            }
        }
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.getStorageToken(device_id, device_token, file_name, new CallBack<StorageEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "getStorageToken");
            }

            @Override
            public void onSuccess(StorageEntity data) {
                if (isViewAttached())
                    ((GetStorageView) iMvpView).onGetStorageToken(data, file_name, msg_type, file_type, from_where, filePath, msgType, -1);
            }
        });
    }

    public void queryAgoraSocketUserNumber(String channelName) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.queryAgoraSocketUserNumber(channelName, new CallBack<ArogaBean<ArogaBean.Data>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "queryAgoraSocketUserNumber");
            }

            @Override
            public void onSuccess(ArogaBean<ArogaBean.Data> data) {
                if (isViewAttached())
                    ((QueryArogaUserView) iMvpView).onQueryArogaUserNumberSucc(data);
            }
        });
    }

    public void agoraLicenses(String custom, String credential) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.agoraLicenses(custom,credential, new CallBack<ArogaBean.Licenses>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                Log.i("Comaiot_Device", "agoraLicenses onError " + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "agoraLicenses");
            }

            @Override
            public void onSuccess(ArogaBean.Licenses data) {
                Log.i("Comaiot_Device", "agoraLicenses onSuccess " + data.toString());
                if (isViewAttached())
                    ((AgoraLicensesView) iMvpView).onAgoraLicensesGetSuccess(data);
            }
        });
    }

    public void getStorageToken(String device_id, String device_token, String file_name, String msg_type, String file_type, String from_where, String filePath, int msgType, long createMsgTime) {
        if (!isViewAttached()) {
            Log.e("Comaiot_Device","getStorageToken but view is not BaseComaiotView and return");
            return;
        }
        ComaiotModel.getStorageToken(device_id, device_token, file_name, new CallBack<StorageEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "getStorageToken");
            }

            @Override
            public void onSuccess(StorageEntity data) {
                if (isViewAttached())
                    ((GetStorageView) iMvpView).onGetStorageToken(data, file_name, msg_type, file_type, from_where, filePath, msgType, createMsgTime);
            }
        });
    }

    public void HeaderImageTokenReq(String appUid, String token, String file_name, String filePath) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.HeaderImageTokenReq(appUid, token, file_name, new CallBack<StorageEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "HeaderImageTokenReq");
            }

            @Override
            public void onSuccess(StorageEntity data) {
                Log.e("Comaiot_App: ", "ComaiotController HeaderImageTokenReq onSuccess data: " + data + " filePath: " + filePath);
                if (isViewAttached())
                    ((GetStorageView) iMvpView).onGetStorageToken(data, filePath);
            }
        });
    }

    public void smsToPhone(String app_uid, String phone_num, String app_envid) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.smsToPhone(app_uid, phone_num, app_envid, new CallBack<SmsEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "smsToPhone");
            }

            @Override
            public void onSuccess(SmsEntity data) {
                if (isViewAttached())
                    ((GetSmsView) iMvpView).onSendSmsSuccess(data);
            }
        });
    }

    public void regYDSecretKey(String appak, long timestamp, String nonce, String sign, String brand, String type, RegView regView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppReg(appak, timestamp, nonce, sign, brand, type, new CallBack<RegEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    regView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    regView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    regView.onRequestError(msg, "regYDSecretKey");
            }

            @Override
            public void onSuccess(RegEntity data) {
                if (isViewAttached())
                    regView.onRegSuccess(data);
            }
        });
    }

    public void AppReg(String appak, long timestamp, String nonce, String sign, String brand, String type) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppReg(appak, timestamp, nonce, sign, brand, type, new CallBack<RegEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppReg");
            }

            @Override
            public void onSuccess(RegEntity data) {
                if (isViewAttached())
                    ((RegView) iMvpView).onRegSuccess(data);
            }
        });
    }

    public void bindPhone(String appUid, String appEnvid, String phoneNumber, String verify_code, String pwd, String email) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.bindPhone(appUid, appEnvid, phoneNumber, verify_code, pwd, email, new CallBack<BindPhoneEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "bindPhone");
            }

            @Override
            public void onSuccess(BindPhoneEntity data) {
                if (isViewAttached())
                    ((BindPhoneView) iMvpView).onBindPhoneResponse(data);
            }
        });
    }

    public void LoginByPassword(String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type) {
        if (!isViewAttached()) {
            return;
        }
        Log.e("LoginByPassword", "ComaiotController LoginByPassword push_id:" + push_id);
        ComaiotModel.LoginByPassword(appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type, new CallBack<AppSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("LoginByPassword", "ComaiotController LoginByPassword onError:" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "LoginByPassword");
            }

            @Override
            public void onSuccess(AppSubscribeEntity data) {
                Log.e("LoginByPassword", "ComaiotController LoginByPassword onSuccess:" + data.toString());
                if (isViewAttached())
                    ((AppSubscribeReqView) iMvpView).onSubscribeSuccess(data);
            }
        });
    }

    public void AppUnSubscribeReq(String appUid, String appEnvid, String token) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppUnSubscribeReq(appUid, appEnvid, token, new CallBack<AppUnSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppUnSubscribeReq");
            }

            @Override
            public void onSuccess(AppUnSubscribeEntity data) {
                if (isViewAttached())
                    ((AppUnSubscribeReqView) iMvpView).onUnSubscribeSuccess(data);
            }
        });
    }

    public void YDLogOut(String appUid, String appEnvid, String token, AppUnSubscribeReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppUnSubscribeReq(appUid, appEnvid, token, new CallBack<AppUnSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "YDLogOut");
            }

            @Override
            public void onSuccess(AppUnSubscribeEntity data) {
                if (isViewAttached()) {
                    YDPreferences.get().saveAppEnvid(null);
                    YDPreferences.get().saveAppUid(null);
                    YDPreferences.get().saveToken(null);
                    reqView.onUnSubscribeSuccess(data);
                }
            }
        });
    }

    public void LoginByPhone(String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.LoginByPhone(appUid, appEnvid, subscribe_type, phoneNumber, password, push_id, type, new CallBack<AppSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "LoginByPhone");
            }

            @Override
            public void onSuccess(AppSubscribeEntity data) {
                if (isViewAttached())
                    ((AppSubscribeReqView) iMvpView).onSubscribeSuccess(data);
            }
        });
    }

    public void loginYD(String jwt_token, final AppSubscribeReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.loginYD(jwt_token, new CallBack<AppSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "loginYD");
            }

            @Override
            public void onSuccess(AppSubscribeEntity data) {
                if (isViewAttached())
                    reqView.onSubscribeSuccess(data);
            }
        });
    }

    public void AppAidReq(String appUid, String appEnvid, String token) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppAidReq(appUid, appEnvid, token, new CallBack<AppAidEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppAidReq");
            }

            @Override
            public void onSuccess(AppAidEntity data) {
                if (isViewAttached())
                    ((AppAidReqView) iMvpView).onAppAidReqSuccess(data);
            }
        });
    }

    public void AppBarcodeReq(String appUid, String appEnvid, String aid, String token, String ssid, String password) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppBarcodeReq(appUid, appEnvid, aid, token, ssid, password, new CallBack<AppBarcodeReqEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppBarcodeReq");
            }

            @Override
            public void onSuccess(AppBarcodeReqEntity data) {
                if (isViewAttached())
                    ((AppBarcodeReqView) iMvpView).onAppBarcodeReqSuccess(data);
            }
        });
    }

    public void AppBarcodeReq(String appUid, String appEnvid, String aid, String token, String ssid, String password, AppBarcodeReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppBarcodeReq(appUid, appEnvid, aid, token, ssid, password, new CallBack<AppBarcodeReqEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "AppBarcodeReq");
            }

            @Override
            public void onSuccess(AppBarcodeReqEntity data) {
                if (isViewAttached())
                    reqView.onAppBarcodeReqSuccess(data);
            }
        });
    }

    public void DevScanBarcodeReq(String scan_token, String appAk, long timestamp, String nonce, String sign, String sn, String mac, String imei, String product, String version, String network_type, String wifi_ssid, String wifi_password, String config) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.DevScanBarcodeReq(scan_token, appAk, timestamp, nonce, sign, sn, mac, imei, product, version, network_type, wifi_ssid, wifi_password, config, new CallBack<DevScanBarcodeEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "DevScanBarcodeReq");
            }

            @Override
            public void onSuccess(DevScanBarcodeEntity data) {
                if (isViewAttached())
                    ((DevScanBarcodeReqView) iMvpView).onDevScanBarcodeReqSuccess(data);
            }
        });
    }

    public void DevLogoutReq(String devUid, String token) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.DevLogoutReq(devUid, token, new CallBack<AppUnSubscribeEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "DevLogoutReq");
            }

            @Override
            public void onSuccess(AppUnSubscribeEntity data) {
                if (isViewAttached())
                    ((DevLogoutReqView) iMvpView).onDevLogOutReqSuccess(data);
            }
        });
    }

    public void DevLoginReq(String dev_uid, String password) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.DevLoginReq(dev_uid, password, new CallBack<DevLoginEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "DevLoginReq");
            }

            @Override
            public void onSuccess(DevLoginEntity data) {
                if (isViewAttached())
                    ((DevLoginReqView) iMvpView).onDevLoginReqSuccess(data);
            }
        });
    }

    public void AppQueryAidBindReq(String app_uid, String app_envid, String app_aid, String token) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppQueryAidBindReq(app_uid, app_envid, app_aid, token, new CallBack<AppQueryAidBindEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppQueryAidBindReq");
            }

            @Override
            public void onSuccess(AppQueryAidBindEntity data) {
                if (isViewAttached())
                    ((AppQueryAidBindRquView) iMvpView).onAppQueryAidBindReqSuccess(data);
            }
        });
    }

    public void AppQueryAidBindReq(String app_uid, String app_envid, String app_aid, String token, AppQueryAidBindRquView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppQueryAidBindReq(app_uid, app_envid, app_aid, token, new CallBack<AppQueryAidBindEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "AppQueryAidBindReq");
            }

            @Override
            public void onSuccess(AppQueryAidBindEntity data) {
                if (isViewAttached())
                    reqView.onAppQueryAidBindReqSuccess(data);
            }
        });
    }

    public void AppRemoveAidReq(String appUid, String appEnvid, String token, String appAid) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppRemoveAidReq(appUid, appEnvid, token, appAid, new CallBack<AppRemoveAidEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppRemoveAidReq");
            }

            @Override
            public void onSuccess(AppRemoveAidEntity data) {
                if (isViewAttached())
                    ((AppRemoveAidReqView) iMvpView).onAppRemoveAidReqSuccess(data);
            }
        });
    }

    public void YDRemoveDevice(String appUid, String appEnvid, String token, String appAid, AppRemoveAidReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppRemoveAidReq(appUid, appEnvid, token, appAid, new CallBack<AppRemoveAidEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "YDRemoveDevice");
            }

            @Override
            public void onSuccess(AppRemoveAidEntity data) {
                if (isViewAttached())
                    reqView.onAppRemoveAidReqSuccess(data);
            }
        });
    }

    public void AppShareDeviceReq(String appUid, String appEnvid, String appAid, String token, String devUid) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppShareDeviceReq(appUid, appEnvid, appAid, token, devUid, new CallBack<AppShareDeviceEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppShareDeviceReq");
            }

            @Override
            public void onSuccess(AppShareDeviceEntity data) {
                if (isViewAttached())
                    ((AppShareDeviceReqView) iMvpView).onAppShareDeviceReqSuccess(data);
            }
        });
    }

    public void AppShareDeviceReq(String appUid, String appEnvid, String appAid, String token, String devUid, AppShareDeviceReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppShareDeviceReq(appUid, appEnvid, appAid, token, devUid, new CallBack<AppShareDeviceEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "AppShareDeviceReq");
            }

            @Override
            public void onSuccess(AppShareDeviceEntity data) {
                if (isViewAttached())
                    reqView.onAppShareDeviceReqSuccess(data);
            }
        });
    }

    public void LoginByWeChat(String appUid, String appEnvid, String subscribe_type, String weixin_code, String push_id, String type) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.LoginByWeChat(appUid, appEnvid, subscribe_type, weixin_code, push_id, type, new CallBack<AppSubscribeEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.d("LoginByWeChat", "ComaiotController LoginByWeChat onError " + msg.toString());
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "LoginByWeChat");
            }

            @Override
            public void onSuccess(AppSubscribeEntity data) {
                Log.d("LoginByWeChat", "ComaiotController LoginByWeChat onSuccess " + data.toString() + " appUid:" + appUid + " appEnvid:" + appEnvid + " weixin_code:" + weixin_code + "isViewAttached():" + isViewAttached());
                if (isViewAttached())
                    ((AppWeChatSubscribeReqView) iMvpView).onWeChatSubscribeSuccess(data, appUid, appEnvid, weixin_code);
            }
        });
    }

    public void AppBindWeixinReq(String appUid, String appEnvid, String phoneNumber, String verifyCode, String weixin_code) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppBindWeixinReq(appUid, appEnvid, phoneNumber, verifyCode, weixin_code, new CallBack<AppBindWeixinEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppBindWeixinReq");
            }

            @Override
            public void onSuccess(AppBindWeixinEntity data) {
                if (isViewAttached())
                    ((AppBindWeixinReqView) iMvpView).onAppBindWeixinReqSucc(data);
            }
        });
    }

    public void DevUploadFileReq(String dev_uid, String token, String src_filename, String msg_type, String file_type, String from_where, String from_id, String url) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.DevUploadFileReq(dev_uid, token, src_filename, msg_type, file_type, from_where, from_id, url, new CallBack<BaseAppEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "DevUploadFileReq");
            }

            @Override
            public void onSuccess(BaseAppEntity data) {
                if (isViewAttached())
                    ((DevUploadFileReqView) iMvpView).onDevUploadFileReqSucc(data);
            }
        });
    }

    public void CallOwnerReq(String devUid, String token, String msg_type) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.CallOwnerReq(devUid, token, new CallBack<BaseAppEntity>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "CallOwnerReq");
            }

            @Override
            public void onSuccess(BaseAppEntity data) {
                if (isViewAttached())
                    ((CallOwnerReqView) iMvpView).onCallOwnerReqSuccess(data, msg_type);
            }
        });
    }

    public void AppResetPasswordByPhoneReq(String appUid, String appEnvid, String phoneNumber, String verifyCode, String password) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppResetPasswordByPhoneReq(appUid, appEnvid, phoneNumber, verifyCode, password, new CallBack<AppResetPasswordByPhoneEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppResetPasswordByPhoneReq");
            }

            @Override
            public void onSuccess(AppResetPasswordByPhoneEntity data) {
                if (isViewAttached())
                    ((AppResetPasswordByPhoneReqView) iMvpView).onAppResetPasswordByPhoneReqSuccess(data);
            }
        });
    }

    public void AppReceiveShareReq(String appUid, String appEnvid, String token, String receive_type, String share_num, String share_token) {
        if (!isViewAttached()) {
            return;
        }

        ComaiotModel.AppReceiveShareReq(appUid, appEnvid, token, receive_type, share_num, share_token, new CallBack<AppReceiveShareEntity>() {
            @Override
            public void onStart() {
                Log.e("Test", "AppReceiveShareReq onStart");
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                Log.e("Test", "AppReceiveShareReq onComplete");
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("Test", "AppReceiveShareReq onError : \n" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppReceiveShareReq");
            }

            @Override
            public void onSuccess(AppReceiveShareEntity data) {
                Log.e("Test", "AppReceiveShareReq onSuccess");
                if (isViewAttached()) {
                    ((AppReceiveShareReqView) iMvpView).onAppReceiveShareReqSuccess(data);
                }
            }
        });
    }

    public void AppReceiveShareReq(String appUid, String appEnvid, String token, String receive_type, String share_num, String share_token, AppReceiveShareReqView reqView) {
        if (!isViewAttached()) {
            return;
        }

        ComaiotModel.AppReceiveShareReq(appUid, appEnvid, token, receive_type, share_num, share_token, new CallBack<AppReceiveShareEntity>() {
            @Override
            public void onStart() {
                Log.e("Test", "AppReceiveShareReq onStart");
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                Log.e("Test", "AppReceiveShareReq onComplete");
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("Test", "AppReceiveShareReq onError : \n" + msg);
                if (isViewAttached())
                    reqView.onRequestError(msg, "AppReceiveShareReq");
            }

            @Override
            public void onSuccess(AppReceiveShareEntity data) {
                Log.e("Test", "AppReceiveShareReq onSuccess");
                if (isViewAttached()) {
                    reqView.onAppReceiveShareReqSuccess(data);
                }
            }
        });
    }

    public void AppReceiveShareNumReq(String appUid, String appEnvid, String token, String receive_type, String share_num, String share_token) {
        if (!isViewAttached()) {
            return;
        }

        ComaiotModel.AppReceiveShareNumReq(appUid, appEnvid, token, receive_type, share_num, share_token, new CallBack<AppReceiveShareNumEntity>() {
            @Override
            public void onStart() {
                Log.e("Test", "AppReceiveShareNumReq onStart");
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                Log.e("Test", "AppReceiveShareNumReq onComplete");
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("Test", "AppReceiveShareNumReq onError : \n" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppReceiveShareNumReq");
            }

            @Override
            public void onSuccess(AppReceiveShareNumEntity data) {
                Log.e("Test", "AppReceiveShareNumReq onSuccess");
                if (isViewAttached()) {
                    ((AppReceiveShareReqView) iMvpView).onAppReceiveShareNumReqSuccess(data);
                }
            }
        });
    }

    public void AppReceiveShareNumReq(String appUid, String appEnvid, String token, String receive_type, String share_num, String share_token, AppReceiveShareReqView reqView) {
        if (!isViewAttached()) {
            return;
        }

        ComaiotModel.AppReceiveShareNumReq(appUid, appEnvid, token, receive_type, share_num, share_token, new CallBack<AppReceiveShareNumEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached() && null != reqView)
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached() && null != reqView)
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached() && null != reqView)
                    reqView.onRequestError(msg, "AppReceiveShareNumReq");
            }

            @Override
            public void onSuccess(AppReceiveShareNumEntity data) {
                if (isViewAttached() && null != reqView) {
                    reqView.onAppReceiveShareNumReqSuccess(data);
                }
            }
        });
    }

    public void AppChangePasswordReq(String appUid, String appEnvid, String token, String old_password, String new_password) {
        if (!isViewAttached()) {
            return;
        }

        ComaiotModel.AppChangePasswordReq(appUid, appEnvid, token, old_password, new_password, new CallBack<AppChangePasswordEntity>() {
            @Override
            public void onStart() {
                Log.e("Test", "AppChangePasswordReq onStart");
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                Log.e("Test", "AppChangePasswordReq onComplete");
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("Test", "AppChangePasswordReq onError : \n" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppChangePasswordReq");
            }

            @Override
            public void onSuccess(AppChangePasswordEntity data) {
                Log.e("Test", "AppChangePasswordReq onSuccess");
                if (isViewAttached()) {
                    ((AppChangePasswordReqView) iMvpView).onAppChangePasswordReqSuccess(data);
                }
            }
        });
    }

    public void AppChangeAccountInfoReq(String appUid, String appEnvid, String token, String email, String avatar, String push_id, String type, String nickname) {
        if (!isViewAttached()) {
            return;
        }

        ComaiotModel.AppChangeAccountInfoReq(appUid, appEnvid, token, email, avatar, push_id, type, nickname, new CallBack<AppChangeAccountInfoEntity>() {
            @Override
            public void onStart() {
                Log.e("Test", "AppChangeAccountInfoReq onStart");
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                Log.e("Test", "AppChangeAccountInfoReq onComplete");
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("Test", "AppChangeAccountInfoReq onError : \n" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppChangeAccountInfoReq");
            }

            @Override
            public void onSuccess(AppChangeAccountInfoEntity data) {
                Log.e("Test", "AppChangeAccountInfoReq onSuccess");
                if (isViewAttached()) {
                    ((AppChangeAccountInfoReqView) iMvpView).onAppChangeAccountInfoReqSuccess(data);
                }
            }
        });
    }

    public void AppChangePhoneReq(String appUid, String appEnvid, String token, String old_phone_num, String old_verify_code, String new_phone_num, String new_verify_code) {
        if (!isViewAttached()) {
            return;
        }

        ComaiotModel.AppChangePhoneReq(appUid, appEnvid, token, old_phone_num, old_verify_code, new_phone_num, new_verify_code, new CallBack<AppChangePhoneEntity>() {
            @Override
            public void onStart() {
                Log.e("Test", "AppChangePhoneReq onStart");
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                Log.e("Test", "AppChangePhoneReq onComplete");
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("Test", "AppChangePhoneReq onError : \n" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppChangePhoneReq");
            }

            @Override
            public void onSuccess(AppChangePhoneEntity data) {
                Log.e("Test", "AppChangePhoneReq onSuccess");
                if (isViewAttached()) {
                    ((AppChangePhoneReqView) iMvpView).onAppChangePhoneReqSuccess(data);
                }
            }
        });
    }

    public void DevQueryTimeReq(String appAk, long timestamp, String nonce, String sign) {
        if (!isViewAttached()) {
            return;
        }

        ComaiotModel.DevQueryTimeReq(appAk, timestamp, nonce, sign, new CallBack<DevQueryTimeEntity>() {
            @Override
            public void onStart() {
                Log.e("Comaiot_App_Tag", "DevQueryTimeReq onStart");
            }

            @Override
            public void onComplete() {
                Log.e("Comaiot_App_Tag", "DevQueryTimeReq onComplete");
            }

            @Override
            public void onError(String msg) {
                Log.e("Comaiot_App_Tag", "DevQueryTimeReq onError : \n" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "DevQueryTimeReq");
            }

            @Override
            public void onSuccess(DevQueryTimeEntity data) {
                Log.e("Comaiot_App_Tag", "DevQueryTimeReq onSuccess");
                if (isViewAttached()) {
                    ((DevQueryTimeReqView) iMvpView).onDevQueryTimeSuccess(data);
                }
            }
        });
    }

    public void AppRemoveSharedDeviceReq(String appUid, String appEnvid, String token, String appAid) {
        if (!isViewAttached()) {
            return;
        }

        ComaiotModel.AppRemoveSharedDeviceReq(appUid, appEnvid, token, appAid, new CallBack<AppRemoveSharedDeviceEntity>() {
            @Override
            public void onStart() {
                Log.e("Comaiot_App_Tag", "AppRemoveSharedDeviceReq onStart");
                if (isViewAttached())
                    iMvpView.showLoading();
            }

            @Override
            public void onComplete() {
                Log.e("Comaiot_App_Tag", "AppRemoveSharedDeviceReq onComplete");
                if (isViewAttached())
                    iMvpView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                Log.e("Comaiot_App_Tag", "AppRemoveSharedDeviceReq onError : \n" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "AppRemoveSharedDeviceReq");
            }

            @Override
            public void onSuccess(AppRemoveSharedDeviceEntity data) {
                Log.e("Comaiot_App_Tag", "AppRemoveSharedDeviceReq onSuccess");
                if (isViewAttached()) {
                    ((AppRemoveSharedDeviceReqView) iMvpView).onAppRemoveSharedDeviceSuccess(data);
                }
            }
        });
    }

    public void PushMessageOwnerReq(String devUid, String token, String title, String content, int expire) {
        if (!isViewAttached()) {
            return;
        }
        EventBus.getDefault().post(new PushEvent());
        ComaiotModel.PushMessageOwnerReq(devUid, token, title, content, expire, new CallBack<BaseAppEntity>() {
            @Override
            public void onStart() {
                Log.e("Comaiot_App_Tag", "PushMessageOwnerReq onStart");
            }

            @Override
            public void onComplete() {
                Log.e("Comaiot_App_Tag", "PushMessageOwnerReq onComplete");
            }

            @Override
            public void onError(String msg) {
                Log.e("Comaiot_App_Tag", "PushMessageOwnerReq onError : \n" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "PushMessageOwnerReq");
            }

            @Override
            public void onSuccess(BaseAppEntity data) {
                Log.e("Comaiot_App_Tag", "PushMessageOwnerReq onSuccess");
                if (isViewAttached()) {
                    ((PushMessageView) iMvpView).onPushMessageSuccess(data);
                }
            }
        });
    }

    public void PushMessageOwnerReqIos(String devUid, String token, String title, String content, int expire) {
        if (!isViewAttached()) {
            return;
        }
        EventBus.getDefault().post(new PushEvent());
        ComaiotModel.PushMessageOwnerReqIos(devUid, token, title, content, "pushcall.wav", expire, new CallBack<BaseAppEntity>() {
            @Override
            public void onStart() {
                Log.e("Comaiot_App_Tag", "PushMessageOwnerReqIos onStart");
            }

            @Override
            public void onComplete() {
                Log.e("Comaiot_App_Tag", "PushMessageOwnerReqIos onComplete");
            }

            @Override
            public void onError(String msg) {
                Log.e("Comaiot_App_Tag", "PushMessageOwnerReqIos onError : \n" + msg);
                if (isViewAttached())
                    iMvpView.onRequestError(msg, "PushMessageOwnerReqIos");
            }

            @Override
            public void onSuccess(BaseAppEntity data) {
                Log.e("Comaiot_App_Tag", "PushMessageOwnerReqIos onSuccess");
                if (isViewAttached()) {
                    ((PushMessageView) iMvpView).onPushMessageSuccess(data);
                }
            }
        });
    }

    public void AccReadReq(String appUid, String appEnvid, String token, String devUid, AccReadReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AccReadReq(appUid, appEnvid, token, devUid, new CallBack<BaseAppEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "AccReadReq");
            }

            @Override
            public void onSuccess(BaseAppEntity data) {
                if (isViewAttached()) {
                    reqView.onAccReadReqSuccess(data);
                }
            }
        });
    }

    public void AccDeleteReq(String appUid, String appEnvid, String token, String devUid, String accId, AccDeleteReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AccDeleteReq(appUid, appEnvid, token, devUid, accId, new CallBack<BaseAppEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "AccDeleteReq");
            }

            @Override
            public void onSuccess(BaseAppEntity data) {
                if (isViewAttached()) {
                    reqView.onAccDeleteReqSuccess(data);
                }
            }
        });
    }

    public void AccCreateReq(String appUid, String appEnvid, String token, String devUid, String ydLockSn, String ydLockNickName, String ydLockMacAddress, String YDLockBtAddress, String ydLockDefaultName, String ydLockFirmVersion, String ydLockHwVersion, String config, AccCreateReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AccCreateReq(appUid, appEnvid, token, devUid, ydLockSn, ydLockNickName, ydLockMacAddress, YDLockBtAddress, ydLockDefaultName, ydLockFirmVersion, ydLockHwVersion, config, new CallBack<BaseAppEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "AccCreateReq");
            }

            @Override
            public void onSuccess(BaseAppEntity data) {
                if (isViewAttached()) {
                    reqView.onAccCreateReqSuccess(data);
                }
            }
        });
    }

    public void AccUpdateReq(String appUid, String appEnvid, String token, String devUid, String accId, String ydLockSn, String ydLockNickName, String ydLockMacAddress, String YDLockBtAddress, String ydLockDefaultName, String ydLockFirmVersion, String ydLockHwVersion, String config, AccUpdateReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AccUpdateReq(appUid, appEnvid, token, devUid, accId, ydLockSn, ydLockNickName, ydLockMacAddress, YDLockBtAddress, ydLockDefaultName, ydLockFirmVersion, ydLockHwVersion, config, new CallBack<BaseAppEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "AccUpdateReq");
            }

            @Override
            public void onSuccess(BaseAppEntity data) {
                if (isViewAttached()) {
                    reqView.onAccUpdateReqSuccess(data);
                }
            }
        });
    }

    public void AppAidReq(String appUid, String appEnvid, String token, AppAidReqView reqView) {
        if (!isViewAttached()) {
            return;
        }
        ComaiotModel.AppAidReq(appUid, appEnvid, token, new CallBack<AppAidEntity>() {
            @Override
            public void onStart() {
                if (isViewAttached())
                    reqView.showLoading();
            }

            @Override
            public void onComplete() {
                if (isViewAttached())
                    reqView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached())
                    reqView.onRequestError(msg, "AppAidReq");
            }

            @Override
            public void onSuccess(AppAidEntity data) {
                if (isViewAttached())
                    reqView.onAppAidReqSuccess(data);
            }
        });
    }
}
