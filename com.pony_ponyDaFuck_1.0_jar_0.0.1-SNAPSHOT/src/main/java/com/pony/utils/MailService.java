package com.pony.utils;

import java.util.List;

import com.pony.models.User;
import com.pony.models.Token;

public interface MailService {
    
    public void sendMail(String to, String subject, String body);

    public void sendMail(List<String> to, String subject, String body);

    public void SendRegisterMail(User user, Token token);

    public void SendResetPassword(User user, Token token);
}