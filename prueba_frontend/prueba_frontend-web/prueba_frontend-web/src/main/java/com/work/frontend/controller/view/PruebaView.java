/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.frontend.controller.view;

import com.work.backend.delegate.UserDelegate;
import com.work.backend.dto.UserDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 *
 * @author jr
 */
@ManagedBean(name = "pruebaViewBean")
@ViewScoped
public class PruebaView implements Serializable {

    private UserDTO userDTO;
    private List<UserDTO> userDTOs;

    @PostConstruct
    public void init() {
        userDTO = new UserDTO();
        this.userDTOs = new ArrayList<>();
        this.getUserDTOs().addAll(new UserDelegate().findAll());
    }
    
    public void create(){
    
       new UserDelegate().create(userDTO);
    }

    public PruebaView() {
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<UserDTO> getUserDTOs() {
        if(userDTOs == null){
            return userDTOs = new ArrayList<>();
        }
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }
    
    
}
