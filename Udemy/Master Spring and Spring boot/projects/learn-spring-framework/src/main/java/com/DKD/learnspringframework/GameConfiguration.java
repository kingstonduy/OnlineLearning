/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DKD.learnspringframework;

import com.DKD.learnspringframework.game.GameRunner;
import com.DKD.learnspringframework.game.GamingConsole;
import com.DKD.learnspringframework.game.MarioGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ADMIN
 */
@Configuration
public class GameConfiguration {
    @Bean
    public GamingConsole game(){
        var game= new MarioGame();
        return game;
    }
    @Bean
    public GameRunner gamerunner(GamingConsole game)
    {
        var gamerunner = new GameRunner(game);
        return gamerunner;
    }

    
}
