package cn.edu.gdmec.android.mobileguard.m3communicationguard.entity;

/**
 * Created by Administrator on 2017/11/1.
 */
public class BlackContactInfo {

    public String phoneNumber;
    public String contactName;
    public String blackType;
    public int mode;
    public String getModeString(int mode){
        switch (mode){
            case 1:
                return "电话拦截";
            case 2:
                return  "短信拦截";
            case 3:
                return  "电话短信拦截";
        }
        return "";
    }


}
