package com.test.administrator.formygirl;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/25.
 */
public class SightsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView sightsTitleListView;
    private List<News> sightsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        sightsList=getNews();//初始化新闻数据
        adapter=new NewsAdapter(activity,R.layout.news_item,sightsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        sightsTitleListView=(ListView)view.findViewById(R.id.news_title_list_view);
        sightsTitleListView.setAdapter(adapter);
        sightsTitleListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane=true;//可以找到news_content_layout布局时，为双页模式

        }
        else {
            isTwoPane=false;//找不到news_content_layout布局时，为单页模式
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news=sightsList.get(position);
        if(isTwoPane){
            //如果是双页模式，则刷新NewsContentFragment中的内容
            SightsContentFragment sightsContentFragment=(SightsContentFragment)getFragmentManager()
                    .findFragmentById(R.id.sights_content_fragment);
            sightsContentFragment.refresh(news.getTitle(),news.getContent(),news.getImageId());
        }else {
            //如果是单页模式，则直接启动NewsContentActivity
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent(),news.getImageId());
        }
    }
    private List<News> getNews(){
        List<News> sightsList=new ArrayList<>();
        News news1=new News();
        news1.setTitle("");
        news1.setContent("当发现我的名字还可以缩写成if时，期待有人能同样看到。幸运的是，我没有错过第一个叫我if的人");
        news1.setImageId(R.mipmap.us3);
        sightsList.add(news1);
        News news4=new News();
        news4.setTitle("");
        news4.setContent("Sun for morning, moon for night and you for me");
        news4.setImageId(R.mipmap.us4);
        sightsList.add(news4);
        News news2=new News();
        news2.setTitle("");
        news2.setContent("而今，每一个新的一天都能陪你一起走过,从清晨到日暮");
        news2.setImageId(R.mipmap.us2);
        sightsList.add(news2);
        News news3=new News();
        news3.setTitle("");
        news3.setImageId(R.mipmap.us5);
        news3.setContent("从此，不念过去，不畏将来");
        sightsList.add(news3);
        return sightsList;
    }
}
