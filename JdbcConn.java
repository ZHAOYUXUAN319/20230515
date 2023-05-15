package javaJdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hangt
 */
public class JdbcConn {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;


    String url = "jdbc:postgresql://localhost:5434/postgres";
    String user = "postgres";
    String password = "319333633";

    public Connection getDbcom() throws ClassNotFoundException{
        if (conn == null) {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(url, user, password);
                stmt = conn.createStatement();

//                String sql = "insert into student values (4,'z')";
   //             stmt.executeUpdate(sql);
            } catch (SQLException ex) {
            }
        }
        return conn;

    }


//        public static void main(String[] args) {
//            try {
//                JdbcConn yourObject = new JdbcConn();
//                Connection connection = yourObject.getDbcom();
//
//            // 使用 connection 对象进行数据库操作
//                // ...
//            } catch (ClassNotFoundException e) {
//                // 处理 ClassNotFoundException 异常
//                e.printStackTrace();
//            }
//        }
//    

    public ResultSet tt(String sql) throws SQLException {
        ResultSet resultSet;
        Statement query = null;
        try {
            query = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultSet = query.executeQuery(sql);

        return resultSet;
    }

    public void cud(String sql) throws SQLException {

        stmt.executeUpdate(sql);

        System.out.println(sql);

    }

    public void closeDbcom() throws SQLException {
        if (rset != null) {
            rset.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
