/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DKD.learnspringframework;

import com.DKD.learnspringframework.game.GamingConsole;
import com.DKD.learnspringframework.game.GameRunner;
import com.DKD.learnspringframework.game.MarioGame;
import com.DKD.learnspringframework.game.SuperContraGame;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ADMIN
 */

@Configuration
@ComponentScan("com.DKD.learnspringframework.game")
public class App03HelloWorldSpring {
    
    public static void main(String[] args) {
        var context= new AnnotationConfigApplicationContext(App03HelloWorldSpring.class);
        
        context.getBean(GameRunner.class).run();


                

    }
    
}
