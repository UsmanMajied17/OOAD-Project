/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation_v1;

import java.util.ArrayList;

/**
 *
 * @author Wajahat Khann
 */
public class Request {
    private ArrayList<MedRestockRequestDetail> list;
    private MFGDate date;
    private Branch branch;
    public Request(MFGDate d, Branch b)
    {
        date=d;
        branch=b;
    }
    public ArrayList<MedRestockRequestDetail> getList()
    {
        return list;
    }
    public MFGDate getDate()
    {
        return date;
    }
    public Branch getBranch()
    {
        return branch;
    }
    public void addMedicine(MedicineReference med, int demand)
    {
        MedRestockRequestDetail m = new MedRestockRequestDetail(med, demand);
        list.add(m);
    }
}
