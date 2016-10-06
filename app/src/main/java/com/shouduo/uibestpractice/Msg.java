package com.shouduo.uibestpractice;

/**
 * Created by 刘亨俊 on 2016/5/2.
 */
public class Msg {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private String content;
    private int type;
    private int photoId;

    public Msg(String content, int type, int photoId) {
        this.content = content;
        this.type = type;
        this.photoId = photoId;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public int getPhotoId() {
        return photoId;
    }
}
