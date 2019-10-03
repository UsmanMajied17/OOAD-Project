/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Wajahat Khann
 */
public class Sale {
    private ArrayList<MedicineSold>  medicinesSold;
    private MFGDate date;
    
    public Sale(MFGDate d,ArrayList<MedicineSold> MS)
    {
        date=d;
        medicinesSold=MS;
    }
    public void decreaseCount(/*MedicineReference med, int quantity*/)
    {
        for(int i=0;i<medicinesSold.size();i++)
        {
            medicinesSold.get(i).decrementCount();
        }
    }
   
    
    public MFGDate getDate()
    {
        return date;
    }
    public ArrayList<MedicineSold> getMedicinesSold()
    {
        return medicinesSold;
    }
}
