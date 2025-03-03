package com.expenses;

public class InfoKiosk extends SelfServiceMachine{
    //properties
    //constructors
    public InfoKiosk() {};
    public InfoKiosk(String location){
        super(location);
    };

    //methods 
    public void track(){
        System.out.println("This InfoKiosk is located at " + super.getLocation());
    }
    public void printInfo(){
        System.out.println("Some generic information.");
    }
}
