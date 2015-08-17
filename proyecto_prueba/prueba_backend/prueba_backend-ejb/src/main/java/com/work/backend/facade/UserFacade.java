/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.backend.facade;

import com.work.backend.dto.UserDTO;
import com.work.backend.entity.UserJPA;
import com.prueba.backend.exception.JPAException;
import com.work.backend.util.WorkConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author roberth
 */
@Stateless(name = "UserFacade", mappedName = UserFacadeRemote.JNDI_REMOTE_NAME)
@Remote(UserFacadeRemote.class)
@Local(UserFacadeLocal.class)
public class UserFacade implements UserFacadeRemote, UserFacadeLocal {

    @Inject
    private com.work.backend.entity.facade.UserFacadeLocal userFacadeLocal;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOs = new ArrayList<>();
        try {
            userDTOs.addAll(WorkConverter.usersToUserDTOs(userFacadeLocal.findAll()));
        } catch (JPAException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userDTOs;
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Long userDTOId) {
        try {
            this.userFacadeLocal.remove(this.userFacadeLocal.find(userDTOId));
        } catch (JPAException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(UserDTO userDTO) {
        if (userDTO == null) {
            System.out.println("userDTO is null");
        }
        try {
            this.userFacadeLocal.edit(new UserJPA(userDTO));
        } catch (JPAException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(UserDTO userDTO) {
        if (userDTO == null) {
            System.out.println("userDTO is null");
        }
        try {
            this.userFacadeLocal.create(new UserJPA(userDTO));
        } catch (JPAException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public UserDTO find(Long userDTOId) {
        UserDTO userDTO = new UserDTO();
        try {
            userDTO = WorkConverter.userToUserDTO(this.userFacadeLocal.find(userDTOId));
        } catch (JPAException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userDTO;
    }

}
