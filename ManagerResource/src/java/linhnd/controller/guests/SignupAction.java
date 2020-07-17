/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import javax.naming.NamingException;
import linhnd.daos.UserDAO;
import linhnd.dtos.AccountCrearteError;
import linhnd.dtos.UsersDTO;

/**
 *
 * @author PC
 */
public class SignupAction {

    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";
    private String Email;
    private String Password;
    private String Name;
    private String Phone;
    private String Address;
    private String PasswordConfirm;
    private AccountCrearteError Errors;

    public SignupAction() {
    }

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        String url = FAILED;
        Errors = new AccountCrearteError();
        boolean foundErr = false;

        try {
            if (Email.trim() == "" || Password.trim() == "" || Name.trim() == "" || Address.trim() == "" || Phone.trim() == "") {
                foundErr = true;
                Errors.setEmptyError("Ples Input full !");
            }
            if (Password.trim().length() < 6 || Password.length() > 20) {
                foundErr = true;
                Errors.setPasswordLengthError("Password string is required from 6 to 20 characters");
            } else if (!Password.trim().equals(PasswordConfirm.trim())) {
                foundErr = true;
                Errors.setConfirmNotMatched("Confirm must match password");
            }
            if (Name.trim().length() < 2 || Name.trim().length() > 50) {
                foundErr = true;
                Errors.setFullNameLengthError("Full name string is required from 2 to 50 characters");
            }
            if (!foundErr) {
                UsersDTO dto = new UsersDTO(Email, Password, Name, Address, Phone, "EMP", "NEW");
                UserDAO dao = new UserDAO();
                if (dao.newUser(dto)) {
                    url = SUCCESS;
                    session.put("EMAIL", Email);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            String msgErr = e.getMessage();
            if (msgErr.contains("duplicate")) {
                Errors.setEmailIsExisted(Email + " is existed. Please, choose another!!");
            }
        }
        return url;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAddress() {
        return Address;
    }

    public String getPasswordConfirm() {
        return PasswordConfirm;
    }

    public AccountCrearteError getErrors() {
        return Errors;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPasswordConfirm(String PasswordConfirm) {
        this.PasswordConfirm = PasswordConfirm;
    }

    public void setErrors(AccountCrearteError Errors) {
        this.Errors = Errors;
    }

}
