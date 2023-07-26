import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BankingSystem bankingSystem = new BankingSystem();
    private static String accountNo;
    private static final AccountNumberGenerator AccountNumberGenerator = new AccountNumberGenerator();

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System!");


        //System.out.println(Arrays.toString(arr));

        while (true) {
            displayMainMenu();
            int choice = readUserChoice();

            switch (choice) {
                case 1:
                    registerAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    miniStatement();
                    break;

                case 6:
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n1. Register Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Mini Statement");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int readUserChoice() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
        return choice;
    }

    private static void registerAccount() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Area: ");
        String area = scanner.nextLine();
        System.out.print("Enter Mobile Number: ");
        String mobileNo = scanner.nextLine();
        System.out.print("Enter Account Type (SAVING or CURRENT): ");
        String accountTypeStr = scanner.nextLine().toUpperCase();

        try {
            AccountType accountType = AccountType.valueOf(accountTypeStr);
            String[] arr = new String[20];
            arr = AccountNumberGenerator.generateRandomAccountNumbers(1);
            bankingSystem.registerAccount(name, area, mobileNo, arr[0], accountType);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid account type. Please enter either SAVING or CURRENT.");
        }
    }


    private static void deposit() {
        System.out.print("Enter Account Number: ");
        String depositAccountNo = scanner.nextLine();
        Account depositAccount = bankingSystem.getAccountByAccountNo(depositAccountNo);

        if (depositAccount != null) {
            System.out.print("Enter the amount to deposit: ");
            double depositAmount = readDoubleInput();
            if (depositAmount >= 0) {
                depositAccount.deposit(depositAmount);
                System.out.println("Amount deposited successfully!");
            } else {
                System.out.println("Invalid deposit amount. Please enter a non-negative number.");
            }
        } else {
            System.out.println("Account not found. Please check the account number.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter Account Number: ");
        String withdrawAccountNo = scanner.nextLine();
        Account withdrawAccount = bankingSystem.getAccountByAccountNo(withdrawAccountNo);

        if (withdrawAccount != null) {
            System.out.print("Enter the amount to withdraw: ");
            double withdrawAmount = readDoubleInput();
            if (withdrawAmount >= 0) {
                if (withdrawAccount.withdraw(withdrawAmount)) {
                    System.out.println("Amount withdrawn successfully!");
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Invalid withdrawal amount. Please enter a non-negative number.");
            }
        } else {
            System.out.println("Account not found. Please check the account number.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String balanceAccountNo = scanner.nextLine();
        Account balanceAccount = bankingSystem.getAccountByAccountNo(balanceAccountNo);

        if (balanceAccount != null) {
            System.out.println("Account Balance: " + balanceAccount.getBalance());
        } else {
            System.out.println("Account not found. Please check the account number.");
        }
    }

    private static void miniStatement() {
        System.out.print("Enter Account Number: ");
        String miniStatementAccountNo = scanner.nextLine();
        Account miniStatementAccount = bankingSystem.getAccountByAccountNo(miniStatementAccountNo);

        if (miniStatementAccount != null) {
            System.out.println(miniStatementAccount.getMiniStatement());
        } else {
            System.out.println("Account not found. Please check the account number.");
        }
    }

    private static double readDoubleInput() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
        return value;
    }
}
