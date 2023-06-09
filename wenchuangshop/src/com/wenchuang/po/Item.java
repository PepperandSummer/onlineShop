package com.wenchuang.po;

import java.io.Serializable;
import java.util.List;

/**
 * 商品
 */
public class Item implements Serializable{
    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private String price;

    /**
     * 折扣
     */
    private Integer zk;

    /**
     * 收藏数
     */
    private Integer scNum;

    /**
     * 购买数
     */
    private Integer gmNum;

    /**
     * 主图
     */
    private String url1;

    /**
     * 副图1
     */
    private String url2;

    /**
     * 副图2
     */
    private String url3;

    /**
     * 副图3
     */
    private String url4;

    /**
     * 副图4
     */
    private String url5;

    /**
     * 描述
     */
    private String ms;


    private Integer kc;

    /**
     * 类别id一级
     */
    private Integer categoryIdOne;

    private ItemCategory yiji;

    /**
     * 类别id二级
     */
    private Integer categoryIdTwo;

    private ItemCategory erji;

    /**
     * 是否有效 0有效 1已删除
     */
    private Integer isDelete;

    /**
     * 评论列表
     */
    private List<Comment> pls;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getZk() {
        return zk;
    }

    public void setZk(Integer zk) {
        this.zk = zk;
    }

    public Integer getScNum() {
        return scNum;
    }

    public void setScNum(Integer scNum) {
        this.scNum = scNum;
    }

    public Integer getGmNum() {
        return gmNum;
    }

    public void setGmNum(Integer gmNum) {
        this.gmNum = gmNum;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getUrl4() {
        return url4;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    public String getUrl5() {
        return url5;
    }

    public void setUrl5(String url5) {
        this.url5 = url5;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }


    public Integer getKc() {
        return kc;
    }

    public void setKc(Integer kc) {
        this.kc = kc;
    }

    public Integer getCategoryIdOne() {
        return categoryIdOne;
    }

    public void setCategoryIdOne(Integer categoryIdOne) {
        this.categoryIdOne = categoryIdOne;
    }

    public ItemCategory getYiji() {
        return yiji;
    }

    public void setYiji(ItemCategory yiji) {
        this.yiji = yiji;
    }

    public Integer getCategoryIdTwo() {
        return categoryIdTwo;
    }

    public void setCategoryIdTwo(Integer categoryIdTwo) {
        this.categoryIdTwo = categoryIdTwo;
    }

    public ItemCategory getErji() {
        return erji;
    }

    public void setErji(ItemCategory erji) {
        this.erji = erji;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<Comment> getPls() {
        return pls;
    }

    public void setPls(List<Comment> pls) {
        this.pls = pls;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", zk=" + zk +
                ", scNum=" + scNum +
                ", gmNum=" + gmNum +
                ", url1='" + url1 + '\'' +
                ", url2='" + url2 + '\'' +
                ", url3='" + url3 + '\'' +
                ", url4='" + url4 + '\'' +
                ", url5='" + url5 + '\'' +
                ", ms='" + ms + '\'' +
                ", kc=" + kc +
                ", categoryIdOne=" + categoryIdOne +
                ", yiji=" + yiji +
                ", categoryIdTwo=" + categoryIdTwo +
                ", erji=" + erji +
                ", isDelete=" + isDelete +
                '}';
    }
}
