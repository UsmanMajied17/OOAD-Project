/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Branch {
    
    private static int branchCodeGenerator = 0;
    private final int branchCode;
    private final String location;
    private ArrayList<MedicineReference> stock;

    public ArrayList<MedicineReference> getStock() {
        return stock;
    }
    private ArrayList<Sale> sales;
    private ArrayList<Salesman> salesmen;
    //private static int counter = 0;

    public static int getBranchCodeGenerator() {
        return branchCodeGenerator;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    
    public ArrayList<Salesman> getSalesmen() {
        return salesmen;
    }

    public Branch(String location) {
        this.branchCode = branchCodeGenerator++;
        this.location = location;
        
        stock = new ArrayList<>();
        sales = new ArrayList<>();
        salesmen = new ArrayList<>();
    }

    public int getBranchCode() {
        return branchCode;
    }

    public String getLocation() {
        return location;
    }

    public void receiveNewStock( ArrayList<MedicineReference> newStock )
    {
        for ( int i = 0 ; i < newStock.size(); i++ )
        {
            stock.add( newStock.get(i) ) ;
        }
    }
    
    
    public void addSalesman( Salesman s )
    {
        salesmen.add(s);
    }
    
    public ArrayList<MedicineReference> filter( String filter )
    {
        if ( filter == null )
        {
            return stock;
        }
        
        ArrayList<MedicineReference> returnValue = new ArrayList<>();
        
        for ( int i = 0 ; i < stock.size(); i++ )
        {
            if ( stock.get(i).getName().startsWith(filter) )
            {
                returnValue.add( stock.get(i) );
            }
        }
        
        return returnValue;
    }
    
    public void registerSale( ArrayList<MedicineSold> order )
    {
        LocalDate now = LocalDate.now();
        
        Sale newSale = new Sale( new MFGDate(  now.getDayOfMonth() , now.getMonthValue(), now.getYear() ), order );
        
        sales.add(newSale);
        
        newSale.decreaseCount();
    }
}
