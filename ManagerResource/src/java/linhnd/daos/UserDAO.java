/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import linhnd.db.MyConnection;
import linhnd.dtos.UsersDTO;

/**
 *
 * @author PC
 */
public class UserDAO implements Serializable {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void close() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                String sql = " SELECT * FROM \"Users\" WHERE \"Email\" = ? AND \"Password\" = ? AND \"StatusId\" = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, "ACTIVE");
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } finally {
            close();
        }
        return check;
    }

    public UsersDTO getUserInfor(String username) throws SQLException, NamingException {
        UsersDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                String sql = " SELECT \"Email\",\"Name\",\"Address\",\"Phone\",\"RoleId\" FROM \"Users\" WHERE \"Email\" = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    dto = new UsersDTO();
                    dto.setEmail(rs.getString("Email"));
                    dto.setName(rs.getString("Name"));
                    dto.setAdress(rs.getString("Address"));
                    dto.setPhone(rs.getString("Phone"));
                    dto.setRoleId(rs.getString("RoleId"));
                }
            }
        } finally {
            close();
        }
        return dto;
    }

}