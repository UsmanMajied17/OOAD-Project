/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation_v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author darkage
 */
public class Company {
    private final String name;
    private List <Medicine> medicines;
    private List <Branch> branches;
    Vector<Request> requests;
    
    Company(String n)
    {
        name=n;
        requests= new Vector();
        medicines= new ArrayList();
        branches=new ArrayList();
    }
    
    public void storeMedicine(Medicine med)
    {
        medicines.add(med);
    }
    
    public boolean storeBranch(Branch branch)
    {
        branches.add(branch);
        return true;
    }
    
    public void listAllBranches()
    {
        for (int i=0;i<branches.size();i++)
        {
            //cout branchcode and location
        }
    }
    
    public boolean removeBranchFromList(Branch branch)
    {
        for (int i=0;i<branches.size();i++)
        {
            if (branches.get(i).getBranchCode()==branch.getBranchCode())
            {
                branches.remove(i); //delete branch aswell?
                return true;
            }
        }
        return false;
    }
    
    public Branch selectBranch()
    {
        //need an input to select a branch
        for (int i=0;i<branches.size();i++)
        {
            //select condition here
        }
        
        return null;
    }
    
    public void recieveRequest( Request req)
    {
        //add request to db?
        requests.add(req);
    }
    
    public boolean processRequest(Branch branch)
    {
        //delete request from db?
        //return bool on bases of general manager?
        return true;
    }
    
    
 
    
}
