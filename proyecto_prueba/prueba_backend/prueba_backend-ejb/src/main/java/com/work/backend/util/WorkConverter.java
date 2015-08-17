/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.backend.util;

import com.work.backend.dto.UserDTO;
import com.work.backend.entity.UserJPA;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author roberth
 */
public class WorkConverter {
    
    public static UserDTO userToUserDTO(UserJPA user) {
        if (user == null) {
            System.out.println("User is null");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setName(user.getName());
        userDTO.setUpdatedAt(user.getUpdatedAt());
        userDTO.setVersion(user.getVersion());
        return userDTO;
    }
    
    public static List<UserDTO> usersToUserDTOs(List<UserJPA> users) {
        if (users == null) {
            System.out.println("Users is null");
        }
        List<UserDTO> userDTOs = new ArrayList<>();
        for(UserJPA user : users) {
            userDTOs.add(userToUserDTO(user));
        }
        return userDTOs;
    }
}
