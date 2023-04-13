/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DKD.learnspringframework;


import com.DKD.learnspringframework.game.GameRunner;
import com.DKD.learnspringframework.game.MarioGame;



/**
 *
 * @author ADMIN
 */
public class AppGamingBasicJava {
    public static void main(String[] args) {
        var game  = new MarioGame();
//        var game= new SuperContraGame();
        var gameRunner= new GameRunner(game);
        gameRunner.run();
    }
}
