package com.work.backend.delegate;


import com.work.backend.dto.UserDTO;
import com.work.backend.facade.UserFacadeRemote;
import com.prueba.backend.locator.AbstractDelegate;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roberth
 */
public class UserDelegate extends AbstractDelegate<UserFacadeRemote> implements UserFacadeRemote  {

    @Override
    public List<UserDTO> findAll() {
        return this.getDelegate(JNDI_REMOTE_NAME).findAll();
    }

    @Override
    public void init() {
        this.getDelegate(JNDI_REMOTE_NAME).init();
    }

    @Override
    public void remove(Long userDTOId) {
        this.getDelegate(JNDI_REMOTE_NAME).remove(userDTOId);
    }

    @Override
    public void edit(UserDTO userDTO) {
        this.getDelegate(JNDI_REMOTE_NAME).edit(userDTO);
    }

    @Override
    public void create(UserDTO userDTO) {
        this.getDelegate(JNDI_REMOTE_NAME).create(userDTO);
    }

    @Override
    public boolean isAlive() {
        return this.getDelegate(JNDI_REMOTE_NAME).isAlive();
    }

    @Override
    public UserDTO find(Long userDTOId) {
        return this.getDelegate(JNDI_REMOTE_NAME).find(userDTOId);
    }
    
}
