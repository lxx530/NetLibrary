package com.comaiot.net.library.phone.okhttp;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.comaiot.net.library.device.controller.ComaiotController;
import com.comaiot.net.library.device.view.ComaiotView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logger {
    private static final boolean DEBUG = true;
    private static final String TAG = "Comaiot_Device";

    private static String logPath = null;//log日志存放路径

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);//日期格式;

    private static Date date = new Date();//因为log日志是使用日期命名的，使用静态成员变量主要是为了在整个程序运行期间只存在一个.log文件中;
    private static ComaiotController<ComaiotView> controller;

    /**
     * 初始化，须在使用之前设置，最好在Application创建时调用
     *
     * @param context
     */
    public static void init(Context context) {
        logPath = getFilePath(context) + "/Logs";//获得文件储存路径,在后面加"/Logs"建立子文件夹
    }

    /**
     * 获得文件存储路径
     *
     * @return
     */
    private static String getFilePath(Context context) {
        String filePath = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.MEDIA_MOUNTED) || !Environment.isExternalStorageRemovable()) {//如果外部储存可用
            filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Comaiot";//获得外部存储路径,默认路径为 /storage/emulated/0/Android/data/com.waka.workspace.logtofile/files/Logs/log_2016-03-14_16-15-09.log
        }
        return filePath;
    }

    public static void ii(String info) {
        writeToFile(INFO, TAG, info);
        if (DEBUG)
            Log.i(TAG, info);
    }

    public static void dd(String debug) {
        writeToFile('D', TAG, debug);
        if (DEBUG)
            Log.d(TAG, debug);
    }

    public static void ww(String warn) {
        writeToFile(WARN, TAG, warn);
        if (DEBUG)
            Log.w(TAG, warn);
    }

    public static void ee(String error) {
        writeToFile(ERROR, TAG, error);
        if (DEBUG)
            Log.e(TAG, error);
    }

    /**
     * 将log信息写入文件中
     *
     * @param type
     * @param tag
     * @param msg
     */
    protected static void writeToFile(char type, String tag, String msg) {

        if (null == logPath) {
            Log.e(TAG, "logPath == null ，未初始化Logger");
            return;
        }

        String fileName = logPath + "/log_Comaiot_device.log";//log日志名，使用时间命名，保证不重复

        String log = dateFormat.format(date) + " " + type + " " + tag + " " + msg + "\n";//log日志内容，可以自行定制

        //如果父路径不存在
        File file = new File(logPath);
        if (!file.exists()) {
            file.mkdirs();//创建父路径
        }

        FileOutputStream fos = null;//FileOutputStream会自动调用底层的close()方法，不用关闭
        BufferedWriter bw = null;
        try {

            fos = new FileOutputStream(fileName, true);//这里的第二个参数代表追加还是覆盖，true为追加，flase为覆盖
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(log);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();//关闭缓冲流
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static final char INFO = 'I';

    private static final char WARN = 'W';

    private static final char ERROR = 'E';

    public static String getLogFilePath() {
        return logPath + "/log_Comaiot_device.log";
    }
}
