/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.backend.base;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author CarlosDaniel
 */
public abstract class AbstractDelegate<T> {

    @SuppressWarnings("unchecked")
    protected T getDelegate(String jndiName, String host, String port) {
        T delegate = null;
        try {
            delegate = (T) ServiceLocator.instance(host,port).get(jndiName);
        } catch (NamingException ex) {
            Logger.getLogger(AbstractDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return delegate;
    }
    
    @SuppressWarnings("unchecked")
    protected T getDelegate(String jndiName) {
        T delegate = null;
        try {
            delegate = (T) ServiceLocator.instance().get(jndiName);
        } catch (NamingException ex) {
            Logger.getLogger(AbstractDelegate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return delegate;
    }
    
}
