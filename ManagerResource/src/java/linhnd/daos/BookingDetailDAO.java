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

/**
 *
 * @author PC
 */
public class BookingDetailDAO implements Serializable {

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

    public int countResourceInBookingDetail(String dateSearchFrom, String dateSearchTo, String resourceId) throws NamingException, SQLException {
        int result = 0;
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                String sql = "SELECT SUM (\"Amount\") AS total FROM \"public\".\"Booking\", \"BookingDetail\" WHERE \"Booking\".\"BookingId\" = \"BookingDetail\".\"BookingId\" "
                        + " AND \"Booking\".\"BookingId\" NOT IN ( SELECT \"BookingId\" FROM \"Booking\" WHERE \"DateBookingTo\" < ? AND \"DateBookingFrom\" > ? ) "
                        + " AND (  \"StatusId\" = 'NEWREQ' OR \"StatusId\" = 'ACCEPTREQ' ) AND \"ResourceId\" = ? ";
                stm = conn.prepareStatement(sql);
                stm.setDate(1, java.sql.Date.valueOf(dateSearchFrom));
                stm.setDate(2, java.sql.Date.valueOf(dateSearchTo));
                stm.setString(3, resourceId);
                rs = stm.executeQuery();
                String resultString = null;
                if (rs.next()) {
                    resultString = rs.getString("total");
                }
                if (resultString != null) {
                    result = Integer.parseInt(resultString);
                }
            }
        } finally {
            close();
        }
        return result;
    }
}
