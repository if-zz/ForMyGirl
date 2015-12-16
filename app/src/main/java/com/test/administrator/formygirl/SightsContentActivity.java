package com.test.administrator.formygirl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2015/8/26.
 */
public class SightsContentActivity extends Activity {
    public static void actionStart(Context context,String newsTitle,String newsContent,int imageId){
        Intent intent=new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        intent.putExtra("news_img", imageId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle=getIntent().getStringExtra("news_title");//获取传入的新闻标题
        String newsContent=getIntent().getStringExtra("news_content");//获取传入的新闻内容
        int imageId=getIntent().getIntExtra("news_img",R.mipmap.ic_launcher);
        NewsContentFragment newsContentFragment=(NewsContentFragment)getFragmentManager()
                .findFragmentById(R.id.sights_content_fragment);
        newsContentFragment.refresh(newsTitle,newsContent,imageId);//刷新NewsContentFragment界面

    }
}
