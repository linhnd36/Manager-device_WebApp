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
    private int Quantity;

    public ResourceInBookingDTO() {
    }

    public ResourceInBookingDTO(ResourceDTO ResourceDTO, int Quantity) {
        this.ResourceDTO = ResourceDTO;
        this.Quantity = Quantity;
    }

    public ResourceDTO getResourceDTO() {
        return ResourceDTO;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setResourceDTO(ResourceDTO ResourceDTO) {
        this.ResourceDTO = ResourceDTO;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

}
