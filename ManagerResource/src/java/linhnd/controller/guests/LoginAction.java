/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import linhnd.daos.UserDAO;
import linhnd.dtos.UsersDTO;
import linhnd.utils.VerifyRecaptcha;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author PC
 */
public class LoginAction {

    private static final String GUEST = "guest";
    private static final String MANAGER = "manager";
    private static final String FAIL = "fail";
    private String username;
    private String password;
    private String error;

    public LoginAction() {
    }

    public String execute() throws Exception {

        String url = FAIL;

        HttpServletRequest request = ServletActionContext.getRequest();
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

        try {
            Map sesstion = ActionContext.getContext().getSession();
            UserDAO dao = new UserDAO();
            if (dao.checkLogin(username, password)) {
                if (verify) {
                    UsersDTO dto = dao.getUserInfor(username);
                    sesstion.put("USER", dto);
                    if (dto.getRoleId().equals("MANAGER")) {
                        url = MANAGER;
                    } else {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        Date dateNow = new Date(System.currentTimeMillis());
                        sesstion.put("DATENOW", format.format(dateNow));
                        url = GUEST;
                    }
                } else {
                    error = "Ples verify capcha !";
                }
            } else {
                error = "User is not found.";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
