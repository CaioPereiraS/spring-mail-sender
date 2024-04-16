package com.caiopereira.emailsender.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import com.caiopereira.emailsender.dtos.EmailDto;
import org.springframework.mail.MailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    private String htmlMessage = loadHtmlMessage();

    public EmailDto sendEmail(EmailDto emailDto) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailDto.getEmailFrom());
            helper.setTo(emailDto.getEmailTo());
            helper.setSubject(emailDto.getSubject());
            String processedHtml = htmlMessage.replace("%1", emailDto.getText());

            helper.setText(processedHtml, true);
            emailSender.send(message);
            return emailDto;

        } catch (MessagingException e) {
            throw new RuntimeException("Error Creating MimeMessageHelper");
        } catch (MailException e) {
            throw new RuntimeException("Error Sending Email");
        }
    }

    private String loadHtmlMessage() {
        try {
            Resource resource = new ClassPathResource("templates/email.html");
            return resource.getContentAsString(StandardCharsets.UTF_8);

        } catch (IOException e) {
            
            e.printStackTrace();
        }
        return "";
    }
}
