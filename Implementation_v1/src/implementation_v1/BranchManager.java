/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation_v1;

/**
 *
 * @author DELL
 */
public class BranchManager extends Person {
    private Branch branch = null;
    private int salary;

    public BranchManager( String name, int age, String gender, String CNIC ) {
        super(name, age, gender, CNIC);
    }
    
    public void setBranch( Branch branch )
    {
        
    }
    
    public Salesman addSalesman()
    {
    
    }
    
    private void assignBranchToSalesman( Salesman s )
    {
        s.setBranch( branch );
    }
    
    public void removeSalesman(  )
    {
        
    }
    
    public void viewInventory()
    {
        
    }
    
    public void reqForStock( Company company )
    {
        
    }
    
    public Branch getBranch()
    {
        return branch;
    }
    
    public int getSalary()
    {
        return salary;
    }
    
    public void setSalary( int sal )
    {
        salary = sal;
    }
}
