/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import linhnd.utils.JavaMailUtil;

/**
 *
 * @author PC
 */
public class SendCodeMailAction {

    private static final String FAILED = "failed";
    private static final String SUCCESS = "success";
    private static final int MAX = 99999;
    private static final int MIN = 10000;
    private String email;

    public SendCodeMailAction() {
    }

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        String url = FAILED;
        try {
            email = (String) session.get("EMAIL");
            int randomCode = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            String randomCodeString = String.valueOf(randomCode);
            JavaMailUtil.sendMail(email, randomCodeString);
            session.put("RANDOM_CODE", randomCodeString);
            url = SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
}
