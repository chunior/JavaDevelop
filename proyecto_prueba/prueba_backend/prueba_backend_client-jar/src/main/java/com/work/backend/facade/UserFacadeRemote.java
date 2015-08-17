/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.backend.facade;

import com.work.backend.dto.UserDTO;
import com.prueba.backend.locator.ServiceVerifier;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author roberth
 */
@Remote
public interface UserFacadeRemote extends ServiceVerifier {
    
    public final String JNDI_REMOTE_NAME = "ejb/userFacadeRemote";
    
    public List<UserDTO> findAll();
    
    public UserDTO find(Long userDTOId);
    
    public void init();
    
    public void remove(Long userDTOId);
    
    public void edit(UserDTO userDTO);
    
    public void create(UserDTO userDTO);
}
