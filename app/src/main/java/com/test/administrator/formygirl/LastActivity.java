package com.test.administrator.formygirl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/14.
 */
public class LastActivity extends Activity{
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content_frag);
        imageView=(ImageView)findViewById(R.id.news_img);
        textView=(TextView)findViewById(R.id.news_content);
        textView.setText("想什么呢，多读书，多看报，少吃零食多睡觉（不对，睡觉就免了）。\n" +
                         "要考试了，保持状态就行，俗话说：尽人事，听天命。随缘吧\n" +
                         "不过要逆天改命也不是不行哟O(∩_∩)O哈哈~");
        imageView.setImageResource(R.mipmap.p2);
    }
}
