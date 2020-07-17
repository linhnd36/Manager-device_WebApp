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
        } else {
            Map.Entry<String, ResourceInBookingDTO> entry = booking.entrySet().iterator().next();
            dateBookingFrom = entry.getValue().getDateBookingFrom();
            dateBookingTo = entry.getValue().getDateBookingTo();
        }
        ResourceDAO dao = new ResourceDAO();
        ResourceDTO dtoB = dao.getOneResource(ResourceId);
        int quatity = 1;
        if (this.booking.containsKey(ResourceId)) {
            quatity = this.booking.get(ResourceId).getQuantity() + 1;
            dateBookingFrom = this.booking.get(ResourceId).getDateBookingFrom();
            dateBookingTo = this.booking.get(ResourceId).getDateBookingTo();
        }
        ResourceInBookingDTO dto = new ResourceInBookingDTO(dtoB, dateBookingFrom, dateBookingTo, quatity);
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

    public void increaseQuantityResource(String ResourceId) {
        if (this.booking == null) {
            return;
        }
        if (this.booking.containsKey(ResourceId)) {
            this.booking.get(ResourceId).setQuantity(this.booking.get(ResourceId).getQuantity() + 1);
        }
    }

    public void reductionQuantityResource(String ResourceId) {
        if (this.booking == null) {
            return;
        }
        if (this.booking.containsKey(ResourceId)) {
            if (this.booking.get(ResourceId).getQuantity() > 1) {
                this.booking.get(ResourceId).setQuantity(this.booking.get(ResourceId).getQuantity() - 1);
            }
        }
    }
}
