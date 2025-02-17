package com.project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ApplicationConsultation", schema = "edu")
public class ApplicationConsultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Text")
    private String text;
    @Column(name = "Status")
    private short status;
    @Column(name = "Answer")
    private String answer;
    @Column(name = "Date")
    private Date date;
    @Column(name = "Id_Student")
    private String id_Student;
    @Column(name = "Id_Professor")
    private String id_Professor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId_Student() {
        return id_Student;
    }

    public void setId_Student(String id_Student) {
        this.id_Student = id_Student;
    }

    public String getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(String id_Professor) {
        this.id_Professor = id_Professor;
    }
}
