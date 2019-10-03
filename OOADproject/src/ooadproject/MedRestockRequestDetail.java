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
public class MedRestockRequestDetail {
    private MedicineReference med;
    private int demand;
    public MedRestockRequestDetail(MedicineReference MR, int d)
    {
        med=MR;
        demand=d;
    }
    public int getDemand()
    {
        return demand;
    }
    public MedicineReference getMedicineReference()
    {
        return med;
    }
}
