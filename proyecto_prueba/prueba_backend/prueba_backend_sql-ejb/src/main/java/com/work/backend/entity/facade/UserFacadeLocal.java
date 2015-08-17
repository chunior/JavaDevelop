/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.backend.entity.facade;

import com.work.backend.entity.UserJPA;
import com.prueba.backend.exception.JPAException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author roberth
 */
@Local
public interface UserFacadeLocal {
    void create(UserJPA user) throws JPAException;

    void edit(UserJPA user) throws JPAException;

    void remove(UserJPA user) throws JPAException;

    UserJPA find(Object id) throws JPAException;

    List<UserJPA> findAll() throws JPAException;

    int count() throws JPAException;
}
