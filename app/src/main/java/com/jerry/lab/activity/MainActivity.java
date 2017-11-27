package com.jerry.lab.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jerry.lab.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_toOAA, btn_sendToastMSG, btn_forceOffline, btn_toFSA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        btn_toOAA = (Button) findViewById(R.id.btn_toOAA);
        btn_sendToastMSG = (Button) findViewById(R.id.btn_sendToastMSG);
        btn_forceOffline = (Button) findViewById(R.id.btn_forceOffline);
        btn_toFSA = (Button) findViewById(R.id.btn_toFSA);
    }

    private void initEvent() {
        btn_toOAA.setOnClickListener(this);
        btn_sendToastMSG.setOnClickListener(this);
        btn_forceOffline.setOnClickListener(this);
        btn_toFSA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toOAA:
                startActivity(new Intent(this, OtherAppActivity.class));
                break;
            case R.id.btn_sendToastMSG:
                Intent intent = new Intent("com.jerry.lab.TOAST_MSG_BROADCAST");
                sendBroadcast(intent);
                break;
            case R.id.btn_forceOffline:
                Intent i = new Intent("com.jerry.lab.FORCE_OFFLINE");
                sendBroadcast(i);
                break;
            case R.id.btn_toFSA:
                startActivity(new Intent(this, FileStorageActivity.class));
                break;
            default:
                break;
        }
    }
}
