package atguigu.com.budejie.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2015/12/29.
 */
public class CacheUtils {
    /**
     * 保存软件参数
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences("budejie", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }
    /**
     * 得到软件保存的参数
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("budejie", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    /**
     * 数据缓存方法
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context, String key, String value) {
        //判断sdcar是否存在
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {
                String fileName = MD5Encoder.encode(key);//文件名
                // Environment.getExternalStorageDirectory() ==/mnt/sdcard
                File file = new File(Environment.getExternalStorageDirectory() + "/budejie", fileName);
                File parentfile = file.getParentFile();////mnt/sdcard/beijingnews/
                if (!parentfile.exists()) {
                    parentfile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(value.getBytes());
                fos.flush();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            SharedPreferences sp = context.getSharedPreferences("budejie", Context.MODE_PRIVATE);
            sp.edit().putString(key, value).commit();
        }
    }

    /**
     * 得到软件缓存的数据
     *
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String result = "";
            try {
                String fileName = MD5Encoder.encode(key);//文件名
                // Environment.getExternalStorageDirectory() ==/mnt/sdcard
                File file = new File(Environment.getExternalStorageDirectory() + "/budejie", fileName);
                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    int length = -1;
                    byte[] buffer = new byte[1024];
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    while ((length = fis.read(buffer)) != -1) {
                        baos.write(buffer, 0, length);
                    }
                    fis.close();
                    baos.flush();
                    baos.close();
                    result = baos.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        } else {
            SharedPreferences sp = context.getSharedPreferences("budejie", Context.MODE_PRIVATE);
            return sp.getString(key, "");
        }
    }
}
