/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import linhnd.bookings.ManagerBooking;
import linhnd.bookings.ResourceInBookingDTO;
import linhnd.daos.BookingDAO;
import linhnd.daos.BookingDetailDAO;
import linhnd.dtos.UsersDTO;

/**
 *
 * @author PC
 */
public class CheckOutAction {

    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";
    private List<String> listError;

    public CheckOutAction() {
    }

    public String execute() {
        String url = FAILED;
        listError = new ArrayList<>();
        try {
            Map session = ActionContext.getContext().getSession();
            ManagerBooking manager = (ManagerBooking) session.get("BOOKING");

            Map<String, ResourceInBookingDTO> listBooking = manager.getBooking();
            UsersDTO dtoUser = (UsersDTO) session.get("USER");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ssZ");
            BookingDAO daoBooking = new BookingDAO();
            BookingDetailDAO daoBookingDetail = new BookingDetailDAO();

            Date date = new java.sql.Date(System.currentTimeMillis());
            String BookingId = dtoUser.getEmail() + format.format(date);

            for (Map.Entry<String, ResourceInBookingDTO> entry : listBooking.entrySet()) {
                String key = entry.getKey();
                ResourceInBookingDTO value = entry.getValue();
                if (value.getQuantity() > value.getResourceDTO().getQuantityLeft()) {
                    listError.add(key);
                }
            }
            if (listError.isEmpty()) {
                if (daoBooking.newBooking(BookingId, manager.getDateBookingFrom(), manager.getDateBookingTo(), dtoUser.getEmail())) {
                    for (Map.Entry<String, ResourceInBookingDTO> entry : listBooking.entrySet()) {
                        String ResourceId = entry.getKey();
                        ResourceInBookingDTO value = entry.getValue();
                        daoBookingDetail.newBookingDetail(BookingId + ResourceId, value.getQuantity(), BookingId, ResourceId);
                    }
                }
                session.remove("BOOKING");
                url = SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public List<String> getListError() {
        return listError;
    }

    public void setListError(List<String> listError) {
        this.listError = listError;
    }

}
