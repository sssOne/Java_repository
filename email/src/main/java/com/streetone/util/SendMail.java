package com.streetone.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.streetone.Exception.AppException;
import com.streetone.common.ErrorCodes;
import com.streetone.model.MailContext;

/**
 * @author Shalaka Nayal
 */
public class SendMail {

    private static final Logger LOGGER = Logger.getLogger(SendMail.class);
    private static final String MIME_TYPE = "text/html";

    public static void Sendmail(MailContext mailContext) throws IOException, AppException {

        System.out.println("Send mail Started");
        final Properties props = new Properties();
        InputStream input = null;

        String filename = "mailconfig.properties";

        Path configFilePath = Paths.get(filename);
        System.out.println("|| " + configFilePath.toUri().getPath());
        File file = new File(configFilePath.toAbsolutePath().toString());
        if (file.length() <= 0) {
            System.out.println("Cant fetch the file");
        }

        input = new FileInputStream(file);
        // input = SendMail.class.getClassLoader().getResourceAsStream(filename);
        if (input == null) {
            System.out.println("Sorry, unable to find " + filename);
            return;
        }

        props.load(input);

        System.out.println(props.getProperty("mail.smtp.auth"));
        System.out.println(props.getProperty("mail.smtp.port"));
        System.out.println(props.getProperty("mail.smtp.host"));

        props.put("mail.smtp.auth", props.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", props.getProperty("mail.smtp.port"));
        props.put("mail.smtp.host", props.getProperty("mail.smtp.host"));

        // props.put("mail.smtp.auth", "true");
        // props.put("mail.smtp.starttls.enable", "true");
        // props.put("mail.smtp.host", "smtp.gmail.com");
        // props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("FROM_MAIL_ADDRESS"), props
                        .getProperty("MAIL_PASSWORD"));
                // return new PasswordAuthentication("testerthakkar@gmail.com", "green123$");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(props.getProperty("FROM_MAIL_ADDRESS")));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailContext.getToAddress()));
            message.setSubject(mailContext.getSubject());
            message.setContent(mailContext.getBody(), MIME_TYPE);
            Transport.send(message);

            System.out.println("Mail Sent!!");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new AppException(ErrorCodes.SERVICE_UNAVAILABLE, e);
        } catch (Exception e) {
            throw new AppException(ErrorCodes.SERVICE_UNAVAILABLE, e);
        }
    }
}