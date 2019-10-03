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
public class BoxTablet extends Medicine{




    private float pricePerTablet;
    private int tabletsPerBox;
    private int mg;

    public BoxTablet(float pricePerTablet, int tabletsPerBox, int mg, String name, String biologicalType, boolean inProduction, int shelfLife) {
        super(name, shelfLife);
        this.pricePerTablet = pricePerTablet;
        this.tabletsPerBox = tabletsPerBox;
        this.mg = mg;
        
        type = "BoxTablet";
    }

  
    @Override
    public void setPricePerItem(float pricePerTablet) {
        this.pricePerTablet = pricePerTablet;
    }

    @Override
    public void setItemsPerBox(int tabletsPerBox) {
        this.tabletsPerBox = tabletsPerBox;
    }

    @Override
    public void setMg(int mg) {
        this.mg = mg;
    }

    @Override
    public float getPricePerItem() {
        return pricePerTablet;
    }

    @Override
    public int getItemsPerBox() {
        return tabletsPerBox;
    }

    @Override
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

    @Override
    public int getMl() {
        return 0;
    }

    @Override
    public void setMl(int ml) {
    }
    
}


