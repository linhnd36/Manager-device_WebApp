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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import linhnd.db.MyConnection;
import linhnd.dtos.ResourceDTO;

/**
 *
 * @author PC
 */
public class ResourceDAO implements Serializable {

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

    public List<ResourceDTO> searchResource(String nameResource, String categoryResource, String HightOfRole) throws SQLException, NamingException {
        List<ResourceDTO> result = null;
        ResourceDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {

                if (HightOfRole.equals("EMP")) {
                    String sql = "SELECT \"ResourceId\",\"ItemName\",\"Category\",\"Quantity\",\"Color\" FROM \"public\".\"Resource\" "
                            + "WHERE \"ItemName\" LIKE ? AND \"Category\" LIKE ? AND \"StatusId\" = ? AND \"HighestOfRole\" = ? ";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, "%" + nameResource + "%");
                    stm.setString(2, "%" + categoryResource + "%");
                    stm.setString(3, "RESACTIVE");
                    stm.setString(4, "EMP");
                } else {
                    String sql = "SELECT \"ResourceId\",\"ItemName\",\"Category\",\"Quantity\",\"Color\" FROM \"public\".\"Resource\" "
                            + "WHERE \"ItemName\" LIKE ? AND \"Category\" LIKE ? AND \"StatusId\" = ?  ";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, "%" + nameResource + "%");
                    stm.setString(2, "%" + categoryResource + "%");
                    stm.setString(3, "RESACTIVE");
                }
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {
                    dto = new ResourceDTO();
                    dto.setResourceId(rs.getString("ResourceId"));
                    dto.setItemName(rs.getString("ItemName"));
                    dto.setCategory(rs.getString("Category"));
                    dto.setQuantity(rs.getInt("Quantity"));
                    dto.setColor(rs.getString("Color"));
                    result.add(dto);
                }
            }
        } finally {
            close();
        }
        return result;
    }
}
