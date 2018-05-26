package com.czdpzc.entity;

import java.util.List;

/**
 * 普通用户的DTO类
 * 属性：用户ID、用户名、密码、欠款、权限
 */
public class Users extends IdEntity{
    private String userName;
    private String passWord;
    private double bill;
    private String permi;
    private List<BooksBorrow> list = null;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getPermi() {
        return permi;
    }

    public void setPermi(String permi) {
        this.permi = permi;
    }

    public List<BooksBorrow> getList() {
        return list;
    }

    public void setList(List<BooksBorrow> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", bill=" + bill +
                ", permi='" + permi + '\'' +
                ", list=" + list +
                ", id=" + id +
                '}';
    }
}
