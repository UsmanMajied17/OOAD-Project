/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

/**
 *
 * @author DELL
 */
public class Salesman extends Person{
    
    private Branch branch = null;
    private int salary;
    
    Salesman( String name, int age, String gender, String CNIC)
    {
        super(name, age, gender, CNIC);
        type="Salesman";
        
        salary = 50000;
    }
    
    public void setBranch( Branch branch )
    {
        this.branch = branch;
    }
    
    public boolean sellMedicine()
    {
     return true;   
    }
    
    private boolean checkIfDemandIsLessThanStock(int demand, MedicineReference med )
    {
        return ( demand <= med.getCount() );
    }
    
    public void searchMedicine()
    {
        
    }
    
    public Branch getBranch()
    {
        return  branch;
    }
    
    public int getSalary()
    {
        return salary;
    }
    
    public void setSalary(int sal)
    {
        salary = sal;
    }
    
    
}
