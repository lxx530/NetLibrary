package com.comaiot.net.library.device.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;

import com.comaiot.net.library.device.bean.ArogaBean;
import com.comaiot.net.library.device.bean.BaiduOauthEntity;
import com.comaiot.net.library.device.bean.CheckPersonEntity;
import com.comaiot.net.library.device.bean.DevLoginEntity;
import com.comaiot.net.library.device.bean.DevQueryTimeEntity;
import com.comaiot.net.library.device.bean.DevScanBarcodeEntity;
import com.comaiot.net.library.device.bean.FaceverifyEntity;
import com.comaiot.net.library.device.bean.WeatherEntity;
import com.comaiot.net.library.device.inter.AgoraService;
import com.comaiot.net.library.device.inter.BaiDuApiService;
import com.comaiot.net.library.device.inter.BaiduOauthService;
import com.comaiot.net.library.device.inter.DeviceGetWeatherService;
import com.comaiot.net.library.device.json_bean.ArogaLicensesParams;
import com.comaiot.net.library.device.json_bean.DevLoginParams;
import com.comaiot.net.library.device.json_bean.DevLogoutParams;
import com.comaiot.net.library.device.json_bean.DevQueryTimeReqParams;
import com.comaiot.net.library.device.json_bean.DevScanBarcodeParams;
import com.comaiot.net.library.device.json_bean.DevUploadFileParams;
import com.comaiot.net.library.device.json_bean.PushMessageParams;
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
import com.comaiot.net.library.phone.inter.BaseUrl;
import com.comaiot.net.library.phone.inter.ComaiotService;
import com.comaiot.net.library.phone.inter.DESUtils;
import com.comaiot.net.library.phone.inter.StringUtils;
import com.comaiot.net.library.phone.inter.YDPreferences;
import com.comaiot.net.library.phone.json_bean.AccCreateParams;
import com.comaiot.net.library.phone.json_bean.AccDeleteParams;
import com.comaiot.net.library.phone.json_bean.AccReadParams;
import com.comaiot.net.library.phone.json_bean.AccUpdateParams;
import com.comaiot.net.library.phone.json_bean.AppBarcodeParams;
import com.comaiot.net.library.phone.json_bean.AppBindWeixinParams;
import com.comaiot.net.library.phone.json_bean.AppChangeAccountInfoParams;
import com.comaiot.net.library.phone.json_bean.AppChangePasswordParams;
import com.comaiot.net.library.phone.json_bean.AppChangePhoneParams;
import com.comaiot.net.library.phone.json_bean.AppQueryAidBindParams;
import com.comaiot.net.library.phone.json_bean.AppReceiveShareParams;
import com.comaiot.net.library.phone.json_bean.AppRemoveAidParams;
import com.comaiot.net.library.phone.json_bean.AppRemoveSharedDeviceParams;
import com.comaiot.net.library.phone.json_bean.AppResetPasswordByPhoneParams;
import com.comaiot.net.library.phone.json_bean.AppShareDeviceParams;
import com.comaiot.net.library.phone.json_bean.AppSubscribeParams;
import com.comaiot.net.library.phone.json_bean.AppUnSubscribeParams;
import com.comaiot.net.library.phone.json_bean.BindPhoneParams;
import com.comaiot.net.library.phone.json_bean.RegParams;
import com.comaiot.net.library.phone.json_bean.SmsParams;
import com.comaiot.net.library.phone.json_bean.StorageParams;
import com.comaiot.net.library.phone.json_bean.YDLoginParams;
import com.comaiot.net.library.phone.json_bean.YDRegParams;
import com.comaiot.net.library.phone.okhttp.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitUtil {

    private static final String AGORA_BASE_URL = "http://api.agora.io/dev/v1/";
    private static final String AGORA_LICENSES_URL = "https://api.agora.io/dev/v2/";
    private static final String BASE_URL = "https://free-api.heweather.com/";
    private static final String BAIDU_BASE_URL = "https://aip.baidubce.com/rest/2.0/face/v3/";
    private static final String BAIDU_OAUTH_URL = "https://aip.baidubce.com/oauth/2.0/";
    private static String COMAIOT_BASE_URL;

    private static final int DEFAULT_TIMEOUT = 15;
    private static Context mContext;

    private Retrofit mRetrofit;
    private Retrofit mBaiDuRetrofit;
    private Retrofit mOauthRetrofit;
    private Retrofit mComaiotRetrofit;
    private Retrofit mAgoraRetrofit;
    private Retrofit mAgoraLicensesRetrofit;

    private DeviceGetWeatherService mWeatherService;
    private BaiDuApiService mBaiduApiService;
    private BaiduOauthService mBaiduOauthService;
    private ComaiotService mComaiotService;
    private AgoraService mAgoraService;
    private AgoraService mAgoraLicensesService;

    private static RetrofitUtil mInstance;

    public static void getInstance(Context context) {
        mContext = context;
        String urlPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Comaiot/urlConfig/comaiot.txt";
        File file = new File(urlPath);
        if (!file.exists()) {
            try {
                File configDir = new File(file.getParent());
                if (!configDir.exists()) {
                    configDir.mkdirs();
                }
                file.createNewFile();
            } catch (IOException e) {
                Logger.ee("can not create url file " + e.toString());
            }
        } else {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(urlPath);
                byte[] buffer = new byte[256];
                fis.read(buffer);
                String configUrl = new String(buffer, "utf-8").trim();
                if (configUrl.isEmpty() || configUrl.length() > 50 || configUrl.length() < 10 || !configUrl.contains("http")) {
                    fis.close();
                } else {
                    BaseUrl.setBaseUrl(configUrl);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (null != fis)
                        fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        Logger.init(mContext);
        if (null == mInstance) {
            synchronized (Object.class) {
                if (null == mInstance) {
                    mInstance = new RetrofitUtil();
                }
            }
        }
    }

    public static String getBaseUrl() {
        return BaseUrl.getBaseUrl();
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static RetrofitUtil getInstance() {
        return mInstance;
    }

    private RetrofitUtil() {
        //-------------------------------Weather-------------------------------//
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .addHeader("Connection", "close")
                                .addHeader("Authorization", "APPCODE 0cf6d4b52f16455e8218a76c1e34e627")
                                .build();
                        Response proceed = chain.proceed(request);
                        return proceed;
                    }
                });
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        //------------------------------百度API-------------------------------//
        mBaiDuRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BAIDU_BASE_URL)
                .build();

        //------------------------------百度oauth-------------------------------//
        mOauthRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BAIDU_OAUTH_URL)
                .build();

        //-------------------------------Comaiot-----------------------------//
        mComaiotRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BaseUrl.getBaseUrl())
                .build();

        //------------------------------agora-------------------------------//
        String credentials = "7f6225d84839403a98ee1c0ed662c011:d8f227018cd44ca781772a5c011de4b0";
        final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        OkHttpClient.Builder arogaBuilder = new OkHttpClient.Builder()
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .addHeader("Authorization", basic)
                                .build();
                        return chain.proceed(request);
                    }
                });

        mAgoraRetrofit = new Retrofit.Builder()
                .client(arogaBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(AGORA_BASE_URL)
                .build();

        mAgoraLicensesRetrofit = new Retrofit.Builder()
                .client(arogaBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(AGORA_LICENSES_URL)
                .build();

        mWeatherService = mRetrofit.create(DeviceGetWeatherService.class);
        mBaiduApiService = mBaiDuRetrofit.create(BaiDuApiService.class);
        mBaiduOauthService = mOauthRetrofit.create(BaiduOauthService.class);
        mComaiotService = mComaiotRetrofit.create(ComaiotService.class);
        mAgoraService = mAgoraRetrofit.create(AgoraService.class);
        mAgoraLicensesService = mAgoraLicensesRetrofit.create(AgoraService.class);
    }

    /**
     * 默认信任所有的证书
     * TODO 最好加上证书认证，主流App都有自己的证书
     *
     * @return
     */
    @SuppressLint("TrulyRandom")
    private static SSLSocketFactory createSSLSocketFactory() {

        SSLSocketFactory sSLSocketFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllManager()},
                    new SecureRandom());
            sSLSocketFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return sSLSocketFactory;
    }

    private static class TrustAllManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)

                throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /**
     * 发送验证码
     *
     * @param subscriber
     */
    public void getWeather(Subscriber<WeatherEntity> subscriber) {
        String location = "auto_ip";
        String key = "44729d3edaf241a2a355ef153edd0062";
        mWeatherService.getWeather(location, key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * @param subscriber
     * @param ipAddress  ip地址
     */
    public void getWeatherByIp(Subscriber<WeatherEntity> subscriber, String ipAddress) {
        Logger.ee("getWeatherByIp start " + ipAddress);
        mWeatherService.getWeatherByIp(ipAddress)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void checkPersonFace(Subscriber<CheckPersonEntity> subscriber, String url, String image) {

        Map<String, Object> map = new HashMap<>();
        map.put("image", image);
        map.put("face_field", "faceshape,facetype");
        map.put("image_type", "BASE64");

        String param = GsonUtils.toJson(map);
        Logger.ee("checkPersonFace Json : \n" + param);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), param);

        mBaiduApiService.checkPersonFace(url, requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void faceverify(Subscriber<FaceverifyEntity> subscriber, String url, String image) {

        Map<String, Object> map = new HashMap<>();
        map.put("image", image);
        map.put("image_type", "BASE64");

        String param = GsonUtils.toJson(map);
        Logger.ee("faceverify Json : \n" + param);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), param);

        mBaiduApiService.faceverify(url, requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void baiduOauth(Subscriber<BaiduOauthEntity> subscriber, String client_id, String client_secret) {
        String grant_type = "client_credentials";
        mBaiduOauthService.BaiduOauthToken(grant_type, client_id, client_secret)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void queryAgoraSocketUserNumber(Subscriber<ArogaBean<ArogaBean.Data>> subscriber, String channelName) {
        String appId = "1dd34fa8e0f74327ba89927ceaf47691";
        mAgoraService.queryAgoraSocketUserNumber(appId, channelName)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void agoraLicenses(Subscriber<ArogaBean.Licenses> subscriber, String custom, String credential) {
        String appId = "1dd34fa8e0f74327ba89927ceaf47691";
        ArogaLicensesParams params = new ArogaLicensesParams();
        params.setCredential(credential);
        params.setCustom(custom);
        String json = GsonUtils.toJson(params);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        mAgoraLicensesService.agoraLicenses(appId, requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getStorageToken(Subscriber<StorageEntity> subscriber, String device_id, String device_token, String file_name) {
        StorageParams params = new StorageParams();
        params.setDevice_id(device_id);
        params.setDevice_token(device_token);
        params.setFile_name(file_name);
        String json = GsonUtils.toJson(params);
        Logger.ee("getStorageToken Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.getStorageToken(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void HeaderImageTokenReq(Subscriber<StorageEntity> subscriber, String appUid, String token, String file_name) {
        StorageParams params = new StorageParams();
        params.setDevice_id(appUid);
        params.setDevice_token(token);
        params.setFile_name(file_name);
        String json = GsonUtils.toJson(params);
        Logger.ee("getStorageToken Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.HeaderImageTokenReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void smsToPhone(Subscriber<SmsEntity> subscriber, String app_uid, String phone_num, String app_envid) {
        SmsParams params = new SmsParams();
        params.setApp_uid(app_uid);
        params.setPhone_num(phone_num);
        params.setApp_envid(app_envid);
        String json = GsonUtils.toJson(params);
        Logger.ee("smsToPhone Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.smsToPhone(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppReg(Subscriber<RegEntity> subscriber, String appak, long timestamp, String nonce, String sign, String brand, String type) {
        RegParams params = new RegParams();
        params.setAppak(appak);
        params.setTimestamp(timestamp);
        params.setNonce(nonce);
        params.setSign(sign);
        params.setBrand(brand);
        params.setType(type);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppReg Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppReg(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppReg(Subscriber<RegEntity> subscriber, String appak, long timestamp, String nonce, String sign, String brand, String type, String jwt) {
        YDRegParams params = new YDRegParams();
        params.setAppak(appak);
        params.setTimestamp(timestamp);
        params.setNonce(nonce);
        params.setSign(sign);
        params.setBrand(brand);
        params.setType(type);
        params.setJwt_token(jwt);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppReg Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppReg(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void bindPhone(Subscriber<BindPhoneEntity> subscriber, String appUid, String appEnvid, String phoneNumber, String verify_code, String pwd, String email) {
        BindPhoneParams params = new BindPhoneParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setPhone_num(phoneNumber);
        params.setVerify_code(verify_code);
        params.setPassword(pwd);
        params.setEmail(email);
        String json = GsonUtils.toJson(params);
        Logger.ee("bindPhone Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.bindPhone(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void LoginByPassword(Subscriber<AppSubscribeEntity> subscriber, String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type) {
        AppSubscribeParams params = new AppSubscribeParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setSubscribe_type(subscribe_type);
        params.setPhone_num(phoneNumber);
        params.setPassword(password);
        params.setPush_id(push_id);
        params.setType(type);
        String json = GsonUtils.toJson(params);
        Logger.ee("LoginByPassword Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.LoginByPassword(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppUnSubscribeReq(Subscriber<AppUnSubscribeEntity> subscriber, String appUid, String appEnvid, String token) {
        AppUnSubscribeParams params = new AppUnSubscribeParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);

        String json = GsonUtils.toJson(params);
        Logger.ee("AppUnSubscribeReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppUnSubscribeReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void LoginByPhone(Subscriber<AppSubscribeEntity> subscriber, String appUid, String appEnvid, String subscribe_type, String phoneNumber, String password, String push_id, String type) {
        AppSubscribeParams params = new AppSubscribeParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setSubscribe_type(subscribe_type);
        params.setPhone_num(phoneNumber);
        params.setVerify_code(password);
        params.setPush_id(push_id);
        params.setType(type);
        String json = GsonUtils.toJson(params);
        Logger.ee("LoginByPhone Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.LoginByPassword(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void loginYD(Subscriber<AppSubscribeEntity> subscriber, String jwt_token) {
        String appAk = DESUtils.decryptString(YDPreferences.get().getAppAk() + "==");
        long timestamp = System.currentTimeMillis() / 1000;
        String nonce = StringUtils.get_bit_string(6);
        String sign = StringUtils.sign(DESUtils.decryptString(YDPreferences.get().getAppSk() + "=="), timestamp, nonce);
        YDLoginParams params = new YDLoginParams();
        params.setAppak(appAk);
        params.setTimestamp(timestamp);
        params.setNonce(nonce);
        params.setSign(sign);
        params.setBrand(Build.BRAND);
        params.setType("Android");
        params.setJwt_token(jwt_token);
        params.setApp_uid(YDPreferences.get().getAppUid());
        params.setApp_envid(YDPreferences.get().getAppEnvid());
        String json = GsonUtils.toJson(params);
        Logger.ee("loginYD Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.loginYD(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppAidReq(Subscriber<AppAidEntity> subscriber, String appUid, String appEnvid, String token) {
        AppUnSubscribeParams params = new AppUnSubscribeParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppAidReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppAidReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppBarcodeReq(Subscriber<AppBarcodeReqEntity> subscriber, String appUid, String appEnvid, String aid, String token, String ssid, String password) {
        AppBarcodeParams params = new AppBarcodeParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        params.setApp_aid(aid);
        params.setWifi_ssid(ssid);
        params.setWifi_password(password);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppBarcodeReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppBarcodeReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void DevScanBarcodeReq(Subscriber<DevScanBarcodeEntity> subscriber, String scan_token, String appAk, long timestamp, String nonce, String sign, String sn, String mac, String imei, String product, String version, String network_type, String wifi_ssid, String wifi_password, String config) {
        DevScanBarcodeParams params = new DevScanBarcodeParams();
        params.setScan_token(scan_token);
        params.setAppak(appAk);
        params.setTimestamp(timestamp);
        params.setNonce(nonce);
        params.setSign(sign);
        params.setSn(sn);
        params.setMac(mac);
        params.setImei(imei);
        params.setProduct(product);
        params.setVersion(version);
        params.setNetwork_type(network_type);
        params.setWifi_ssid(wifi_ssid);
        params.setWifi_password(wifi_password);
        params.setConfig(config);
        String json = GsonUtils.toJson(params);
        Logger.ee("DevScanBarcodeReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.DevScanBarcodeReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void DevLogoutReq(Subscriber<AppUnSubscribeEntity> subscriber, String devUid, String token) {
        DevLogoutParams params = new DevLogoutParams();
        params.setDev_uid(devUid);
        params.setToken(token);
        String json = GsonUtils.toJson(params);
        Logger.ee("DevLogoutReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.DevLogoutReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void DevLoginReq(Subscriber<DevLoginEntity> subscriber, String dev_uid, String password) {
        DevLoginParams params = new DevLoginParams();
        params.setDev_uid(dev_uid);
        params.setPassword(password);
        String json = GsonUtils.toJson(params);
        Logger.ee("DevLoginReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.DevLoginReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppQueryAidBindReq(Subscriber<AppQueryAidBindEntity> subscriber, String app_uid, String app_envid, String app_aid, String token) {
        AppQueryAidBindParams params = new AppQueryAidBindParams();
        params.setApp_uid(app_uid);
        params.setApp_envid(app_envid);
        params.setApp_aid(app_aid);
        params.setToken(token);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppQueryAidBindReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppQueryAidBindReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppRemoveAidReq(Subscriber<AppRemoveAidEntity> subscriber, String appUid, String appEnvid, String token, String appAid) {
        AppRemoveAidParams params = new AppRemoveAidParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setApp_aid(appAid);
        params.setToken(token);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppRemoveAidReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppRemoveAidReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppShareDeviceReq(Subscriber<AppShareDeviceEntity> subscriber, String appUid, String appEnvid, String appAid, String token, String devUid) {
        AppShareDeviceParams params = new AppShareDeviceParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setApp_aid(appAid);
        params.setToken(token);
        params.setDev_uid(devUid);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppShareDeviceReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppShareDeviceReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void LoginByWeChat(Subscriber<AppSubscribeEntity> subscriber, String appUid, String appEnvid, String subscribe_type, String weixin_code, String push_id, String type) {
        AppSubscribeParams params = new AppSubscribeParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setSubscribe_type(subscribe_type);
        params.setWeixin_code(weixin_code);
        params.setPush_id(push_id);
        params.setType(type);
        String json = GsonUtils.toJson(params);
        Logger.ee("LoginByWeChat Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.LoginByWeChat(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppBindWeixinReq(Subscriber<AppBindWeixinEntity> subscriber, String appUid, String appEnvid, String phoneNumber, String verifyCode, String weixin_code) {
        AppBindWeixinParams params = new AppBindWeixinParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setPhone_num(phoneNumber);
        params.setVerify_code(verifyCode);
        params.setWeixin_code(weixin_code);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppBindWeixinReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppBindWeixinReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void DevUploadFileReq(Subscriber<BaseAppEntity> subscriber, String dev_uid, String token, String src_filename, String msg_type, String file_type, String from_where, String from_id, String url) {
        DevUploadFileParams params = new DevUploadFileParams();
        params.setDev_uid(dev_uid);
        params.setToken(token);
        params.setSrc_filename(src_filename);
        params.setMsg_type(msg_type);
        params.setFile_type(file_type);
        params.setFrom_where(from_where);
        params.setFrom_id(from_id);
        params.setUrl(url);
        String json = GsonUtils.toJson(params);
        Logger.ee("DevUploadFileReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.DevUploadFileReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void CallOwnerReq(Subscriber<BaseAppEntity> subscriber, String devUid, String token) {
        DevLogoutParams params = new DevLogoutParams();
        params.setDev_uid(devUid);
        params.setToken(token);

        String json = GsonUtils.toJson(params);
        Logger.ee("CallOwnerReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.CallOwnerReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppResetPasswordByPhoneReq(Subscriber<AppResetPasswordByPhoneEntity> subscriber, String appUid, String appEnvid, String phoneNumber, String verifyCode, String password) {
        AppResetPasswordByPhoneParams params = new AppResetPasswordByPhoneParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setPhone_num(phoneNumber);
        params.setVerify_code(verifyCode);
        params.setPassword(password);

        String json = GsonUtils.toJson(params);
        Logger.ee("AppResetPasswordByPhoneReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppResetPasswordByPhoneReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppReceiveShareReq(Subscriber<AppReceiveShareEntity> subscriber, String appUid, String appEnvid, String token, String receive_type, String share_num, String share_token) {
        AppReceiveShareParams params = new AppReceiveShareParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        params.setReceive_type(receive_type);
        params.setShare_num(share_num);
        params.setShare_token(share_token);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppReceiveShareReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppReceiveShareReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppReceiveShareNumReq(Subscriber<AppReceiveShareNumEntity> subscriber, String appUid, String appEnvid, String token, String receive_type, String share_num, String share_token) {
        AppReceiveShareParams params = new AppReceiveShareParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        params.setReceive_type(receive_type);
        params.setShare_num(share_num);
        params.setShare_token(share_token);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppReceiveShareNumReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppReceiveShareNumReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppChangePasswordReq(Subscriber<AppChangePasswordEntity> subscriber, String appUid, String appEnvid, String token, String old_password, String new_password) {
        AppChangePasswordParams params = new AppChangePasswordParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        params.setOld_password(old_password);
        params.setNew_password(new_password);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppChangePasswordReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppChangePasswordReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppChangeAccountInfoReq(Subscriber<AppChangeAccountInfoEntity> subscriber, String appUid, String appEnvid, String token, String email, String avatar, String push_id, String type, String nickname) {
        AppChangeAccountInfoParams params = new AppChangeAccountInfoParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        if (email != null && !email.equals(""))
            params.setEmail(email);
        params.setAvatar(avatar);
        params.setNickname(nickname);
        params.setPushId(push_id);
        params.setType(type);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppChangeAccountInfoReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppChangeAccountInfoReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppChangePhoneReq(Subscriber<AppChangePhoneEntity> subscriber, String appUid, String appEnvid, String token, String old_phone_num, String old_verify_code, String new_phone_num, String new_verify_code) {
        AppChangePhoneParams params = new AppChangePhoneParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        params.setOld_phone_num(old_phone_num);
        params.setOld_verify_code(old_verify_code);
        params.setNew_phone_num(new_phone_num);
        params.setNew_verify_code(new_verify_code);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppChangePhoneReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppChangePhoneReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void DevQueryTimeReq(Subscriber<DevQueryTimeEntity> subscriber, String appAk, long timestamp, String nonce, String sign) {
        DevQueryTimeReqParams params = new DevQueryTimeReqParams();
        params.setAppak(appAk);
        params.setTimestamp(timestamp);
        params.setNonce(nonce);
        params.setSign(sign);
        String json = GsonUtils.toJson(params);
        Logger.ee("DevQueryTimeReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.DevQueryTimeReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AppRemoveSharedDeviceReq(Subscriber<AppRemoveSharedDeviceEntity> subscriber, String appUid, String appEnvid, String token, String appAid) {
        AppRemoveSharedDeviceParams params = new AppRemoveSharedDeviceParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setApp_aid_remove(appAid);
        params.setToken(token);
        String json = GsonUtils.toJson(params);
        Logger.ee("AppRemoveSharedDeviceReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AppRemoveSharedDeviceReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void PushMessageOwnerReq(Subscriber<BaseAppEntity> subscriber, String devUid, String token, String title, String content, int expire) {
        PushMessageParams params = new PushMessageParams();
        params.setDev_uid(devUid);
        params.setToken(token);
        params.setTitle(title);
        params.setContent(content);
        params.setExpire(expire);
        String json = GsonUtils.toJson(params);
        Logger.ee("PushMessageOwnerReq Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.PushMessageOwnerReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void PushMessageOwnerReqIos(Subscriber<BaseAppEntity> subscriber, String devUid, String token, String title, String content, String sound, int expire) {
        PushMessageParams params = new PushMessageParams();
        params.setDev_uid(devUid);
        params.setToken(token);
        params.setTitle(title);
        params.setContent(content);
        params.setSound(sound);
        PushMessageParams.CustomContent customContent = new PushMessageParams.CustomContent();
        customContent.setOption(devUid);
        params.setCustomContent(new String(Base64.encode(customContent.toString().getBytes(), Base64.DEFAULT)));
        params.setExpire(expire);
        String json = GsonUtils.toJson(params);
        Logger.ee("PushMessageOwnerReqIos Json : \n" + json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.PushMessageOwnerReqIos(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AccReadReq(Subscriber<BaseAppEntity> subscriber, String appUid, String appEnvid, String token, String devUid) {
        AccReadParams params = new AccReadParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        params.setDev_uid(devUid);
        String json = GsonUtils.toJson(params);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AccReadReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AccDeleteReq(Subscriber<BaseAppEntity> subscriber, String appUid, String appEnvid, String token, String devUid, String accId) {
        AccDeleteParams params = new AccDeleteParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        params.setDev_uid(devUid);
        params.setAcc_id(accId);
        String json = GsonUtils.toJson(params);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AccDeleteReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AccCreateReq(Subscriber<BaseAppEntity> subscriber, String appUid, String appEnvid, String token, String devUid, String ydLockSn, String ydLockNickName, String ydLockMacAddress, String ydLockBtAddress, String ydLockDefaultName, String ydLockFirmVersion, String ydLockHwVersion, String config) {
        AccCreateParams params = new AccCreateParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        params.setDev_uid(devUid);
        params.setAcc_type("DoorLocker");
        params.setSn(ydLockSn);
        params.setAcc_linktype("Wifi");
        params.setAcc_name(ydLockNickName);
        params.setMac(ydLockMacAddress);
        params.setBt_addr(ydLockBtAddress);
        params.setProduct(ydLockDefaultName);
        params.setVersion(ydLockFirmVersion);
        params.setHw_version(ydLockHwVersion);
        params.setConfig(config);
        String json = GsonUtils.toJson(params);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AccCreateReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void AccUpdateReq(Subscriber<BaseAppEntity> subscriber, String appUid, String appEnvid, String token, String devUid, String accId, String ydLockSn, String ydLockNickName, String ydLockMacAddress, String ydLockBtAddress, String ydLockDefaultName, String ydLockFirmVersion, String ydLockHwVersion, String config) {
        AccUpdateParams params = new AccUpdateParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        params.setDev_uid(devUid);
        params.setAcc_id(accId);
        params.setAcc_type("DoorLocker");
        params.setAcc_linktype("Wifi");
        params.setAcc_name(ydLockNickName);
        params.setSn(ydLockSn);
        params.setMac(ydLockMacAddress);
        params.setBt_addr(ydLockBtAddress);
        params.setProduct(ydLockDefaultName);
        params.setVersion(ydLockFirmVersion);
        params.setHw_version(ydLockHwVersion);
        params.setConfig(config);
        String json = GsonUtils.toJson(params);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        mComaiotService.AccUpdateReq(requestBody)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
