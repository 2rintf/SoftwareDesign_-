package com.czdpzc.dao;

import com.czdpzc.entity.Books;
import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookDAO {

    public void save(Connection conn, Books book) throws SQLException;

    public void update(Connection conn, long id, Books book) throws SQLException;

    public void delete(Connection conn, Books book) throws SQLException;

    public ResultSet get(Connection conn, Books book) throws SQLException;

    public ResultSet getInfoFromBorrow(Connection conn, BooksBorrow bb,Users us) throws SQLException;


}
