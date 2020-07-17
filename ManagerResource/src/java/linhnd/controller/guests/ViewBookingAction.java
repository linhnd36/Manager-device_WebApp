/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import linhnd.bookings.ManagerBooking;
import linhnd.bookings.ResourceInBookingDTO;

/**
 *
 * @author PC
 */
public class ViewBookingAction {

    public ViewBookingAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        ManagerBooking manager = (ManagerBooking) session.get("BOOKING");
        Map<String, ResourceInBookingDTO> listMap = manager.getBooking();

        for (Map.Entry<String, ResourceInBookingDTO> entry : listMap.entrySet()) {
            String key = entry.getKey();
            ResourceInBookingDTO value = entry.getValue();
            System.out.println("Id:" + key);
            System.out.println("Name:" + value.getResourceDTO().getItemName());
            System.out.println("Date:" + value.getDateBookingFrom() + "====" + value.getDateBookingTo());
            System.out.println("ssssssssssssss");
        }
        return "success";
    }

}
