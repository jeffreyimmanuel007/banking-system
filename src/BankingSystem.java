import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankingSystem {
    private Map<String, Account> accounts;

    public BankingSystem() {
        accounts = new HashMap<>();
    }

    private String generateRandomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private String generateRandomAccountNumber() {
        String accountNumber = generateRandomUUID();
        return accountNumber.substring(0, 10);
    }

    public void registerAccount(String name, String area, String mobileNo, String accountNo, AccountType accountType) {
        if (accounts.containsKey(accountNo)) {
            System.out.println("Account number already exists. Please choose a different account number.");
        } else {
            Account newAccount = new Account(name, area, mobileNo, accountNo, accountType);
            accounts.put(accountNo, newAccount);
            System.out.println("Account registered successfully!");
            System.out.println("Account Number: " + accountNo);
        }
    }

    public Account getAccountByAccountNo(String accountNo) {
        return accounts.get(accountNo);
    }
}


