/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation_v1;

import java.util.Vector;

/**
 *
 * @author Wajahat Khann
 */
public class Sale {
    private Vector<MedicineSold> medicinesSold;
    private MFGDate date;
    public Sale(MFGDate d,Vector<MedicineSold> MS)
    {
        date=d;
        medicinesSold=MS;
    }
    public void decreaseCount(MedicineReference med, int quantity)
    {
        for(int i=0;i<medicinesSold.size();i++)
        {
            if(medicinesSold.get(i).getSoldMedicine().equals(med))
            {
               medicinesSold.get(i).getSoldMedicine().decrementCount(quantity);
            }
        }
    }
    public void printReceipt()
    {
        
    }
    public MFGDate getDate()
    {
        return date;
    }
    public Vector<MedicineSold> getMedicinesSold()
    {
        return medicinesSold;
    }
}
