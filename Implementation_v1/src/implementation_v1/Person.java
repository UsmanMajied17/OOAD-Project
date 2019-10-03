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
public abstract class Person {
    
    private static long empIDGenerator = 0;
    protected long empID;
    protected String name;
    protected int age;
    protected String gender;
    protected String CNIC;
    protected String password;

    public Person( String name, int age, String gender, String CNIC ) {
        empID = empIDGenerator;
        
        empIDGenerator++;
        
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.CNIC = CNIC;
    }
    
    public void setPassword( String password )
    {
        this.password = password;
    }
    
    public boolean validate( int ID, String pass )
    {
        return empID == ID && password.equals(pass);
    }
    
    
}
