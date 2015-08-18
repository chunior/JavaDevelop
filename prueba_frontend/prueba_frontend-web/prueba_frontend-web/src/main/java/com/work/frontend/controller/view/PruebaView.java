/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.frontend.controller.view;

import com.work.backend.dto.UserDTO;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author jr
 */
@ManagedBean(name = "pruebaViewBean")
@ViewScoped
public class PruebaView implements Serializable {

    private UserDTO userDTO;

    @PostConstruct
    public void init() {
        userDTO = new UserDTO();
    }

    public PruebaView() {
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

}
