/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DKD.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ADMIN
 */
public class App02HelloWorldSpring {
    public static void main(String[] args) {
        var context= new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        System.out.println(context.getBean("name"));
    }
}
