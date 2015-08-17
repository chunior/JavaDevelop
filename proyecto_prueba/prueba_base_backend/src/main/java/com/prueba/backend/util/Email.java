/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.backend.util;

/**
 *
 * @author Norangel Moontes
 */
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import javax.mail.MessagingException;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Email {

    public static void sendEmail(String asunto, String[] destinatarios, String mensaje, String rutaArchivo, String nombreArchivo, String resource) throws NamingException, MessagingException {
        Session mailSession = (Session) new InitialContext().lookup(resource);
        MimeMessage message = new MimeMessage((Session) new InitialContext().lookup(resource));
        message.setFrom(new InternetAddress(mailSession.getProperty("mail.from")));
        InternetAddress[] internetAddresss = new InternetAddress[destinatarios.length];
        for(int i = 0 ; i < destinatarios.length ; i++){
            internetAddresss[i] = new InternetAddress(destinatarios[i]);
        }
        message.setRecipients(Message.RecipientType.TO, internetAddresss);
        message.setSubject(asunto);
        message.setSentDate(new Date());

        BodyPart texto = new MimeBodyPart();
        texto.setText(mensaje);

        BodyPart adjunto = new MimeBodyPart();
        if (!rutaArchivo.equals("")) {
            adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(rutaArchivo)));
            adjunto.setFileName(nombreArchivo);
        }

        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
        if (!rutaArchivo.equals("")) {
            multiParte.addBodyPart(adjunto);
        }
        message.setContent(multiParte);
        Transport.send(message);
    }
    
    public static void sendEmail(String asunto, String[] destinatarios, String content, String type, String resource) throws NamingException, MessagingException {
        Session mailSession = (Session) new InitialContext().lookup(resource);
        MimeMessage message = new MimeMessage((Session) new InitialContext().lookup(resource));
        message.setFrom(new InternetAddress(mailSession.getProperty("mail.from")));
        InternetAddress[] internetAddresss = new InternetAddress[destinatarios.length];
        for(int i = 0 ; i < destinatarios.length ; i++){
            internetAddresss[i] = new InternetAddress(destinatarios[i]);
        }
        message.setRecipients(Message.RecipientType.TO, internetAddresss);
        message.setSubject(asunto);
        message.setSentDate(new Date());
        message.setContent(content, type);
        Transport.send(message);
    }

}
