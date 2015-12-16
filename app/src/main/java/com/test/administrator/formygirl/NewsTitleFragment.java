package com.test.administrator.formygirl;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/17.
 */
//public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{
public class NewsTitleFragment extends Fragment{
    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList=getNews();//初始化新闻数据
        adapter=new NewsAdapter(activity,R.layout.news_item,newsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleListView=(ListView)view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        //newsTitleListView.setOnItemClickListener(this);
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

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        News news=newsList.get(position);
//        if(isTwoPane){
//            //如果是双页模式，则刷新NewsContentFragment中的内容
//            NewsContentFragment newsContentFragment=(NewsContentFragment)getFragmentManager()
//                    .findFragmentById(R.id.news_content_fragment);
//            newsContentFragment.refresh(news.getTitle(),news.getContent(),news.getImageId());
//        }else {
//            //如果是单页模式，则直接启动NewsContentActivity
//            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent(),news.getImageId());
//        }
//    }
    private List<News> getNews(){
        List<News> newsList=new ArrayList<>();
        News news1=new News();
        news1.setTitle("");
        news1.setContent("没注意力了？想想晚上吃什么？~(～￣▽￣)～");
        news1.setImageId(R.mipmap.relax1);
        newsList.add(news1);
        News news2=new News();
        news2.setTitle("");
        news2.setContent("吃点东西是提升注意力的好方法，可别吃了就睡啊o(￣ヘ￣o#)");
        news2.setImageId(R.mipmap.relax2);
        newsList.add(news2);
        News news3=new News();
        news3.setTitle("");
        news3.setContent("要睡回去睡，不要在教室里睡着了，然后口水流了一桌。。。");
        news3.setImageId(R.mipmap.relax3);
        newsList.add(news3);
        News news4=new News();
        news4.setTitle("");
        news4.setContent("赖床毁上午，早起傻一天，是不是感觉说的很有道理(￣┰￣*)");
        news4.setImageId(R.mipmap.relax4);
        newsList.add(news4);
        News news5=new News();
        news5.setTitle("");
        news5.setContent("讲个笑话吧：考马克思主义的时候，你应该能感受到一种厚重的使命感，因为你就要改写历史了(＾－＾)V");
        news5.setImageId(R.mipmap.relax5);
        newsList.add(news5);
        News news6=new News();
        news6.setTitle("");
        news6.setContent("还看！看完了还看！快去学习！");
        news6.setImageId(R.mipmap.relax6);
        newsList.add(news6);

        return newsList;
    }
}
