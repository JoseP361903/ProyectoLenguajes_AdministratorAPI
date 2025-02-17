package com.project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CommentNew", schema = "edu")
public class CommentNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int NewIdCommentN;
    @Column(name = "ContentC")
    private String contentC;
    @Column(name = "Id_New")
    private int id_New;
    @Column(name = "Id_User")
    private String id_User;
    @Column(name = "Date")
    private Date date;

    public int getId() {
        return NewIdCommentN;
    }

    public void setId(int id) {
        this.NewIdCommentN = id;
    }

    public String getContentC() {
        return contentC;
    }

    public void setContentC(String contentC) {
        this.contentC = contentC;
    }

    public int getId_New() {
        return id_New;
    }

    public void setId_New(int id_New) {
        this.id_New = id_New;
    }

    public String getId_User() {
        return id_User;
    }

    public void setId_User(String id_User) {
        this.id_User = id_User;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
