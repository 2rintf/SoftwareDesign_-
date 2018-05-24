package com.czdpzc.entity;


/**
 * 图书的DTO类
 * 属性：图书ID、图书名称、作者、分类、出版社、是否可借
 */
public class Books extends IdEntity {
    private String bookName;
    private String bookWriter;
    private String bookClass;
    private String bookPub;
    private boolean ifBorrow;



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public String getBookClass() {
        return bookClass;
    }

    public void setBookClass(String bookClass) {
        this.bookClass = bookClass;
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }

    public boolean isIfBorrow() {
        return ifBorrow;
    }

    public void setIfBorrow(boolean ifBorrow) {
        this.ifBorrow = ifBorrow;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookName='" + bookName + '\'' +
                ", bookWriter='" + bookWriter + '\'' +
                ", bookClass='" + bookClass + '\'' +
                ", bookPub='" + bookPub + '\'' +
                ", ifBorrow=" + ifBorrow +
                ", id=" + id +
                '}';
    }
}
