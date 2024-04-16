package com.caiopereira.emailsender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caiopereira.emailsender.dtos.EmailDto;
import com.caiopereira.emailsender.services.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<EmailDto> sendingEmail(@RequestBody @Valid EmailDto emailDto) {

        emailService.sendEmail(emailDto);
        return new ResponseEntity<>(emailDto, HttpStatus.CREATED);
    }

}
