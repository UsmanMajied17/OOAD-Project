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
public abstract class Medicine {
    
    
     private static long medIDGenerator = 0;
     private String name; 
     private long ID; //long can also be used ( no option for using unsigned integer)

    public static long getMedIDGenerator() {
        return medIDGenerator;
    }

    public long getID() {
        return ID;
    }

    public String getBiologicalType() {
        return biologicalType;
    }

    public boolean isInProduction() {
        return inProduction;
    }
     private String biologicalType;
     private boolean inProduction;
     private int shelfLife;
     protected String type;
     public Medicine()
     {
         name=null;
         ID=0;
         biologicalType=null;
         inProduction=false;
         shelfLife=0;
     }
     
    public String getName() {
        return name;
    }
     

    public String getType() {
        return type;
    }
     
	 public Medicine(String name, int shelfLife) {
        
        this.biologicalType = biologicalType; 
        this.name = name;         
        this.shelfLife = shelfLife;
        long num = medIDGenerator;
        this.ID = medIDGenerator;
        medIDGenerator++;
        
//        
    }

    public void setBiologicalType(String biologicalType) {
        this.biologicalType = biologicalType;
    }

    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }

    public boolean getInProduction() {
        return inProduction;
    }

    public int getShelfLife() {
        return shelfLife;
    }
     
    public void printDetails()
    {
        
        System.out.println("Details: ");
        
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Biological Type: "+ biologicalType);
        System.out.println("In Production: " + inProduction);
        System.out.println("Shelf Life: " + shelfLife);
        
    
    
    }
       
    public abstract void setPricePerItem(float pricePerItem);

    public abstract void setItemsPerBox(int itemsPerBox);

    public abstract void setMg(int mg);

    public abstract float getPricePerItem();

    public abstract int getItemsPerBox();

    public abstract int getMg();
    
    public abstract int getMl();
    
    public abstract void setMl(int ml);
    
    
}
