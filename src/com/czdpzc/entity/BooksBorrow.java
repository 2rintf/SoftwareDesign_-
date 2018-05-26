package com.czdpzc.entity;

import java.sql.Date;

public class BooksBorrow extends IdEntity {
    private long user_id;
    private Date borrow_date;
    private Date back_date;
    private String book_name;

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    //    private double bill;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }

//    public double getBill() {
//        return bill;
//    }

//    public void setBill(double bill) {
//        this.bill = bill;
//    }

    @Override
    public String toString() {
        return "BooksBorrow{" +
                "user_id=" + user_id +
                ", borrow_date=" + borrow_date +
                ", back_date=" + back_date +
                ", id=" + id +
                '}';
    }
}
