/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.backend.locator;

import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author CarlosDaniel
 */
public class ServiceLocator {

    private static volatile ServiceLocator instance = null;

    private Map<String, ServiceVerifier> services = new TreeMap<>();

    private Context ctx;

    private ServiceLocator(String host, String port) throws NamingException {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs",
                "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", host);
        props.setProperty("org.omg.CORBA.ORBInitialPort", port);
        ctx = new InitialContext(props);
    }
    
    private ServiceLocator() throws NamingException {
        ctx = new InitialContext();
    }

    public static ServiceLocator instance(String host, String port) throws NamingException {
        if (instance == null) {
            synchronized (ServiceLocator.class) {
                if (instance == null) {
                    instance = new ServiceLocator(host,port);
                } else {
                    if (instance.ctx == null) {
                        Properties props = new Properties();
                        props.setProperty("java.naming.factory.initial",
                                "com.sun.enterprise.naming.SerialInitContextFactory");
                        props.setProperty("java.naming.factory.url.pkgs",
                                "com.sun.enterprise.naming");
                        props.setProperty("java.naming.factory.state",
                                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
                        props.setProperty("org.omg.CORBA.ORBInitialHost", host);
                        props.setProperty("org.omg.CORBA.ORBInitialPort", port);
                        instance.ctx = new InitialContext(props);
                    }
                }
            }
        }
        return instance;
    }
    
    public static ServiceLocator instance() throws NamingException {
        if (instance == null) {
            synchronized (ServiceLocator.class) {
                if (instance == null) {
                    instance = new ServiceLocator();
                } else {
                    if (instance.ctx == null) {
                        instance.ctx = new InitialContext();
                    }
                }
            }
        }
        return instance;
    }

    public Object get(String beanName) throws NamingException {
        ServiceVerifier vs = services.get(beanName);
        Object serviceRef = null;
        if (vs != null) {
            try {
                vs.isAlive();
                serviceRef = vs;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (serviceRef == null) {
            serviceRef = ctx.lookup(beanName);
            assert ServiceVerifier.class.isAssignableFrom(serviceRef.getClass());
            services.put(beanName, (ServiceVerifier) serviceRef);
        }
        return serviceRef;
    }

}
