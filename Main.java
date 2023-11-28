import java.util.Scanner;

class Expense {
    String description;
    double amount;
    String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}

class ExpenseTracker {
    private Expense[] expenses;
    private int expenseCount;

    public ExpenseTracker() {
        expenses = new Expense[100]; // Maximum 100 expenses, you can adjust as needed
        expenseCount = 0;
    }

    public void addExpense(String description, double amount, String category) {
        if (expenseCount < expenses.length) {
            expenses[expenseCount++] = new Expense(description, amount, category);
            System.out.println("Expense added successfully!");
        } else {
            System.out.println("Expense limit reached. Cannot add more expenses.");
        }
    }

    public void viewExpenses() {
        if (expenseCount == 0) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.println("Expense List:");
        for (int i = 0; i < expenseCount; i++) {
            Expense expense = expenses[i];
            System.out.println("Description: " + expense.description + ", Amount: $" + expense.amount + ", Category: " + expense.category);
        }
    }

    public void expenseSummaries() {
        if (expenseCount == 0) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        double totalExpenses = 0;
        System.out.println("Expense Summaries:");

        for (int i = 0; i < expenseCount; i++) {
            totalExpenses += expenses[i].amount;
        }

        System.out.println("Total Expenses: $" + totalExpenses);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker expenseTracker = new ExpenseTracker();

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Expense Summaries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter expense description: ");
                    String description = scanner.next();
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter expense category: ");
                    String category = scanner.next();

                    expenseTracker.addExpense(description, amount, category);
                    break;

                case 2:
                    expenseTracker.viewExpenses();
                    break;

                case 3:
                    expenseTracker.expenseSummaries();
                    break;

                case 4:
                    System.out.println("Exiting Expense Tracker. Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}