package com.pony.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MailValidator implements ConstraintValidator<ValidMail, String> {
     
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"; 
    
    @Override
    public void initialize(ValidMail constraintAnnotation) {       
    }
    
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context){   
        return (validateEmail(email));
    } 
    
    private boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}