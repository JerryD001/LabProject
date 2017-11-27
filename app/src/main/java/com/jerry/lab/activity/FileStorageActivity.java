package com.jerry.lab.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jerry.lab.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileStorageActivity extends BaseActivity {

    private EditText et_StrToSave;
    private Button btn_read, btn_save;
    private TextView tv_fileContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);

        et_StrToSave = (EditText) findViewById(R.id.et_StrToSave);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_read = (Button) findViewById(R.id.btn_read);
        tv_fileContent = (TextView) findViewById(R.id.tv_fileContent);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = et_StrToSave.getText().toString().trim();
                save(data);
            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = read();
                tv_fileContent.setText(content);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private String read() {
        FileInputStream in;
        BufferedReader reader = null;
        StringBuffer content = new StringBuffer();

        try {
            in = openFileInput("runtimeData");
            reader = new BufferedReader(new InputStreamReader(in));
            String str;
            if ((str = reader.readLine()) != null) {
                content.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return content.toString();
    }

    private void save(String data) {
        FileOutputStream out;
        BufferedWriter writer = null;

        try {
            out = openFileOutput("runtimeData", Context.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
