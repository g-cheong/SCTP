In the previous exercise, we created our VendingMachine class.   Imagine our company also supplies ClawMachine and InfoKiosk.

This time we want to create an abstract superclass SelfServiceMachine , which is a superclass of VendingMachine , ClawMachine and InfoKiosk.

We also have the following interfaces that can be used.

interface PaymentEnabled {
  void pay(double amount);
}

interface Trackable {
  void track();
}


Only VendingMachine  and ClawMachine  will have payment enabled
All SelfServiceMachine  should be trackable.


Create an abstract class SelfServiceMachine that implements Trackable
Refactor VendingMachine to be a subclass of SelfServiceMachine and implements PaymentEnabled
insertCoin()just becomes pay()
Create ClawMachine which also implements PaymentEnabled 
You can set a static final variable for the game price
It should have a play() method which always returns a prize
Optional: return a randomized prize
Create InfoKiosk 
It should have a printInfo() method that just outputs some generic information.


The objective is to practice Inheritance, Polymorphism and Abstraction/Interface.  Business logic is optional.

VendingMachine ntuVendingMachine = new VendingMachine("NTU");
ntuVendingMachine.pay(0.50); // 💵 Inserted 0.5
ntuVendingMachine.selectDrink(Drink.COKE); // 🧃 Selected COKE, ❌ Payment insufficient!
ntuVendingMachine.pay(2.00); // 💵 Inserted 2.0 
ntuVendingMachine.selectDrink(Drink.COKE); // 🧃 Selected COKE ✅ Payment sufficient! 🧃 Drink COKE dispensed.
ntuVendingMachine.printEarnings(); // 🤑 Earnings: 1.5
ntuVendingMachine.printTransactions(); // 🧾 Transactions: VendingTransaction[drink=COKE, amount=1.5]
ntuVendingMachine.track(); // Tracking VendingMachine NTU

ClawMachine ntuClawMachine = new ClawMachine("NTU");
ntuClawMachine.pay(20); // 💵 Inserted 20.0
ntuClawMachine.play(); // 🎮 Playing game... 🎁 You won a CANDY!
ntuClawMachine.printEarnings(); // Earnings: 18.0
ntuClawMachine.track(); // Tracking ClawMachine NTU

InfoKiosk ntuInfoKiosk = new InfoKiosk("NTU");
ntuInfoKiosk.printInfo(); // 📰 Printing info...
ntuInfoKiosk.track(); // Tracking InfoKiosk NTU