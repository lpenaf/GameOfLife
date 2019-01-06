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
public class Population {
    private final int[][] population;

    public Population(int size) {
        this.population = new int[size][size];
    }
    
    public Population(int pop[][]) {
        this.population = pop;
    }
    
    public int getCell(int x, int y){
        int size = this.population.length;
        
        if(0 <= x && x < size && 0 <= y && y < size)
            return this.population[x][y];
        throw new IndexOutOfBoundsException();
    }
    
    public void setCell(int x, int y, int value){
        int size = this.population.length;
        
        if(!(value == 0 || value == 1))
            throw new IllegalArgumentException();
        
        if(0 <= x && x < size && 0 <= y && y < size)
            this.population[x][y] = value;
        else
            throw new IndexOutOfBoundsException();
    }
    
    public Population getNextGeneration(){
        int size = this.population.length;
        int[][] nextGen = new int[size][size];
        int numOfNeighbors, xNeigh, yNeigh;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                numOfNeighbors = 0;
                
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        xNeigh = i + k;
                        yNeigh = j + l;
                        if(0 <= xNeigh && xNeigh < size && 0 <= yNeigh && yNeigh < size){
                            numOfNeighbors += this.population[xNeigh][yNeigh];
                        }
                    }
                }
                numOfNeighbors -= this.population[i][j];
                nextGen[i][j] = getNextGenerationCell(this.population[i][j], numOfNeighbors);
            }
        }
        return new Population(nextGen);
    }
    
    private int getNextGenerationCell(int currentValue, int numOfNeighbors){
        if(currentValue == 1 && (numOfNeighbors == 2 || numOfNeighbors == 3))
            return 1;
        if(currentValue == 0 && numOfNeighbors == 3)
            return 1;
        return 0;
    }
    
    @Override
    public String toString(){
        String strPop = "";
        int size = this.population.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                strPop += this.population[i][j] + " ";
            }
            strPop += "\n";
        }
        return strPop;
    }
    
}
