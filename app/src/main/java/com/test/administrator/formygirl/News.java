package com.test.administrator.formygirl;

/**
 * Created by Administrator on 2015/8/17.
 */
public class News {
    private String title;
    private String content;
    private int imageId=R.drawable.lo;

    public String getContent() {
        return content;
    }
    public int getImageId(){return imageId;}
    public void setImageId(int imageId){this.imageId=imageId;}
    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }
}
