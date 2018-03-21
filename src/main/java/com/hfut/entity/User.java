package com.hfut.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {
    private Integer id;

    private Integer level;

    private Integer tid;

    private String user;

    private String password;

    private String mail;

    private String question;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date alterTime;

    private String answer;

    private UserRole userRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(Date alterTime) {
        this.alterTime = alterTime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public User setUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", level=" + level +
                ", tid=" + tid +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", question='" + question + '\'' +
                ", createTime=" + createTime +
                ", alterTime=" + alterTime +
                ", answer='" + answer + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}