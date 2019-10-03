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
public class BottleTablet extends Medicine{
    
     private float pricePerBottle;
    private int tabletsPerBottle;
    private int mg;

    public BottleTablet(float pricePerBottle, int tabletsPerBottle, int mg, String name, String biologicalType, boolean inProduction, int shelfLife) {
        super(name, shelfLife);
        this.pricePerBottle = pricePerBottle;
        this.tabletsPerBottle = tabletsPerBottle;
        this.mg = mg;
        
        type = "BottleTablet";
    }

      
    @Override
    public void setPricePerItem(float pricePerBottle) {
        this.pricePerBottle = pricePerBottle;
    }

    @Override
    public void setItemsPerBox(int tabletsPerBox) {
        this.tabletsPerBottle = tabletsPerBox;
    }

    @Override
    public void setMg(int mg) {
        this.mg = mg;
    }

    @Override
    public float getPricePerItem() {
        return pricePerBottle;
    }

    @Override
    public int getItemsPerBox() {
        return tabletsPerBottle;
    }

    @Override
    public int getMg() {
        return mg;
    }

    @Override
    public void printDetails() {
        super.printDetails(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Price Per Bottle: " + pricePerBottle);
        System.out.println("Tablets Per Bottle: " + tabletsPerBottle);
        System.out.println("Mg: " + mg);
    }

    @Override
    public int getMl() {
        return 0;
    }

    @Override
    public void setMl(int ml) {
    }

    
    
    
}
