package com.comaiot.net.library.phone.inter;

import android.content.Context;
import android.content.SharedPreferences;

public class YDPreferences {

    private static final String SP_NAME = "yd_pref_config";

    private Context mContext;
    private static YDPreferences mInstance;
    private SharedPreferences mSp;

    private YDPreferences(Context context) {
        this.mContext = context;
        mSp = mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (null == mInstance) {
            synchronized (YDPreferences.class) {
                if (null == mInstance) {
                    mInstance = new YDPreferences(context);
                }
            }
        }
    }

    public static YDPreferences get() {
        return mInstance;
    }

    private static final String APP_UID = "yd_phone_app_uid";
    private static final String APP_ENVID = "yd_phone_app_envid";
    private static final String APP_TOKEN = "yd_phone_app_token";
    private static final String BIND_AID = "yd_phone_app_bind_aid";
    private static final String SHARE_AID = "yd_phone_app_share_aid";

    public String getAppUid() {
        String string = mSp.getString(APP_UID, null);
        return DESUtils.decryptString(string);
    }

    public boolean saveAppUid(String uid) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(APP_UID, uid).commit();
    }

    public String getAppEnvid() {
        String string = mSp.getString(APP_ENVID, null);
        return DESUtils.decryptString(string);
    }

    public boolean saveAppEnvid(String envid) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(APP_ENVID, envid).commit();
    }

    public boolean saveToken(String token) {
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(APP_TOKEN, token).commit();
    }

    public String getToken() {
        String string = mSp.getString(APP_TOKEN, null);
        return DESUtils.decryptString(string);
    }

    public String getAppSk() {
        return "pchdUvmpU8TLR+071/niw6wfiSyjr2IUhqbIG1SsOd3LaBbpErvfNw";
    }

    public String getAppAk() {
        return "dxvf8BbWocrMeEPQLy4HUquv+MpuqNyoRicUoH/QomLLaBbpErvfNw";
    }

    public boolean saveBindAppAid(String aid) {
        aid = DESUtils.encryptString(aid);
        SharedPreferences.Editor editor = mSp.edit();
        return editor.putString(BIND_AID, aid).commit();
    }

    public String getBindAppAid() {
        String string = mSp.getString(BIND_AID, null);
        return DESUtils.decryptString(string);
    }
}
