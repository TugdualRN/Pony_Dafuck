/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pony.dtos;

/**
 *
 * @author Gotug
 */
public class RoleDto {
     
     private Long id;
     private String name;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     @Override
     public String toString() {
          return "RoleDto{" + "id=" + id + ", name=" + name + "}";
     }
     
     
}