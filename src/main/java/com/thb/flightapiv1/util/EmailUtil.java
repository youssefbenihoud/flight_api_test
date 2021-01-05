package com.thb.flightapiv1.util;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.MessagingException;
import javax.mail.Message.RecipientType;
 
/**
 *
 * @author Benihoud Youssef
 */
public class EmailUtil {
 
    public static boolean sendMail( String message, String to, String subject) throws MessagingException {
        System.out.println("========= SEND MAIL ==========");
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "XXXX@gmail.com");
        props.put("mail.smtp.password", "PASSWORD");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.connectiontimeout", 10000);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress("XXXXX@gmail.com"));
//            InternetAddress[] toAdress=new InternetAddress[to.length];
//            for(int i=0;i<toAdress.length;i++){
            System.out.println("=== emailUtil ===");
            mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(to));
//            }
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message, "UTF-8", "html");
            System.out.println("=== Content === <br/> " + mimeMessage.getContent());
            Transport transport = session.getTransport("smtp");
            transport.connect(host,"XXXXX@gmail.com","PASSWORD");
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return false;
    }
}