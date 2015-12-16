package com.test.administrator.formygirl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/12/12.
 */
public class ContectActivity extends Activity{
    private Button contect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.contect_us);
        contect=(Button)findViewById(R.id.callme);
        contect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ContectActivity.this,"作者(太懒没实现这功能)更喜欢直接交流，快去骂他︿(￣︶￣)︿",Toast.LENGTH_LONG).show();
            }
        });
    }
}
