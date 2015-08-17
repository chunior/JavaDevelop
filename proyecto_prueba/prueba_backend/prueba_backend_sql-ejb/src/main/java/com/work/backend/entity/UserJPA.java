/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.backend.entity;

import com.work.backend.dto.UserDTO;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author roberth
 */
@Entity
@Table(name = "user")
public class UserJPA extends UserDTO {

    @Override
    public void setUpdatedAt(Date updatedAt) {
        super.setUpdatedAt(updatedAt); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getUpdatedAt() {
        return super.getUpdatedAt(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        super.setCreatedAt(createdAt); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getCreatedAt() {
        return super.getCreatedAt(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVersion(Integer version) {
        super.setVersion(version); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getVersion() {
        return super.getVersion(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Override
    public Long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        return super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLogin() {
        return super.getLogin(); //To change body of generated methods, choose Tools | Templates.
    }

    public UserJPA() {
    }

    public UserJPA(UserDTO userDTO) {
        this.setId(userDTO.getId());
        this.setName(userDTO.getName());
        this.setLogin(userDTO.getLogin());
        if (this.getId() == null) {
            this.setCreatedAt(new Date());
        } else {
            this.setUpdatedAt(new Date());
        }
        this.setPassword(userDTO.getPassword());
        this.setVersion(userDTO.getVersion());
    }

}
