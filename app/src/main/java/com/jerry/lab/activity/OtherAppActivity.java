package com.jerry.lab.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jerry.lab.R;

public class OtherAppActivity extends BaseActivity {

    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        tv_text = (TextView) findViewById(R.id.tv_text);

        Intent intent = getIntent();

        if (intent != null) {
            tv_text.setText(intent.getStringExtra("msg"));
        }
    }

    public void back(View view) {
        Intent intent = new Intent();
        intent.putExtra("result", "OK! I am back!");
        setResult(RESULT_OK, intent);
        finish();
    }
}
