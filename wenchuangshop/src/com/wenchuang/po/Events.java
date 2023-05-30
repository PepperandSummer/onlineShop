package com.wenchuang.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Events implements Serializable {

    private Integer id;
    /**
     * 标题
     */
    private  String name;
    /**
     * 内容
     */
    private String content;

    /**
     * 发布时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     *
     *post列表
     */
    private List<Post> posts;

    public Events(Integer id, String name, String content, Date addTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

    public Events() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", addTime=" + addTime + '\'' +
                ". updateTime=" +
                '}';
    }
}
