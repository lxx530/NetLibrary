package com.comaiot.net.library.phone.inter;

import android.content.Context;

import com.comaiot.net.library.device.bean.AlarmEntity;
import com.comaiot.net.library.device.bean.AppControlDevice;
import com.comaiot.net.library.device.bean.CmdInfo;
import com.comaiot.net.library.device.bean.DeviceStatusChangeEntity;
import com.comaiot.net.library.device.bean.GetDeviceStatusEntity;
import com.comaiot.net.library.device.bean.OnlineEntity;
import com.comaiot.net.library.device.bean.OpenVideoEntity;
import com.comaiot.net.library.device.bean.SetDeviceSettingEntity;
import com.comaiot.net.library.device.controller.ComaiotController;
import com.comaiot.net.library.device.utils.GsonUtils;
import com.comaiot.net.library.device.utils.RetrofitUtil;
import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.phone.bean.AppAidEntity;
import com.comaiot.net.library.phone.bean.BaseAppEntity;
import com.comaiot.net.library.phone.bean.DeviceEntity;
import com.comaiot.net.library.phone.view.AccCreateReqView;
import com.comaiot.net.library.phone.json_bean.AppQueryDeviceListParams;
import com.comaiot.net.library.phone.okhttp.OkHttpCallback;
import com.comaiot.net.library.phone.okhttp.OkHttpUtils;
import com.comaiot.net.library.phone.view.AccDeleteReqView;
import com.comaiot.net.library.phone.view.AccReadReqView;
import com.comaiot.net.library.phone.view.AccUpdateReqView;
import com.comaiot.net.library.phone.view.AppAidReqView;
import com.comaiot.net.library.phone.view.AppBarcodeReqView;
import com.comaiot.net.library.phone.view.AppQueryAidBindRquView;
import com.comaiot.net.library.phone.view.AppReceiveShareReqView;
import com.comaiot.net.library.phone.view.AppRemoveAidReqView;
import com.comaiot.net.library.phone.view.AppShareDeviceReqView;
import com.comaiot.net.library.phone.view.AppSubscribeReqView;
import com.comaiot.net.library.phone.view.AppUnSubscribeReqView;
import com.comaiot.net.library.phone.view.OnCatMessageArriveListener;
import com.comaiot.net.library.phone.view.SocketConnectionListener;

import java.util.List;

import static com.comaiot.net.library.phone.inter.MqttUtils.CONTROL_DEVICE;
import static com.comaiot.net.library.phone.inter.MqttUtils.DEVICE_ALARM;
import static com.comaiot.net.library.phone.inter.MqttUtils.DEVICE_OFFLINE;
import static com.comaiot.net.library.phone.inter.MqttUtils.DEVICE_ONLINE;
import static com.comaiot.net.library.phone.inter.MqttUtils.DEVICE_RESET;
import static com.comaiot.net.library.phone.inter.MqttUtils.DEVICE_STATUS_CHANGED;
import static com.comaiot.net.library.phone.inter.MqttUtils.GET_DEVICE_STATUS;
import static com.comaiot.net.library.phone.inter.MqttUtils.OPEN_VIDEO;
import static com.comaiot.net.library.phone.inter.MqttUtils.QOS;
import static com.comaiot.net.library.phone.inter.MqttUtils.QUERY_ONLINE;
import static com.comaiot.net.library.phone.inter.MqttUtils.SET_DEVICE_SETTING;

public class YDInterfaceEntity {
    private static YDInterfaceEntity mInstance;
    private static Context mContext;
    private static MqttManager mMqttManager;
    private final ComaiotController<ComaiotView> mComaiotController;

    private SocketConnectionListener mSocketListener;
    private OnCatMessageArriveListener mMqttListener;
    private List<DeviceEntity> mDevices;

    private YDInterfaceEntity() {
        mComaiotController = new ComaiotController<>();
    }

    /**
     * 初始化SDK
     *
     * @param context 上下文
     * @return YDInterfaceEntity
     */
    public static YDInterfaceEntity initSDK(Context context) {
        mContext = context;
        if (null == mInstance) {
            synchronized (YDInterfaceEntity.class) {
                if (null == mInstance)
                    mInstance = new YDInterfaceEntity();
            }
        }
        YDPreferences.init(context);
        mMqttManager = MqttManager.getInstance(mContext);
        RetrofitUtil.getInstance(mContext);
        return mInstance;
    }

    private boolean checkSDKInvalid() {
        boolean invalid = false;
        if (mComaiotController == null) {
            invalid = true;
            throw new RuntimeException("YDInterfaceEntity is not init");
        }
        return invalid;
    }

    /**
     * 绑定视图 View 进行网络请求之前（调用接口） 请先调用此方法
     *
     * @param comaiotView
     */
    public void attach(ComaiotView comaiotView) {
        checkSDKInvalid();
        mComaiotController.attachView(comaiotView);
    }

    /**
     * 解绑视图View 在View销毁时调用
     */
    public void destroy() {
        checkSDKInvalid();
        mComaiotController.detachView();
    }

    /**
     * 登陆猫眼系统
     *
     * @param jwt_token JSON Web Token
     * @param reqView   回调接口 onSubscribeSuccess
     */
    public void login(String jwt_token, AppSubscribeReqView reqView) {
        checkSDKInvalid();
        mComaiotController.loginYD(jwt_token, reqView);
    }

    /**
     * 获取猫眼设备列表
     *
     * @param callback 接口回调
     */
    public void getCatDeviceList(OkHttpCallback callback) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        AppQueryDeviceListParams params = new AppQueryDeviceListParams();
        params.setApp_uid(appUid);
        params.setApp_envid(appEnvid);
        params.setToken(token);
        String url = "api/v2/AppQueryDeviceListReq";
        OkHttpUtils.getInstance(mContext).post(params, url, callback);
    }

    /**
     * 退出猫眼系统
     *
     * @param reqView 接口回调 onUnSubscribeSuccess中将BaseAppEntity向下转型为AppUnSubscribeEntity
     */
    public void loginOut(AppUnSubscribeReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.YDLogOut(appUid, appEnvid, token, reqView);
    }

    /**
     * 分享猫眼设备 目前支持二维码和数字密码分享
     *
     * @param devUid  猫眼设备ID
     * @param reqView 接口回调 onAppShareDeviceReqSuccess中将BaseAppEntity向下转型为AppShareDeviceEntity
     */
    public void shareCatDevicePublic(String devUid, AppShareDeviceReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.AppAidReq(appUid, appEnvid, token, new AppAidReqView() {
            @Override
            public void onAppAidReqSuccess(BaseAppEntity baseAppEntity) {
                AppAidEntity entity = (AppAidEntity) baseAppEntity;
                mComaiotController.AppShareDeviceReq(appUid, appEnvid, entity.getContent().getAid(), token, devUid, reqView);
            }

            @Override
            public void showLoading() {

            }

            @Override
            public void hideLoading() {

            }

            @Override
            public void onRequestSuccess() {

            }

            @Override
            public void onRequestError(String errorMsg, String methodName) {
                reqView.onRequestError(errorMsg, methodName);
            }
        });
    }

    /**
     * 对猫眼设备进行配网 不支持5G WIFI网络 请自行筛选WIFI路由器的频率进行区分
     *
     * @param wifiName     WIFI名称
     * @param wifiPassword WIFI密码
     * @param reqView      接口回调 onAppBarcodeReqSuccess回调中将BaseAppEntity向下转型为AppBarcodeReqEntity
     */
    public void configCatDeviceNetWork(String wifiName, String wifiPassword, AppBarcodeReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.AppAidReq(appUid, appEnvid, token, new AppAidReqView() {
            @Override
            public void onAppAidReqSuccess(BaseAppEntity baseAppEntity) {
                AppAidEntity entity = (AppAidEntity) baseAppEntity;
                YDPreferences.get().saveBindAppAid(entity.getContent().getAid());
                mComaiotController.AppBarcodeReq(appUid, appEnvid, entity.getContent().getAid(), token, wifiName, wifiPassword, reqView);
            }

            @Override
            public void showLoading() {

            }

            @Override
            public void hideLoading() {

            }

            @Override
            public void onRequestSuccess() {

            }

            @Override
            public void onRequestError(String errorMsg, String methodName) {
                reqView.onRequestError(errorMsg, methodName);
            }
        });
    }

    /**
     * 删除/解绑 猫眼设备
     *
     * @param appAid  aid
     * @param reqView 接口回调 onAppRemoveAidReqSuccess中BaseAppEntity向下转型为AppRemoveAidEntity
     */
    public void deleteCatDevice(String appAid, AppRemoveAidReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.YDRemoveDevice(appUid, appEnvid, token, appAid, reqView);
    }

    /**
     * 获取猫眼设备下挂载的YD锁列表
     *
     * @param devUid  猫眼设备ID
     * @param reqView 回调接口 onAccReadReqSuccess
     */
    public void getYDLockList(String devUid, AccReadReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.AccReadReq(appUid, appEnvid, token, devUid, reqView);
    }

    /**
     * 移除YD锁关联 （解除猫眼设备与YD锁的绑定状态）
     *
     * @param devUid  猫眼设备ID
     * @param accId   YD锁ID
     * @param reqView 回调接口 onAccDeleteReqSuccess
     */
    public void YDLockRemove(String devUid, String accId, AccDeleteReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.AccDeleteReq(appUid, appEnvid, token, devUid, accId, reqView);
    }

    /**
     * YD锁关联猫眼设备
     *
     * @param devUid            猫眼设备ID
     * @param YDLockSn          YD锁SN号
     * @param YDLockNickName    YD锁昵称
     * @param YDLockMacAddress  YD锁MAC地址
     * @param YDLockBtAddress   YD锁蓝牙地址
     * @param YDLockDefaultName YD锁名称
     * @param YDLockFirmVersion YD锁软件版本号
     * @param YDLockHwVersion   YD锁硬件版本号
     * @param config            YD锁 配置信息 以JSON字串类型上传 内容自定义
     * @param reqView           接口回调 onAccCreateReqSuccess
     */
    public void YDLockBindCatDevice(String devUid, String YDLockSn, String YDLockNickName, String YDLockMacAddress, String YDLockBtAddress, String YDLockDefaultName, String YDLockFirmVersion, String YDLockHwVersion, String config, AccCreateReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.AccCreateReq(appUid, appEnvid, token, devUid, YDLockSn, YDLockNickName, YDLockMacAddress, YDLockBtAddress, YDLockDefaultName, YDLockFirmVersion, YDLockHwVersion, config, reqView);
    }

    /**
     * 更新YD锁配置信息
     *
     * @param devUid            猫眼设备ID
     * @param accId             YD锁ID
     * @param YDLockSn          YD锁SN号
     * @param YDLockNickName    YD锁昵称
     * @param YDLockMacAddress  YD锁MAC地址
     * @param YDLockBtAddress   YD锁蓝牙地址
     * @param YDLockDefaultName YD锁名称
     * @param YDLockFirmVersion YD锁软件版本号
     * @param YDLockHwVersion   YD锁硬件版本号
     * @param config            YD锁 配置信息 以JSON字串类型上传 内容自定义
     * @param reqView           接口回调 onAccUpdateReqSuccess
     */
    public void YDLockUpdateDevice(String devUid, String accId, String YDLockSn, String YDLockNickName, String YDLockMacAddress, String YDLockBtAddress, String YDLockDefaultName, String YDLockFirmVersion, String YDLockHwVersion, String config, AccUpdateReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.AccUpdateReq(appUid, appEnvid, token, devUid, accId, YDLockSn, YDLockNickName, YDLockMacAddress, YDLockBtAddress, YDLockDefaultName, YDLockFirmVersion, YDLockHwVersion, config, reqView);
    }

    /**
     * 查询猫眼设备的绑定状态
     *
     * @param reqView 接口回调 onAppQueryAidBindReqSuccess中BaseAppEntity转型为AppQueryAidBindEntity
     */
    public void queryCatDeviceBindStatus(AppQueryAidBindRquView reqView) {
        checkSDKInvalid();
        String appAid = YDPreferences.get().getBindAppAid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        } else if (null == appAid) {
            throw new RuntimeException("please check the interface calling process is ok , is the [configCatDeviceNetWork] method is calling ?");
        }
        mComaiotController.AppQueryAidBindReq(appUid, appEnvid, appAid, token, reqView);
    }

    /**
     * 以扫描二维码方式加入到被分享设备组
     *
     * @param shareToken 二维码token
     * @param reqView    接口回调 onAppReceiveShareReqSuccess
     */
    public void joinCatDeviceSharePublicByQrCode(String shareToken, AppReceiveShareReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.AppReceiveShareReq(appUid, appEnvid, token, "barcode", null, shareToken, reqView);
    }

    /**
     * 以数字分享的方式加入到被分享设备组
     *
     * @param shareNumber 数字密码
     * @param reqView     接口回调 onAppReceiveShareNumReqSuccess
     */
    public void joinCatDeviceSharePublicByNumber(String shareNumber, AppReceiveShareReqView reqView) {
        checkSDKInvalid();
        String appUid = YDPreferences.get().getAppUid();
        String appEnvid = YDPreferences.get().getAppEnvid();
        String token = YDPreferences.get().getToken();
        if (checkParamsInvalid(appUid, appEnvid, token)) {
            throw new RuntimeException("please check the account's login status");
        }
        mComaiotController.AppReceiveShareNumReq(appUid, appEnvid, token, "num", shareNumber, null, reqView);
    }

    /**
     * 对消息通道进行监听 请在[login],[setCatDeviceMessageListener]方法之前调用
     *
     * @param listener    监听回调
     * @param deviceDatas 设备列表
     */
    public void setSocketConnectionListener(SocketConnectionListener listener, List<DeviceEntity> deviceDatas) {
        this.mSocketListener = listener;
        this.mDevices = deviceDatas;
        mMqttManager.setConnectionCallBack(new MqttManager.ConnectionHandlerCallBack() {
            @Override
            public void connectError(Exception e) {
                mSocketListener.onSocketConnectError(e);
            }

            @Override
            public void disconnect() {
                mSocketListener.onSocketDisconnect();
            }

            @Override
            public void connectComplete(boolean reconnect, String serverURI) {
                mSocketListener.onSocketConnectSuccess();
                if (null != mDevices) {
                    for (DeviceEntity entity : mDevices) {
                        if (!mMqttManager.isConnected()) {
                            throw new RuntimeException("please check the account's login status or check network");
                        } else {
                            mMqttManager.subscribeMsg(MqttUtils.getAppSubTopic(entity.getBindDeviceData().getDev_uid()), QOS);
                            mMqttManager.subscribeMsg(MqttUtils.getAppSubAppTopic(entity.getBindDeviceData().getDev_uid(), MqttManager.getInstance(mContext).getClientId()), QOS);
                            CmdInfo cmdInfo = new CmdInfo();
                            cmdInfo.setCmd(QUERY_ONLINE);
                            cmdInfo.setClientId(MqttManager.getInstance(mContext).getClientId());
                            String toJson = GsonUtils.toJson(cmdInfo);
                            mMqttManager.publish(MqttUtils.getAppPubAllTopic(entity.getBindDeviceData().getDev_uid()), toJson, false, QOS);
                        }
                    }
                }
            }
        });
    }

    /**
     * 对猫眼设备进行消息监听 请在[login]方法之前调用
     *
     * @param listener 监听回调
     */
    public void setCatDeviceMessageListener(OnCatMessageArriveListener listener) {
        this.mMqttListener = listener;
        mMqttManager.setMessageHandlerCallBack(new MqttManager.MessageHandlerCallBack() {
            @Override
            public void messageSuccess(String topicName, String msg) {
                if (null == mMqttListener)
                    throw new RuntimeException("please call [setCatDeviceMessageListener] method , MessageListener is NULL");
                CmdInfo cmdInfo = GsonUtils.fromJson(msg, CmdInfo.class);
                String cmd = cmdInfo.getCmd();
                if (cmd.equals(DEVICE_ONLINE)) {
                    mMqttListener.onCatDeviceOnline(cmdInfo.getDevUid());
                } else if (cmd.equals(DEVICE_STATUS_CHANGED)) {
                    DeviceStatusChangeEntity entity = GsonUtils.fromJson(msg, DeviceStatusChangeEntity.class);
                    mMqttListener.onCatDeviceStatusChanged(entity, cmdInfo.getDevUid());
                } else if (cmd.equals(QUERY_ONLINE)) {
                    mMqttListener.onCatDeviceOnline(cmdInfo.getDevUid());
                } else if (cmd.equals(GET_DEVICE_STATUS)) {
                    GetDeviceStatusEntity entity = GsonUtils.fromJson(msg, GetDeviceStatusEntity.class);
                    mMqttListener.onGetCatDeviceStatusSuccess(entity, cmdInfo.getDevUid());
                } else if (cmd.equals(DEVICE_RESET)) {
                    mMqttListener.onCatDeviceResetPrepare(cmdInfo.getDevUid());
                } else if (cmd.equals(SET_DEVICE_SETTING)) {
                    SetDeviceSettingEntity entity = GsonUtils.fromJson(msg, SetDeviceSettingEntity.class);
                    mMqttListener.onCatDeviceConfigComplete(entity, cmdInfo.getDevUid());
                } else if (cmd.equals(DEVICE_ALARM)) {
                    AlarmEntity uidEntity = GsonUtils.fromJson(msg, AlarmEntity.class);
                    mMqttListener.onCatDeviceAlarmArrived(uidEntity, cmdInfo.getDevUid());
                } else if (cmd.equals(CONTROL_DEVICE)) {
                    AppControlDevice controlDevice = GsonUtils.fromJson(msg, AppControlDevice.class);
                    mMqttListener.onCatDeviceControlComplete(controlDevice, cmdInfo.getDevUid());
                } else if (cmd.equals(DEVICE_OFFLINE)) {
                    mMqttListener.onCatDeviceOffline(cmdInfo.getDevUid());
                }
            }

            @Override
            public void connectComplete(boolean reconnect, String serverURI) {
                mSocketListener.onSocketConnectSuccess();
            }
        });
    }

    /**
     * 查看猫眼远程视频 （网络实时视频）
     *
     * @param devId    猫眼设备ID
     * @param callBack 消息发送成功
     */
    public void lookCatDeviceVideo(String devId, MqttManager.SendSocketMessageCallBack callBack) {
        CmdInfo cmdInfo = new CmdInfo();
        cmdInfo.setCmd(OPEN_VIDEO);
        cmdInfo.setClientId(MqttManager.getInstance(mContext).getClientId());
        String toJson = GsonUtils.toJson(cmdInfo);
        mMqttManager.publish(MqttUtils.getAppPubAllTopic(devId), toJson, false, QOS, callBack);
    }

    /**
     * 判断当前账号是否为主账号
     *
     * @param devUid 猫眼设备ID
     * @param appAid aid
     * @return 当前账号是否为主账号
     */
    public boolean isMasterAccount(String devUid, String appAid) {
        if (null == devUid) {
            throw new RuntimeException("this device is a invalid device , deviceId is NULL");
        } else if (null == appAid) {
            throw new RuntimeException("this account exception , account aid is NULL");
        }
        String substring = devUid.substring(devUid.indexOf("-") + 1, devUid.length());
        return substring.equals(appAid);
    }

    private boolean checkParamsInvalid(String... params) {
        boolean ret = false;
        for (String s : params) {
            if (null == s || s.isEmpty()) ret = true;
        }
        return ret;
    }
}
