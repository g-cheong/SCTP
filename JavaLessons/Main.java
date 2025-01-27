// Practice Exercise for 3.1 and 3.2
// ATM Machine App

// Create a program that:
// has a menu system where the user select an option using an int
// user can 
// Check Balance
// Deposit Money
// Withdraw Money
// Exit the app
// balance should be stored using double
// Optional: user has to enter pin code in order to access the menu
// Optional: warn the user if the account falls below the minimum balance of $500

// Hints:
// while or do while loop for menu system
// System.console().readLine() for reading inputs

// Test cases
// Deposit 500
// Withdraw 600 -> fail
// Withdraw 10.88
// Enter menu item 8 -> fail
// Exit

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome, to TheBank.");
        int pin = 123456;
        boolean loggedIn = false;
        int loginTries = 0;
        boolean processing = true;
        
        // login block, allows for 3 numerical tries. Non-numerical not counted but prompts retry
        while(!loggedIn){
            try {
                int tryPin = Integer.parseInt(System.console().readLine("Please enter your pin: "));
                if(tryPin != pin){
                    System.out.println("Invalid pin number, please try again");
                    loginTries++;
                    if(loginTries >= 3) {
                        processing = false;
                        System.out.println("Too many invalid attempts, this card has been confiscated. Please contact TheBank for assistance.");
                        break;
                    }
                } else {
                    System.out.println("Logging in...");
                    System.out.println("Good morning User, how can we assist you today?");
                    loggedIn = true;
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter only numerical values.");
            }
        }

        // processing block
        while(processing){
            System.out.println("Press 1: To check your account balance");
            System.out.println("Press 2: To depost money");
            System.out.println("Press 3: To withdraw money");
            System.out.println("Press 4: To exit the app");
            
            enum Option {
                CheckBalance,
                Deposit,
                Withdraw,
                Exit
            };
            double balance = 400;
            try {
                System.out.println("\n");
                int choice = Integer.parseInt(System.console().readLine("Please enter your choice: "));
                Option chosen = switch(choice) {
                    case 1 -> Option.CheckBalance;
                    case 2 -> Option.Deposit;
                    case 3 -> Option.Withdraw;
                    case 4 -> Option.Exit;
                    default -> null;
                };

                if(chosen == null) continue;

                switch(chosen) {
                    case CheckBalance: 
                        System.out.println("Your balance is " + balance);
                        break;
                    case Deposit:
                        balance += Double.parseDouble(System.console().readLine("Enter the amount you would like to deposit: "));
                        System.out.println("Please insert the cash...");
                        System.out.println("Cash has been deposited");
                        System.out.println("Your updated balance is " + balance);
                        break;
                    case Withdraw:
                        double withdraw = Double.parseDouble(System.console().readLine("Enter the amount you would like to withdraw: "));
                        if(withdraw > balance){
                            System.out.println("You have insufficient balance available for the amount specified, please enter a different amount");
                        } else {
                            balance -= withdraw;
                            System.out.println("Your updated balance is " + balance);
                        }
                        break;
                    case Exit:
                        processing = false;
                        System.out.println("We hope to see you again, have a plesant day!");
                        break;
                    default:
                        System.out.println("You have entered an invalid option.");
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a number between 1 - 4.");
            }

            // prompt to inform user of bank balance
            if(balance <= 500){
                System.out.println("Your balance is below $500, please maintain a sufficient balance.");
            } 
        }
    }
}
