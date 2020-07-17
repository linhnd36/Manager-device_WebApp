/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.bookings;

import java.io.Serializable;
import linhnd.dtos.ResourceDTO;

/**
 *
 * @author PC
 */
public class ResourceInBookingDTO implements Serializable {

    private ResourceDTO ResourceDTO;
    private String DateBookingFrom, DateBookingTo;
    private int Quantity;

    public ResourceInBookingDTO() {
    }

    public ResourceInBookingDTO(ResourceDTO ResourceDTO, String DateBookingFrom, String DateBookingTo, int Quantity) {
        this.ResourceDTO = ResourceDTO;
        this.DateBookingFrom = DateBookingFrom;
        this.DateBookingTo = DateBookingTo;
        this.Quantity = Quantity;
    }

    public ResourceDTO getResourceDTO() {
        return ResourceDTO;
    }

    public String getDateBookingFrom() {
        return DateBookingFrom;
    }

    public String getDateBookingTo() {
        return DateBookingTo;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setResourceDTO(ResourceDTO ResourceDTO) {
        this.ResourceDTO = ResourceDTO;
    }

    public void setDateBookingFrom(String DateBookingFrom) {
        this.DateBookingFrom = DateBookingFrom;
    }

    public void setDateBookingTo(String DateBookingTo) {
        this.DateBookingTo = DateBookingTo;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

}
