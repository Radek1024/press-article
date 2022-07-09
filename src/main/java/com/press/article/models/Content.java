package com.press.article.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contentBody;

    public Content() {
    }

    public Content(Long id, String title, String contentBody) {
        this.id = id;
        this.title = title;
        this.contentBody = contentBody;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contentBody='" + contentBody + '\'' +
                '}';
    }
}
