package com.expenses;

public abstract class SelfServiceMachine implements Trackable{
    //properties
    private String location;
    private double earnings, inserted;
    //constructors
    public SelfServiceMachine() {};
    public SelfServiceMachine(String location) {
        this.location = location;
        this.earnings = 0;
        this.inserted = 0;
    }
    //methods
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public double getEarnings() {
        return earnings;
    }
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }
    public double getInserted() {
        return inserted;
    }
    public void setInserted(double inserted) {
        this.inserted = inserted;
    }
}
