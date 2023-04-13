/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DKD.learnspringframework.game;

/**
 *
 * @author ADMIN
 */
public class GameRunner {
    private GamingConsole game;
    public GameRunner(GamingConsole game)
    {
        this.game= game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
