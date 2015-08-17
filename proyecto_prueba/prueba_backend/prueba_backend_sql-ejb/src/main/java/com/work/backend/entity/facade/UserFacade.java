/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.backend.entity.facade;

import com.prueba.backend.entity.facade.AbstractFacade;
import com.work.backend.entity.UserJPA;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author roberth
 */
@Stateless
public class UserFacade extends AbstractFacade<UserJPA> implements UserFacadeLocal {

    @PersistenceUnit(unitName = "prueba_backend_PU")
    private EntityManagerFactory emf;

    public UserFacade() {
        super(UserJPA.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
}
