/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import linhnd.dtos.UsersDTO;

/**
 *
 * @author PC
 */
public class LogoutAction {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public LogoutAction() {
    }

    public String execute() {
        System.out.println("check loout");
        String url = FAIL;
        try {
            Map session = ActionContext.getContext().getSession();
            session.remove("USER");
            url = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

}
