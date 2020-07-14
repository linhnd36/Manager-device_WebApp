/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class ResourceDTO implements Serializable {

    private String ResourceId, ItemName, Category, Color, HighestOfRole, StatusId;
    private int Quantity, QuantityLeft;

    public String getResourceId() {
        return ResourceId;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getCategory() {
        return Category;
    }

    public String getColor() {
        return Color;
    }

    public String getHighestOfRole() {
        return HighestOfRole;
    }

    public String getStatusId() {
        return StatusId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setResourceId(String ResourceId) {
        this.ResourceId = ResourceId;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setHighestOfRole(String HighestOfRole) {
        this.HighestOfRole = HighestOfRole;
    }

    public void setStatusId(String StatusId) {
        this.StatusId = StatusId;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setQuantityLeft(int QuantityLeft) {
        this.QuantityLeft = QuantityLeft;
    }

    public int getQuantityLeft() {
        return QuantityLeft;
    }

}
