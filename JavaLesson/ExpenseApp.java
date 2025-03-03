import java.util.ArrayList;

public class ExpenseApp {
    enum ExpenseType {
        FOOD, TRANSPORT, ENTERTAINMENT, OTHERS
    };

    public static void main(String[] args) {
        System.out.println("Welcome to Expense App");
        boolean running = true;
        // ArrayList<Double> expenses = new ArrayList<Double>();
        ArrayList<ExpenseEntry> expenses2 = new ArrayList<ExpenseEntry>();
    
        while(running) {
            System.out.println("1. Add an expense.");
            System.out.println("2. List all expenses.");
            System.out.println("3. Calculate total expenses.");
            System.out.println("4. Calculate average expenses.");
            System.out.println("5. Exit.");
            try{
                int option = Integer.parseInt(System.console().readLine("Please enter your choice: "));
                switch(option){
                    case 1:
                        try{   
                            double expense = Double.parseDouble(System.console().readLine("Please enter expense amount: "));
                            String type = System.console().readLine("Enter an expense type: ");
                            ExpenseType typeEnum = ExpenseType.valueOf(type);
                            // expenses.add(expense);
                            ExpenseEntry entry = new ExpenseEntry(typeEnum, expense);
                            expenses2.add(entry);
                        } catch (Exception e){
                            System.out.println("Invalid input. Enter numerical decimal values for expenese amount or only [FOOD, TRANSPORT, ENTERTAINMENT, OTHERS] for expense types.");
                        }
                        break;
                    case 2:
                        // System.out.println(expenses);
                        System.out.println(expenses2);
                        break;
                    case 3:
                        // System.out.println("Your total expense is " + calcExpenseTotal(expenses));
                        System.out.printf("Your total expense is $%.2f\n", calcExpenseTotal(expenses2));
                        break;
                    case 4:
                        // System.out.printf("Your average expense is %.2f\n", calcExpenseTotal(expenses)/expenses.size());
                        System.out.printf("Your average expense is $%.2f\n", calcExpenseTotal(expenses2)/expenses2.size());
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default: 
                        System.out.println("That is an invalid option");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid entry. Enter a numerical digit from 1-5.");
            }
            System.out.println("\n");
        }
    }

    public record ExpenseEntry(ExpenseType type, double expenseAmount) {}

    // private static double calcExpenseTotal(ArrayList<Double> expenses) {
    //     double total = 0;
    //     for(double item: expenses) {
    //         total += item;
    //     }
    //     return total;
    // }

    private static double calcExpenseTotal(ArrayList<ExpenseEntry> expenses) {
        double total = 0;
        for(ExpenseEntry entry: expenses){
            total += entry.expenseAmount(); 
        }
        return total;
    }
}
