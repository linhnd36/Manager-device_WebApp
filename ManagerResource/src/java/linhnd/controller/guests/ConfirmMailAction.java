/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import linhnd.daos.UserDAO;

/**
 *
 * @author PC
 */
public class ConfirmMailAction {

    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";
    private String code;
    private String errors;

    public ConfirmMailAction() {
    }

    public String execute() throws Exception {
        String url = FAILED;
        try {
            Map session = ActionContext.getContext().getSession();
            String codeSession = (String) session.get("RANDOM_CODE");
            String email = (String) session.get("EMAIL");
            UserDAO dao = new UserDAO();
            if (code.equals(codeSession)) {
                dao.updateStatustUser(email);
                url = SUCCESS;
            } else {
                errors = "Code Error !";
            }
        } catch (Exception e) {
            errors = "Code Error !";
            e.printStackTrace();
        }
        return url;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
