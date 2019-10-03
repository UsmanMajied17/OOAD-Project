/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation_v1;

import java.util.List;

/**
 *
 * @author darkage
 */
public class Branch {
    private static int branchCodeGenerator;
    private final int branchCode;
    private final String location;
    private List<MedicineReference> stock;
    private List<Sale> sales;
    private List<Salesman> salesmen;
    //private static int counter = 0;

    public Branch(int branchCode, String location) {
        this.branchCode = branchCodeGenerator++;
        this.location = location;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public String getLocation() {
        return location;
    }

    public List<MedicineReference> getStock() {
        return stock;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public List<Salesman> getSalesmen() {
        return salesmen;
    }
    
    
    
}
