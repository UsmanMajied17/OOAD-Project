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
 * @author DELL
 */
public class Company {

    private final String name;
    private ArrayList <Medicine> medicines;
    private ArrayList <Branch> branches;
    private ArrayList<Request> requests;

    public ArrayList<Branch> getBranches() {
        return branches;
    }
    
    

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }
    
    
    Company(String n)
    {
        name=n;
        requests= new ArrayList<>();
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
        branches.remove( branch );
        return true;
    }
    
    public Branch selectBranch( int branchCode )
    {
        //need an input to select a branch
        for (int i=0;i<branches.size();i++)
        {
            //select condition here
            
            if ( branches.get(i).getBranchCode() == branchCode )
            {
                return branches.get(i);
            }
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

    public ArrayList<Request> getRequests() {
        return requests;
    }
    
    
    
    
}
