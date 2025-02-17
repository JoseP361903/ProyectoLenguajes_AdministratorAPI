package com.project.util;

import com.project.model.Professor;
import com.project.model.Student;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Security {

    //method to send email
    public static void sendAcceptedMail(Student student){
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("learnwiseenterprise2024@gmail.com","qjwrtehukxbcydiw");
            }
        });
        MimeMessage message = new MimeMessage(session);
        try {
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(student.getEmail(),true)));
            message.setSubject("Aceptación de Registro.");
            message.setText("Hola, " + student.getName()
                    + " " + student.getLastName()+
                    "\nNos complace informarte que has sido aceptado/a enterate de todas las novedades de la carrera. \n" +
                    "Atentamente, learnwiseenterprise2024@gmail.com"
                    + "\nDate: " + LocalDate.now() + "\nHour: " + LocalTime.now());
            Transport.send(message);
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendAcceptedMail(Professor professor){
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("learnwiseenterprise2024@gmail.com","qjwrtehukxbcydiw");
            }
        });
        MimeMessage message = new MimeMessage(session);
        try {
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(professor.getEmail(),true)));
            message.setSubject("Aceptación de Registro.");
            message.setText("Hola, " + professor.getName()
                    + " " + professor.getLastName()+
                    "\nNos complace informarte que has sido ingresado dentro de nuestra aplicación, puedes iniciar tus funciones como profesor. \n" +
                    "Atentamente, learnwiseenterprise2024@gmail.com"
                    + "\nDate: " + LocalDate.now() + "\nHour: " + LocalTime.now());
            Transport.send(message);
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    public static void sendDeletedMail(Student student){
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("learnwiseenterprise2024@gmail.com","qjwrtehukxbcydiw");
            }
        });
        MimeMessage message = new MimeMessage(session);
        try {
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(student.getEmail(),true)));
            message.setSubject("Eliminación del sistema.");
            message.setText("Hola, " + student.getName()
                    + " " + student.getLastName()+
                    "\nLamentamos informale que usted ha sido eliminado de nuestro sistema. \n" +
                    "Atentamente, learnwiseenterprise2024@gmail.com"
                    + "\nDate: " + LocalDate.now() + "\nHour: " + LocalTime.now());
            Transport.send(message);
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendDeletedMail(Professor professor){
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("learnwiseenterprise2024@gmail.com","qjwrtehukxbcydiw");
            }
        });
        MimeMessage message = new MimeMessage(session);
        try {
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(professor.getEmail(),true)));
            message.setSubject("Eliminación del sistema.");
            message.setText("Hola, " + professor.getName()
                    + " " + professor.getLastName()+
                    "\nLamentamos informale que usted ha sido eliminado de nuestro sistema. \n" +
                    "Atentamente, learnwiseenterprise2024@gmail.com"
                    + "\nDate: " + LocalDate.now() + "\nHour: " + LocalTime.now());
            Transport.send(message);
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
