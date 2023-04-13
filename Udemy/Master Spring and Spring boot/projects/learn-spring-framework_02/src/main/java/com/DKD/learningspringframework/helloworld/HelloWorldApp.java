/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DKD.learningspringframework.helloworld;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ADMIN
 */

public class HelloWorldApp {
    public static void main(String[] args) {
    var context= new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    System.out.println(context.getBean("name"));
    System.out.println(context.getBean("age"));
    System.out.println(context.getBean(Address.class));    
   
   
    System.out.println(context.getBean("person2"));
    System.out.println(context.getBean("addressQualifier"));
    
  }
}