package com.press.article.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class PressArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Content content;
    //@NotBlank(message = "Publication date is mandatory.")
    private Date publicationDate;
    @NotBlank(message = "Magazine name is mandatory.")
    private String magazineName;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Author author;
    @CreationTimestamp
    private Date timestamp;

    public PressArticle() {
    }

    public Long getId() {
        return id;
    }

    public Content getContent() {
        return content;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public Author getAuthor() {
        return author;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "PressArticle{" +
                "id=" + id +
                ", content=" + content +
                ", publicationDate=" + publicationDate +
                ", magazineName='" + magazineName + '\'' +
                ", author=" + author +
                ", timestamp=" + timestamp +
                '}';
    }
}
