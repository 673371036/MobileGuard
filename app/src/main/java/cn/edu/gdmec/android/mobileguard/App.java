package cn.edu.gdmec.android.mobileguard;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Administrator on 2017/10/19.
 */

public class App extends Application {
    public void onCreate(){
        super.onCreate();
        correctSIM();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        correctSIM();
    }
    public void correctSIM() {
        SharedPreferences sp = getSharedPreferences("config", Context.MODE_PRIVATE);
        boolean protecting = sp.getBoolean("protecting",true);

       if (protecting) {
            //检查SIM卡是否发生变化
            String bindsim = sp.getString("sim","");
            //得到手机现在的SIM卡号
            TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
            //为了测试手机序列号上数据，已模拟SIM卡被更换的情况
            String realsim = tm.getSimSerialNumber();
            //因为虚拟机无法更换SIM卡，所以使用虚拟机test要有此行代码
            realsim = "999";
            if (bindsim.equals(realsim)) {
                Log.i("","SIM卡未发生变化，还是你的手机");
            }else{
                Log.i("","SIM卡发生了变化");
                String safenumber = sp.getString("safephone","");
                if (!TextUtils.isEmpty(safenumber)) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(safenumber,null,"你的亲友手机的SIM卡已经被更换！",null,null);
                }
            }
        }
    }
}
