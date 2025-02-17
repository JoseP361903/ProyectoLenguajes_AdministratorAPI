package com.project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "BreakingNew", schema = "edu")
public class BreakingNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNew;
    @Column(name = "Date")
    private Date date;
    @Column(name = "Title")
    private String title;
    @Column(name = "Paragraph")
    private String paragraph;
    @Column(name = "Photo")
    private String photo;

    public int getIdNew() {
        return idNew;
    }

    public void setIdNew(int idNew) {
        this.idNew = idNew;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
