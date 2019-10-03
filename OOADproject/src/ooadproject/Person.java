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
public abstract class Person {
    
    private static long empIDGenerator = 0;
    protected long empID;
    protected String name;

    public void setEmpID(long empID) {
        this.empID = empID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }
    protected int age;
    protected String gender;
    protected String CNIC;
    protected String password;

    public static long getEmpIDGenerator() {
        return empIDGenerator;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }
    protected String type;

    public long getEmpID() {
        return empID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCNIC() {
        return CNIC;
    }
    

    
    public Person( String name, int age, String gender, String CNIC) {
        empID = empIDGenerator;
        
        empIDGenerator++;
        
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.CNIC = CNIC;
    }
    public void setType(String t)
    {
        type=t;
    }
    
    public String getType()
    {
        return type;   
    }
    public void setPassword( String password )
    {
        this.password = password;
    }
    
    public boolean validate( int ID, String pass )
    {
        return empID == ID && password.equals(pass);
    }

    public abstract Branch getBranch();
}
