/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooadproject;

import java.util.Vector;

/**
 *
 * @author DELL
 */
public class GeneralManager extends Person{
    private Company company = null;
    
    public GeneralManager( String name, int age, String gender, String CNIC) {
        super(name, age, gender, CNIC);
        type="GeneralManager";
    }
    
    public void setCompany( Company s )
    {
        company = s;
    }
    
    public boolean createBranch()
    {
        return true;
    }
    
    public BranchManager setBranchManager( Vector<BranchManager> branchManagers )
    {
        return null;
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
        return true;
    }
    
    public boolean handleReInvRequest()
    {
        return true;
    }

    @Override
    public Branch getBranch() {
    return null;
    }
}
