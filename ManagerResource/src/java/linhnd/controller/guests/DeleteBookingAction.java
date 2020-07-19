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
public class DeleteBookingAction {

    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";
    private String ResourceId;

    public DeleteBookingAction() {
    }

    public String execute() {
        String url = FAILED;
        try {
            Map session = ActionContext.getContext().getSession();
            ManagerBooking manager = (ManagerBooking) session.get("BOOKING");
            manager.removeResourceFromBooking(ResourceId);
            url = SUCCESS;
            session.put("BOOKING", manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getResourceId() {
        return ResourceId;
    }

    public void setResourceId(String ResourceId) {
        this.ResourceId = ResourceId;
    }

}
