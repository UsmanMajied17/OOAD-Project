/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation_v1;

import java.util.Vector;

/**
 *
 * @author DELL
 */
public class GeneralManager extends Person{

    private Company company = null;
    
    public GeneralManager( String name, int age, String gender, String CNIC ) {
        super(name, age, gender, CNIC);
    }
    
    public void setCompany( Company s )
    {
        company = s;
    }
    
    public boolean createBranch()
    {
        
    }
    
    public BranchManager setBranchManager( Vector<BranchManager> branchManagers )
    {
        
    }
    
    public void viewBranchInventory()
    {
        
    }
    
    public void viewBranchReport()
    {
        
    }
    
    public Company getCompany()
    {
        return company;
    }
    
    public boolean removeBranch()
    {
        
    }
    
    public boolean handleReInvRequest()
    {
        
    }
}
