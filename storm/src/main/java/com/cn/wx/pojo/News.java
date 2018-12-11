package com.cn.wx.pojo;

import java.util.Date;

public class News {
    private Integer newsId;

    private Integer kwId;

    private String stuId;

    private String newsImg;

    private Integer commentNum;

    private Integer praiseNum;

    private Integer browseNum;

    private Date createTime;

    private String newsCont;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getKwId() {
        return kwId;
    }

    public void setKwId(Integer kwId) {
        this.kwId = kwId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg == null ? null : newsImg.trim();
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNewsCont() {
        return newsCont;
    }

    public void setNewsCont(String newsCont) {
        this.newsCont = newsCont == null ? null : newsCont.trim();
    }
}