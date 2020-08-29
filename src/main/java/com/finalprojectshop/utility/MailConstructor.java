package com.finalprojectshop.utility;

import com.finalprojectshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MailConstructor {
    @Autowired
    private Environment env;

    public SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, User user, String password
    ) {
        String url = contextPath + "/newUser?token=" + token;
        String message = "\nPlease click on this link to verify email. Your password is:" + password;
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Hydrofrajda - new USer");
        email.setText(url + message);
        email.setFrom(env.getProperty("support.email"));
        return email;

    }

}
