package com.expenses;

import java.util.logging.Logger;

class InsufficientPaymentException extends RuntimeException {

    public InsufficientPaymentException(String message) {
        super(message);
    }
}

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        VendingMachine ntuVendingMachine = new VendingMachine("NTU");
        ClawMachine nusClawMachine = new ClawMachine("NUS");
        InfoKiosk smuInfoKiosk = new InfoKiosk("SMU");
        try {
            logger.info("🎬App has started!");
            
            ntuVendingMachine.pay(0.50); // 💵 Inserted 0.5
            ntuVendingMachine.selectDrink(Drink.COKE); // 🧃 Selected COKE, ❌ Payment insufficient!
            ntuVendingMachine.pay(2.00); // 💵 Inserted 2.0 
            ntuVendingMachine.selectDrink(Drink.COKE); // 🧃 Selected COKE ✅ Payment sufficient! 🧃 Drink COKE dispensed.
            ntuVendingMachine.selectDrink(Drink.WATER);
            ntuVendingMachine.pay(1);
            ntuVendingMachine.selectDrink(Drink.WATER);
            ntuVendingMachine.printEarnings(); // 🤑 Earnings: 1.5
            ntuVendingMachine.printTransactions(); // 🧾 Transactions: VendingTransaction[drink=COKE, amount=1.5]
            ntuVendingMachine.track(); // Tracking VendingMachine NTU
            
            System.out.println();
            nusClawMachine.pay(20); // 💵 Inserted 20.0
            nusClawMachine.play();
            nusClawMachine.printEarnings(); // Earnings: 18.0
            nusClawMachine.track(); // Tracking ClawMachine NTU
            
            System.out.println();
            smuInfoKiosk.printInfo(); // 📰 Printing info...
            smuInfoKiosk.track(); // Tracking InfoKiosk NTU
        } catch(InsufficientPaymentException e) {
            String message = "Insufficient amount inserted at ";
            logger.severe(message);
            System.out.println(message);
        }
    }
}
