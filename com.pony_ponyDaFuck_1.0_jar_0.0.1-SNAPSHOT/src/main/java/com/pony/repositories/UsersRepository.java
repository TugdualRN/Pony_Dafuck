/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pony.repositories;


import com.pony.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Gotug
 */
public interface UsersRepository extends JpaRepository<Users, Long>{
     
     public Users findByLogin(String userLogin);
     
}