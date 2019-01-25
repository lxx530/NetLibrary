# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# 设置混淆的压缩比率 0 ~ 7
-optimizationpasses 5
# 混淆时不使用大小写混合，混淆后的类名为小写
-dontusemixedcaseclassnames
# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses
# 指定不去忽略非公共库的成员
-dontskipnonpubliclibraryclassmembers
# 混淆时不做预校验
-dontpreverify
# 混淆时不记录日志
-verbose
# 忽略警告
-ignorewarning
# 代码优化
-dontshrink
# 不优化输入的类文件
-dontoptimize
# 保留注解不混淆
-keepattributes *Annotation*,InnerClasses
# 避免混淆泛型
-keepattributes Signature
# 保留代码行号，方便异常信息的追踪
-keepattributes SourceFile,LineNumberTable
# 混淆采用的算法
-optimizations !code/simplification/cast,!field/*,!class/merging/*

# dump.txt文件列出apk包内所有class的内部结构
-dump class_files.txt
# seeds.txt文件列出未混淆的类和成员
-printseeds seeds.txt
# usage.txt文件列出从apk中删除的代码
-printusage unused.txt
# mapping.txt文件列出混淆前后的映射
-printmapping mapping.txt

#不需要混淆的Android类
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.preference.Preference
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.annotation.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class java.** { *; }
-keep public class javax.** { *; }
-keep public class com.android.vending.licensing.ILicensingService
-keep class android.support.** {*;}

#support-v4
-dontwarn android.support.v4.**
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep class android.support.v4.** { *; }

#support-v7
-dontwarn android.support.v7.**
-keep class android.support.v7.internal.** { *; }
-keep interface android.support.v7.internal.** { *; }
-keep class android.support.v7.** { *; }

#关闭 Log
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
    public static *** e(...);
    public static *** w(...);
}

#避免资源混淆
-keep class **.R$* {*;}

#避免Serializable接口的子类中指定的某些成员变量和方法混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-keep class okio.** { *;}
-keep class okhttp3.** { *;}
-dontwarn okio.**

# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# RxJava RxAndroid
-dontwarn rx.*
-keep class rx.**{*;}
-keep class retrofit2.converter.gson.**{*;}
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

# Gson
-keep class com.google.gson.** {*;}
-keep class com.google.**{*;}
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }

# EventBus
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

# mqtt
-keep class org.eclipse.paho.android.service.** {*;}
-keep class org.eclipse.paho.client.mqttv3.** {*;}

# glide
-keep class com.bumptech.glide.** {*;}
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

#SDK保留对外暴露接口类
-keep public class com.comaiot.net.library.phone.inter.YDInterfaceEntity{*;}
-keep public class com.comaiot.net.library.device.view.ComaiotView{*;}
-keep public class com.comaiot.net.library.phone.okhttp.OkHttpCallback{*;}
-keep public class com.comaiot.net.library.phone.view.AppSubscribeReqView{*;}
-keep public class com.comaiot.net.library.phone.view.AppUnSubscribeReqView{*;}
-keep public class com.comaiot.net.library.phone.view.AppRemoveAidReqView{*;}
-keep public class com.comaiot.net.library.phone.bean.**{*;}
-keep public class com.comaiot.net.library.phone.bean.**$*{*;}
-keep public class com.comaiot.net.library.phone.view.AccUpdateReqView{*;}
-keep public class com.comaiot.net.library.phone.view.AccCreateReqView{*;}
-keep public class com.comaiot.net.library.phone.view.AccDeleteReqView{*;}
-keep public class com.comaiot.net.library.phone.view.AccReadReqView{*;}
-keep public class com.comaiot.net.library.phone.view.AppReceiveShareReqView{*;}
-keep public class com.comaiot.net.library.phone.view.AppBarcodeReqView{*;}
-keep public class com.comaiot.net.library.phone.view.OnCatMessageArriveListener{*;}
-keep public class com.comaiot.net.library.phone.inter.MqttManager.SendSocketMessageCallBack{*;}
-keep public class com.comaiot.net.library.phone.view.AppQueryAidBindRquView{*;}
-keep public class com.comaiot.net.library.phone.view.SocketConnectionListener{*;}
-keep public class com.comaiot.net.library.phone.json_bean.YDLoginParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AppQueryDeviceListParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AppUnSubscribeParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AppShareDeviceParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AppBarcodeParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AppRemoveAidParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AccReadParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AccDeleteParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AccCreateParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AccUpdateParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AppQueryAidBindParams{*;}
-keep public class com.comaiot.net.library.phone.json_bean.AppReceiveShareParams{*;}
-keep public class * implements com.comaiot.net.library.phone.bean.BaseAppEntity{*;}
-keepclassmembers class com.comaiot.net.library.phone.inter.YDInterfaceEntity{*;}


