/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation_v1;

import java.util.Date;
/**
 *
 * @author Wajahat Khann
 */
public class MedicineReference {
    private final Medicine medDetails;
    private int count;
    private final MFGDate date;
    public MedicineReference(Medicine medD,int quantity)
    {
        medDetails=medD;
        count=quantity;
        date=new MFGDate();
    }
    public int getCount()
    {
        return count;
    }
    public void incrementCount(int inc)
    {
        count+=inc;
    }
    public void decrementCount(int dec)
    {
        count-=dec;
    }
    public MFGDate getMFG()
    {
        return date;
    }
    public void setMFG(int d,int m,int y)
    {
        date.setDay(d);
        date.setMonth(m);
        date.setYear(y);
    }
    public Medicine getMedicineDetails()
    {
        return medDetails;
    }
    public boolean isExpired()
    {
        Date SDate = new Date();
        Date MDate = new Date(date.getYear()-1900,date.getMonth()-1,date.getDay());
        if(SDate.compareTo(MDate)==1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
