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
public class UsersDTO implements Serializable {

    private String Email, Password, Name, Adress, Phone, CreateDate, RoleId, StatusId;

    public UsersDTO() {
    }

    public UsersDTO(String Email, String Password, String Name, String Adress, String Phone, String RoleId, String StatusId) {
        this.Email = Email;
        this.Password = Password;
        this.Name = Name;
        this.Adress = Adress;
        this.Phone = Phone;
        this.RoleId = RoleId;
        this.StatusId = StatusId;
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

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public void setRoleId(String RoleId) {
        this.RoleId = RoleId;
    }

    public void setStatusId(String StatusId) {
        this.StatusId = StatusId;
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

    public String getAdress() {
        return Adress;
    }

    public String getPhone() {
        return Phone;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public String getRoleId() {
        return RoleId;
    }

    public String getStatusId() {
        return StatusId;
    }

}
