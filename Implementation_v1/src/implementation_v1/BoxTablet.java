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
public class BoxTablet extends Medicine{
    
   
    private float pricePerTablet;
    private int tabletsPerBox;
    private int mg;

    public BoxTablet(float pricePerTablet, int tabletsPerBox, int mg, int ID, String name, String biologicalType, boolean inProduction, int shelfLife) {
        super(name, shelfLife);
        this.pricePerTablet = pricePerTablet;
        this.tabletsPerBox = tabletsPerBox;
        this.mg = mg;
        
        
    }

    
    

    public void setPricePerTablet(float pricePerTablet) {
        this.pricePerTablet = pricePerTablet;
    }

    public void setTabletsPerBox(int tabletsPerBox) {
        this.tabletsPerBox = tabletsPerBox;
    }

    public void setMg(int mg) {
        this.mg = mg;
    }

    public float getPricePerTablet() {
        return pricePerTablet;
    }

    public int getTabletsPerBox() {
        return tabletsPerBox;
    }

    public int getMg() {
        return mg;
    }

    @Override
    public void printDetails() {
        super.printDetails(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Price Per Tablet: " + pricePerTablet);
        System.out.println("Tablets Per Box: " + tabletsPerBox);
        System.out.println("Mg: " + mg);
    }
    
    
}
