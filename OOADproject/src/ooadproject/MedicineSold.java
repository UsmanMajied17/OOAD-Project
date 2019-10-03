/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

/**
 *
 * @author Wajahat Khann
 */
public class MedicineSold {
    private int quantity;
    private MedicineReference soldMedicine;
    
    public MedicineSold(MedicineReference MR, int q)
    {
        soldMedicine=MR;
        quantity=q;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public MedicineReference getSoldMedicine()
    {
        return soldMedicine;
    }
    public void decrementCount()
    {
        soldMedicine.decrementCount(quantity);
    }
}
