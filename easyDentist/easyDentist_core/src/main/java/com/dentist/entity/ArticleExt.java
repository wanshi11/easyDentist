package com.dentist.entity;

public class ArticleExt {
    private Integer id;

    private Integer articleid;

    private Integer readvalue;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getReadvalue() {
        return readvalue;
    }

    public void setReadvalue(Integer readvalue) {
        this.readvalue = readvalue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}