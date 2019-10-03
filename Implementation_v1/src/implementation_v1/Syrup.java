/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Ahmad Raza Khalid
 */
public class Syrup extends Medicine {
    
    
    private int pricePerBottle;
    private int ml; 

    public Syrup(int pricePerBottle, int ml, int ID, String name, String biologicalType, boolean inProduction, int shelfLife) {
        super(name,shelfLife);
        this.pricePerBottle = pricePerBottle;
        this.ml = ml;
    }

    public void setPricePerBottle(int pricePerBottle) {
        this.pricePerBottle = pricePerBottle;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public int getPricePerBottle() {
        return pricePerBottle;
    }

    public int getMl() {
        return ml;
    }

    @Override
    public void printDetails() {
        super.printDetails(); //To change body of generated methods, choose Tools | Templates.
         System.out.println("Price Per Bottle: " + pricePerBottle);
          System.out.println("ML: " + ml);
    }
    
    
    
    
}
