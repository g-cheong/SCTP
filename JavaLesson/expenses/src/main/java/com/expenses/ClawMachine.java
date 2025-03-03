package com.expenses;

public class ClawMachine extends SelfServiceMachine implements PaymentEnabled {
    //properties
    private final static double gamePrice = 2;
    
    //constructors
    public ClawMachine() {};
    public ClawMachine(String location){
        super(location);
    }
    
    //methods
    public void track(){
        System.out.println("The vending machine is located at " + this.getLocation());
      }

    public void pay(double amount) {
        System.out.println("Accepting cash payment of " + amount);
        double inserted = this.getInserted();
        this.setInserted(inserted + amount);
        inserted = this.getInserted();
        System.out.println("Total inserted:" + inserted);
        play();
    }

    public void printEarnings() {
        System.out.println("The earnings for this ClawMachine is " + this.getEarnings());
    }

    public void play() {
        String[] prize = {"Bear", "RC car", "iPhone", "Pencil", "Nothing" };
        System.out.println("You have won " + prize[((int) (Math.random()*10) / 2)] + "!");
        double inserted = this.getInserted();
        if(inserted >  gamePrice) {
            inserted = this.getInserted() - gamePrice;
            this.setEarnings(gamePrice + this.getEarnings());
            this.setInserted(inserted - gamePrice);
        } else {
            System.out.println("Insufficient amount inserted");
        }
    }

    public static double getGameprice() {
        return gamePrice;
    }
}
