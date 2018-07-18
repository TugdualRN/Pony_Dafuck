package com.pony.services;

import java.util.List;

import com.pony.enumerations.TokenType;
import com.pony.models.Role;
import com.pony.models.Token;
import com.pony.models.User;
import com.pony.utils.RegisterResult;

public interface UserService {

    // <editor-fold defaultstate="collapsed" desc="CRUD">
    List<User> findAll();

    User findById(Long userId);

    User findByUserName(String userName);
    
    User findByNormalizedUserName(String normalizedUserName);

    User findByMail(String mail);

    User findByNormalizedMail(String normalizedMail);

    User update(User user);

    void delete(User user);
    // <editor fold/>

    RegisterResult createUser(User user, String password);

    boolean hasRole(User user, Role role);
}