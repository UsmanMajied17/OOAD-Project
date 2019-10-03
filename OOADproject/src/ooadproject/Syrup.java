/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

/**
 *
 * @author Ahmad Raza Khalid
 */
public class Syrup extends Medicine{
    
    private float pricePerBottle;
    private int ml; 

    public Syrup(float pricePerBottle, int ml, String name, String biologicalType, boolean inProduction, int shelfLife) {
        super(name,shelfLife);
        this.pricePerBottle = pricePerBottle;
        this.ml = ml;
        
        type = "Syrup";
    }

    @Override
    public void setPricePerItem(float pricePerBottle) {
        this.pricePerBottle = pricePerBottle;
    }

    @Override
    public void setMl(int ml) {
        this.ml = ml;
    }

    @Override
    public float getPricePerItem() {
        return pricePerBottle;
    }

    @Override
    public int getMl() {
        return ml;
    }

    @Override
    public void printDetails() {
        super.printDetails(); //To change body of generated methods, choose Tools | Templates.
         System.out.println("Price Per Bottle: " + pricePerBottle);
          System.out.println("ML: " + ml);
    }

    @Override
    public void setItemsPerBox(int itemsPerBox) {
    }

    @Override
    public void setMg(int mg) {
    }

    @Override
    public int getItemsPerBox() {
        return 0;
    }

    @Override
    public int getMg() {
        return 0;
    }
    
    
    
    
}
