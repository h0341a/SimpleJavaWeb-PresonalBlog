package com.entity;

import java.util.Date;

public class Post {
    private int postId;
    private String title;
    private String content;
    private Date createDate;
    private int visitors;
    private int authorId;

    public Post(String title, String content, int authorId){
        setTitle(title);
        setContent(content);
        setAuthorId(authorId);
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int author_id) {
        this.authorId = author_id;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

}
