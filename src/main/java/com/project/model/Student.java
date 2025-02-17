package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student", schema = "edu")
public class Student {

    @Id
    private String Id;
    @Column(name = "Name")
    private String name;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;
    @Column(name = "Likings")
    private String likings;
    @Column(name = "Photo")
    private String photo;
    @Column(name = "Active")
    private short active;
    @Column(name = "Register")
    private short register;
    @Column(name = "Asociation")
    private short asociation;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLikings() {
        return likings;
    }

    public void setLikings(String likings) {
        this.likings = likings;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public short getRegister() {
        return register;
    }

    public void setRegister(short register) {
        this.register = register;
    }

    public short getAsociation() {
        return asociation;
    }

    public void setAsociation(short asociation) {
        this.asociation = asociation;
    }
}
