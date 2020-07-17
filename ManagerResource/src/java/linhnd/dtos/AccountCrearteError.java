/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class AccountCrearteError implements Serializable {

    private String emailIsExisted;
    private String passwordLengthError;
    private String confirmNotMatched;
    private String fullNameLengthError;
    private String EmptyError;

    public AccountCrearteError() {
    }

    public String getEmailIsExisted() {
        return emailIsExisted;
    }

    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public String getConfirmNotMatched() {
        return confirmNotMatched;
    }

    public String getFullNameLengthError() {
        return fullNameLengthError;
    }

    public String getEmptyError() {
        return EmptyError;
    }

    public void setEmailIsExisted(String emailIsExisted) {
        this.emailIsExisted = emailIsExisted;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    public void setConfirmNotMatched(String confirmNotMatched) {
        this.confirmNotMatched = confirmNotMatched;
    }

    public void setFullNameLengthError(String fullNameLengthError) {
        this.fullNameLengthError = fullNameLengthError;
    }

    public void setEmptyError(String EmptyError) {
        this.EmptyError = EmptyError;
    }

}
