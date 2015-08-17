/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.backend.exception;

/**
 *
 * @author conamerica01
 */
public class JPAException extends Exception{
    
    public JPAException() {
    }
    
    public JPAException(String mensaje) {
        super(mensaje);
    }
    
    public JPAException(String message, Throwable cause) {
        super(message, cause);
    }

    
}
