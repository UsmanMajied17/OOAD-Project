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
public class MFGDate {
    private int Day;
    private int Month;
    private int Year;
    public MFGDate()
    {
        Day=0;
        Month=0;
        Year=0;
    }
    public MFGDate(int d,int m,int y)
    {
        Day=d;
        Month=m;
        Year=y;
    }
    public int getDay()
    {
        return Day;
    }
    public int getMonth()
    {
        return Month;
    }
    public int getYear()
    {
        return Year;
    }
    public void setDay(int d)
    {
        Day=d;
    }
    public void setMonth(int m)
    {
        Month=m;
    }
    public void setYear(int y)
    {
        Year=y;
    }
}
