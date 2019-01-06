/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Fernando
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Population p = new Population(20);
        for (int i = 5; i < 15; i++) {
            p.setCell(8, i, 1);
        }

        System.out.println(p.toString());
        for (int i = 0; i < 35; i++) {
            System.out.println("Generación " + (i + 1));
            p = p.getNextGeneration();
            System.out.println(p.toString());
        }
        
    }
    
}
