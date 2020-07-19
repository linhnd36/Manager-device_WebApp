/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import linhnd.bookings.ManagerBooking;

/**
 *
 * @author PC
 */
public class UpdateBookingAction {

    private String ResourceId;
    private String QuantityNew;
    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    public UpdateBookingAction() {
    }

    public String execute(){
        String url = FAILED;
        try {
            Map session = ActionContext.getContext().getSession();
            ManagerBooking manager = (ManagerBooking) session.get("BOOKING");
            manager.updateQuantityResource(ResourceId, QuantityNew);
            url = SUCCESS;
            session.put("BOOKING", manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public void setResourceId(String ResourceId) {
        this.ResourceId = ResourceId;
    }

    public void setQuantityNew(String QuantityNew) {
        this.QuantityNew = QuantityNew;
    }

    public String getResourceId() {
        return ResourceId;
    }

    public String getQuantityNew() {
        return QuantityNew;
    }
    
    

}
