/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import linhnd.db.MyConnection;

/**
 *
 * @author PC
 */
public class BookingDAO implements Serializable {

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

    public boolean newBooking(String BookingId, String dateFrom, String dateTo, String Email) throws Exception {
        boolean check = false;      
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                String sql = " INSERT INTO \"Booking\" (\"BookingId\",\"DateRequest\",\"DateBookingFrom\",\"DateBookingTo\",\"StatusId\",\"Email\") "
                        + " VALUES (?,?,?,?,?,?) ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, BookingId);
                stm.setDate(2, new Date(System.currentTimeMillis()));
                stm.setDate(3, Date.valueOf(dateFrom));
                stm.setDate(4, Date.valueOf(dateTo));
                stm.setString(5, "NEWREQ");
                stm.setString(6, Email);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            close();
        }
        return check;
    }
}
