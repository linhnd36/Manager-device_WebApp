/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.bookings;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import linhnd.daos.ResourceDAO;
import linhnd.dtos.ResourceDTO;

/**
 *
 * @author PC
 */
public class ManagerBooking {

    private Map<String, ResourceInBookingDTO> booking;
    private String DateBookingFrom, DateBookingTo;

    public Map<String, ResourceInBookingDTO> getBooking() {
        return booking;
    }

    public void addResourceToBooking(String ResourceId, String dateBookingFrom, String dateBookingTo) throws SQLException, NamingException {
        if (ResourceId == null) {
            return;
        }
        if (ResourceId.isEmpty()) {
            return;
        }
        if (this.booking == null) {
            this.booking = new HashMap<>();
            this.DateBookingFrom = dateBookingFrom;
            this.DateBookingTo = dateBookingTo;
        }
        ResourceDAO dao = new ResourceDAO();
        ResourceDTO dtoB = dao.getOneResource(ResourceId);
        int quatity = 1;
        if (this.booking.containsKey(ResourceId)) {
            quatity = this.booking.get(ResourceId).getQuantity() + 1;
        }
        ResourceInBookingDTO dto = new ResourceInBookingDTO(dtoB, quatity);
        this.booking.put(ResourceId, dto);
    }

    public void removeResourceFromBooking(String ResourceId) {
        if (this.booking == null) {
            return;
        }
        if (this.booking.containsKey(ResourceId)) {
            this.booking.remove(ResourceId);
            if (this.booking.isEmpty()) {
                this.booking = null;
            }
        }
    }

    public void updateQuantityResource(String ResourceId, String newQuantity) throws Exception {
        if (this.booking == null) {
            return;
        }
        if (this.booking.containsKey(ResourceId)) {
            this.booking.get(ResourceId).setQuantity(Integer.parseInt(newQuantity));
        }
    }

    public String getDateBookingFrom() {
        return DateBookingFrom;
    }

    public String getDateBookingTo() {
        return DateBookingTo;
    }

    public void setDateBookingFrom(String DateBookingFrom) {
        this.DateBookingFrom = DateBookingFrom;
    }

    public void setDateBookingTo(String DateBookingTo) {
        this.DateBookingTo = DateBookingTo;
    }

}
