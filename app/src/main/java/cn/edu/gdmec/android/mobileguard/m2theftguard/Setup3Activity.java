package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.edu.gdmec.android.mobileguard.R;

/**
 * Created by Administrator on 2017/10/16.
 */

public class Setup3Activity extends BaseSetUpActivity implements View.OnClickListener{
    private EditText mInputPhone;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cn.edu.gdmec.android.mobileguard.R.layout.activity_setup_3);
        ((RadioButton)findViewById(R.id.rb_third)).setChecked(true);

        ((RadioButton)findViewById(R.id.rb_third)).setChecked(true);
        findViewById(R.id.btn_addcontact).setOnClickListener(this);
        mInputPhone = (EditText)findViewById(R.id.et_inputphone);
        String safephone = sp.getString("safephone",null);
        if (!TextUtils.isEmpty(safephone)) {
            mInputPhone.setText(safephone);
        }
    }

    @Override
    public void showNext() {
        String safePhone = mInputPhone.getText().toString().trim();
        if (!TextUtils.isEmpty(safePhone)){
            Toast.makeText(this,"请输入安全号码",Toast.LENGTH_LONG).show();
            return;
        }
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("safephone",safePhone);
        edit.commit();
        startActivityFinishSelf (Setup4Activity.class);
    }

    @Override
    public void showPre() {

        startActivityFinishSelf (Setup2Activity.class);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_addcontact:
                //启动联系人选择activity并获取返回值
                startActivityForResult(new Intent(this,ContactSelectActivity.class),0);
                break;
        }
    }

    //获取被调用的activity的返回值
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(data != null) {
            String phone = data.getStringExtra("phone");
            mInputPhone.setText(phone);
        }
    }
}
