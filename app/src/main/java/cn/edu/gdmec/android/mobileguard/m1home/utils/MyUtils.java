package cn.edu.gdmec.android.mobileguard.m1home.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;



public class MyUtils {
    /*
    静态方法 获取当前版本号
     */
    public static String getVersion(Context context,String apkFile){
        PackageManager packageManager=context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            return " ";
        }
    }
}
