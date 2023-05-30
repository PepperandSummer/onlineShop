package com.wenchuang.po;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {


    /**
     * 主键
     */
    private Integer id;

    /**
     * 上传名称
     */
    private String name;

    /**
     * 上传内容
     */
    private String content;

    /**
     * 上传时间
     */
    private Date addTime;

    /**
     *参与活动id
     */
    private Integer eventsId;
    private Events events;

    /**
     * 参与用户
     */
    private Integer userId;
    private User user;

    /**
     * 上传状态0待发布 1已发布 2活动已结束
     */
    private Integer status;

    /**
     * 审核状态 0未审核 1已审核
     */
    private Integer reviewStatus;


    /**删除
     * 0否 1是
     */
    private Integer isDelete;



    public Post() {
    }

    public Post(Integer id, String name, String content, Date addTime, Integer eventsId, Events events, Integer userId, User user, Integer status, Integer reviewStatus, Integer isDelete) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.addTime = addTime;
        this.eventsId = eventsId;
        this.events = events;
        this.userId = userId;
        this.user = user;
        this.status = status;
        this.reviewStatus = reviewStatus;
        this.isDelete = isDelete;
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

    public Integer getEventsId() {
        return eventsId;
    }

    public void setEventsId(Integer eventsId) {
        this.eventsId = eventsId;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", addTime=" + addTime +
                ", eventsId=" + eventsId +
                ", events=" + events +
                ", userId=" + userId +
                ", user=" + user +
                ", status=" + status +
                ", reviewStatus=" + reviewStatus +
                ", isDelete=" + isDelete +
                '}';
    }
}
