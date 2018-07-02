package com.pony.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class Mailer {

    private MailSender _mailSender;

    private String _sender;

    public Mailer(MailSender mailSender, String sender)
    {
        _mailSender = mailSender;
        _sender = sender;
    }

    public void sendMail(String to, String subject, String body) {
        List<String> lst = new ArrayList<String>();
        lst.add(to);

        sendMail(lst, subject, body);
    }

    public void sendMail(List<String> to, String subject, String body) {
        
        SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(_sender);
		message.setTo(to.toArray(new String[to.size()]));
		message.setSubject(subject);
        message.setText(body);
        
		_mailSender.send(message);
    }
}