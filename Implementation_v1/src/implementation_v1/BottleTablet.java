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
public class BottleTablet extends Medicine{
    
    private float pricePerBottle;
    private int tabletsPerBottle;
    private int mg;

    public BottleTablet(float pricePerBottle, int tabletsPerBottle, int mg, int ID, String name, String biologicalType, boolean inProduction, int shelfLife) {
        super(name, shelfLife);
        this.pricePerBottle = pricePerBottle;
        this.tabletsPerBottle = tabletsPerBottle;
        this.mg = mg;
    }

    public void setpricePerBottle(float pricePerBottle) {
        this.pricePerBottle = pricePerBottle;
    }

    public void setTabletsPerBottle(int tabletsPerBottle) {
        this.tabletsPerBottle = tabletsPerBottle;
    }

    public void setMg(int mg) {
        this.mg = mg;
    }

    public float getpricePerBottle() {
        return pricePerBottle;
    }

    public int gettabletsPerBottle() {
        return tabletsPerBottle;
    }

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
    
    
    
    
}
