/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import linhnd.bookings.ManagerBooking;
import linhnd.bookings.ResourceInBookingDTO;

/**
 *
 * @author PC
 */
public class AddResourceToBookingAction {

    private String dateSearchFrom, dateSearchTo;
    private Date dateFrom, dateTo;
    private String ResourceId;

    public AddResourceToBookingAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            dateFrom = format.parse(dateSearchFrom);
            dateTo = format.parse(dateSearchTo);
            if (!dateFrom.before(dateTo)) {
                Date tmp = dateFrom;
                dateFrom = dateTo;
                dateTo = tmp;
            }
            dateSearchFrom = format.format(dateFrom);
            dateSearchTo = format.format(dateTo);

            ManagerBooking managerBooking = (ManagerBooking) session.get("BOOKING");
            if (managerBooking == null) {
                managerBooking = new ManagerBooking();
            }
            managerBooking.addResourceToBooking(ResourceId, dateSearchFrom, dateSearchTo);
            session.put("BOOKING", managerBooking);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    public String getResourceId() {
        return ResourceId;
    }

    public void setResourceId(String ResourceId) {
        this.ResourceId = ResourceId;
    }

    public String getDateSearchFrom() {
        return dateSearchFrom;
    }

    public String getDateSearchTo() {
        return dateSearchTo;
    }

    public void setDateSearchFrom(String dateSearchFrom) {
        this.dateSearchFrom = dateSearchFrom;
    }

    public void setDateSearchTo(String dateSearchTo) {
        this.dateSearchTo = dateSearchTo;
    }

}
