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
import linhnd.daos.BookingDetailDAO;

/**
 *
 * @author PC
 */
public class ViewBookingAction {

    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    public ViewBookingAction() {
    }

    public String execute() {
        String url = FAILED;
        try {
            Map session = ActionContext.getContext().getSession();
            ManagerBooking manager = (ManagerBooking) session.get("BOOKING");
            BookingDetailDAO daoBookingDetail = new BookingDetailDAO();

            Map<String, ResourceInBookingDTO> listBooking = manager.getBooking();
            for (Map.Entry<String, ResourceInBookingDTO> entry : listBooking.entrySet()) {
                String ResourceId = entry.getKey();
                ResourceInBookingDTO value = entry.getValue();
                int quantityLeft = daoBookingDetail.countResourceInBookingDetail(manager.getDateBookingFrom(), manager.getDateBookingTo(), ResourceId);
                value.getResourceDTO().setQuantityLeft(value.getResourceDTO().getQuantity() - quantityLeft);
            }
            url = SUCCESS;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return url;
    }

}
