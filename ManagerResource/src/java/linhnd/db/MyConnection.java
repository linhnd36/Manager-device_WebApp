/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author PC
 */
public class MyConnection implements Serializable {

    public static Connection getConnection() throws Exception {
//        Context context = new InitialContext();
//        Context tomContext = (Context) context.lookup("java:comp/env");
//        DataSource ds = (DataSource) tomContext.lookup("ManagerResource");
//        Connection conn = ds.getConnection();
//        return conn;
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://ec2-34-206-31-217.compute-1.amazonaws.com:5432/ddgl9ok3gpjnas";
        Connection conn = DriverManager.getConnection(url, "hdvxvewgymxkdq", "1d5cd5e487a77c931d60f8b04b0d0534f51b23d8be0f64af7f645e386b6d4de4");
        return conn;

    }
}
