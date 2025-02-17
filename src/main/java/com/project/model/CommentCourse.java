package com.project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CommentCouse", schema = "edu")
public class CommentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCommentC;
    @Column(name = "ContentC")
    private String contentC;
    @Column(name = "Acronym")
    private String acronym;
    @Column(name = "Id_User")
    private String id_User;
    @Column(name = "Date")
    private Date date;

    public int getIdCommentC() {
        return IdCommentC;
    }

    public void setIdCommentC(int idCommentC) {
        IdCommentC = idCommentC;
    }

    public String getContentC() {
        return contentC;
    }

    public void setContentC(String contentC) {
        this.contentC = contentC;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
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
