package com.demo.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


/**
 * Created by x250 on 2016/10/17.
 */
@Entity
@Table(name = "T_LOGIN_USER", schema = "USERMESSAGE", catalog = "")
@SequenceGenerator(name="personSEQ",sequenceName="person_SEQ_Oracle")
public class Person {
    private Integer id;

    @NotEmpty(message= "用户名不能为空！" )
    private String userName;

    @NotEmpty(message= "密码不能为空！" )
    @Length(min=6,max=16,message= "密码长度为6位到16位之间！" )
    private String userPassword;

    @NotEmpty(message= "手机号码不能为空！" )
    @Pattern(regexp="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message="手机号格式不正确")
    private String phone;

    @NotEmpty (message= "email地址不能为空！" )
    @Email (message= "email地址无效！" )
    private String address;

    @Id
    @GeneratedValue(generator="personSEQ",strategy=GenerationType.SEQUENCE)
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
    @Column(name = "USER_PASSWORD")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
