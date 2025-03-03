package com.expenses;

import java.util.ArrayList;
import java.util.logging.Logger;

enum EPayment {PAYNOW, GRABPAY, FAVEPAY};
enum Drink {COKE, WATER};
record TransactionsHistory(Drink drink, double amount) {};

public class VendingMachine extends SelfServiceMachine implements PaymentEnabled {
  //properties
  ArrayList<TransactionsHistory> history = new ArrayList<>();
  private static final Logger logger = Logger.getLogger(VendingMachine.class.getName());

  //constructors
  public VendingMachine() {};
  public VendingMachine(String location) {
    super(location);
  };

  //methods
  public void track(){
    System.out.println("The vending machine is located at " + this.getLocation());
  }

  public void printEarnings() {
    System.out.println("The earnings for this vending machine is " + this.getEarnings());
  }

  public void printTransactions() {
    System.out.println(history);
  }

  public void pay(double amount) {
    logger.info("💰User has made a payment.");
    System.out.println("Accepting cash payment of " + amount);
    double inserted = this.getInserted();
    this.setInserted(inserted + amount);
    inserted = this.getInserted();
    System.out.println("Total inserted:" + inserted);
  }

  public void selectDrink(Drink choice) throws App.InsufficientPaymentException {
    logger.info("🧃User has selected a drink.");
    double inserted = this.getInserted();
    if(inserted >  1.50) {
      TransactionsHistory newEntry = new TransactionsHistory(choice, 1.5);
      history.add(newEntry);
      dispenseDrink();
      this.setEarnings(1.50 + this.getEarnings());
      this.setInserted(inserted - 1.50);
    } else {
      System.out.println("Insufficient amount inserted");
      String message = "Wrong amount inserted at " + this.getLocation();
    }
  }

  public void pay(EPayment payment) {

    boolean paymentSuccess = switch (payment) {
      case PAYNOW -> connectPayNow();
      case GRABPAY -> connectGrabPay();
      case FAVEPAY -> connectFavePay();
    };

    if (paymentSuccess) {
      dispenseDrink();
    } else {
      System.out.println("Payment unsuccessful.");
    }

  }

  private void dispenseDrink() {
    System.out.println("Dispensing drink...");
  }

  private boolean connectPayNow() {
    System.out.println("Connecting to PayNow...");
    System.out.println("PayNow Success ✅");
    return true;
  }

  private boolean connectGrabPay() {
    System.out.println("Connecting to GrabPay...");
    System.out.println("GrabPay Failed ❌");
    return false;
  }

  private boolean connectFavePay() {
    System.out.println("Connecting to FavePay...");
    System.out.println("FavePay Success ✅");
    return true;
  }

}
