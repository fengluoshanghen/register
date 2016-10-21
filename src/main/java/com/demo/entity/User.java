package com.demo.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by x250 on 2016/10/17.
 */
@Entity
@Table(name = "T_USER", schema = "USERMESSAGE", catalog = "")
@SequenceGenerator(name="userSEQ",sequenceName="user_SEQ_Oracle")
public class User {
    private Integer id;
    private String userName;
    private String age;
    private Time inputTime;
    private Time updateTime;
    private Time deleteTime;


    @Id
    @GeneratedValue(generator="userSEQ",strategy=GenerationType.SEQUENCE)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "AGE")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "INPUT_TIME")
    public Time getInputTime() {
        return inputTime;
    }

    public void setInputTime(Time inputTime) {
        this.inputTime = inputTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME")
    public Time getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Time updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "DELETE_TIME")
    public Time getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Time deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (inputTime != null ? !inputTime.equals(that.inputTime) : that.inputTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (deleteTime != null ? !deleteTime.equals(that.deleteTime) : that.deleteTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (inputTime != null ? inputTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (deleteTime != null ? deleteTime.hashCode() : 0);
        return result;
    }
}
