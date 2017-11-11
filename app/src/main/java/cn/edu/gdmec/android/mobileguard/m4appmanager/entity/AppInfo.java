package cn.edu.gdmec.android.mobileguard.m4appmanager.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by LWK on 2017/11/7.
 */

public class AppInfo {
    //应用程序包名
    public String packageName;
    //应用程序图标
    public Drawable icon;
    //应用程序名称
    public String appName;
    //应用程序路径
    public String apkPath;
    //应用程序大大小
    public long appSize;
    //是否是手机存储
    public boolean isInRoom;
    //是否是用户应用
    public boolean isUserApp;
    //是否选中，默认都为FALSE
    public boolean isSelected = false;
    public String version;
    public String InstallTime;
    public String signature;
    public String permissions;
    //拿到APP位置字符串
    public String getAppLocation(boolean isInRoom) {
        if (isInRoom) {
            return "手机内存";
        }else {
            return "外部存储";
        }
    }
}
