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



import java.lang.Integer;  
public class Medicine {
    
   
     private static long medIDGenerator = 0;
     private String name; 
     private long ID; //long can also be used ( no option for using unsigned integer)
     private String biologicalType;
     private boolean inProduction;
     private int shelfLife; 

	 public Medicine(String name, int shelfLife) {
        
        this.biologicalType = biologicalType; 
        this.name = name;         
        this.shelfLife = shelfLife;
        long num = medIDGenerator;
        medIDGenerator++;
        this.ID = medIDGenerator;
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
            
    
    
}
