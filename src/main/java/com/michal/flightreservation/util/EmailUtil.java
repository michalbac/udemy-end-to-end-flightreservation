package com.michal.flightreservation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    @Value("${com.michal.flightreservation.itinerary.email.subject}")
    private String EMAIL_SUBJECT;

    @Value("${com.michal.flightreservation.itinerary.email.body}")
    private String EMAIL_TEXT;

    @Autowired
    private JavaMailSender sender;


    public void sendItinerary (String toAddress, String filePath){
        MimeMessage message = sender.createMimeMessage();
        LOGGER.info("Sending email started");
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject(EMAIL_SUBJECT);
            messageHelper.setText(EMAIL_TEXT);
            messageHelper.addAttachment("Itinerary", new File(filePath));
            sender.send(message);
            LOGGER.info("Email sent");
        } catch (MessagingException e){
            LOGGER.error("Sending email failed  " + e);
        }

    }
}
