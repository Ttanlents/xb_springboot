package com.yjf.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/12/2 17:13
 * @Description
 */
@Entity
@Table(name="article")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"}) //忽略null的字段
public class Article_ implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 文章标题
     */
    @Field
    private String title;

    /**
     * 文章内容
     */

    private String content;

    /**
     * 浏览次数
     */

    @Column(name = "browse_count")
    private Integer browseCount;

    /**
     * 发布时间
     */

    @Column(name = "publish_date")
    private Date publishDate;

    /**
     * 发布人名称
     */

    @Column(name = "publish_real_name")
    private String publishRealName;

    /**
     * 发布人id
     */

    @Column(name = "user_id")
    private Integer userId;



    @Transient
    private List<String> keywords;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * @return id
     */

    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取浏览次数
     *
     * @return browse_count - 浏览次数
     */
    public Integer getBrowseCount() {
        return browseCount;
    }

    /**
     * 设置浏览次数
     *
     * @param browseCount 浏览次数
     */
    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    /**
     * 获取发布时间
     *
     * @return publish_date - 发布时间
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 设置发布时间
     *
     * @param publishDate 发布时间
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取发布人名称
     *
     * @return publish_real_name - 发布人名称
     */
    public String getPublishRealName() {
        return publishRealName;
    }

    /**
     * 设置发布人名称
     *
     * @param publishRealName 发布人名称
     */
    public void setPublishRealName(String publishRealName) {
        this.publishRealName = publishRealName;
    }

    /**
     * 获取发布人id
     *
     * @return user_id - 发布人id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置发布人id
     *
     * @param userId 发布人id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }



    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", browseCount=" + browseCount +
                ", publishDate=" + publishDate +
                ", publishRealName='" + publishRealName + '\'' +
                ", userId=" + userId +
                ", keywords=" + keywords +
                '}';
    }
}
