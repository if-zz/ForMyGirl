package com.test.administrator.formygirl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/8/30.
 */
public class TitleLayout extends LinearLayout {
    public TitleLayout(final Context context,AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.main_title, this);
        Button titleBack=(Button)findViewById(R.id.title_back);
        Button more=(Button)findViewById(R.id.more);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        more.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((Activity) getContext()).findViewById(R.id.login)==null) {
                    Intent intent=new Intent((Activity)getContext(),MainActivity.class);
                    getContext().startActivity(intent);
                    ((Activity) getContext()).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                }
                else {
                    Toast.makeText(getContext(), "亲，别想多了，乖乖登录去～(￣▽￣～)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
