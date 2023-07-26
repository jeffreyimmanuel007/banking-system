public class Account {
    private String name;
    private String area;
    private String mobileNo;
    private String accountNo;
    private double balance;
    private AccountType accountType;

    public Account(String name, String area, String mobileNo, String accountNo, AccountType accountType) {
        this.name = name;
        this.area = area;
        this.mobileNo = mobileNo;
        this.accountNo = accountNo;
        this.balance = accountType == AccountType.CURRENT ? AccountType.CURRENT.getMinimumBalance() : 0.0;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (accountType == AccountType.SAVING && balance >= amount) {
            balance -= amount;
            return true;
        } else if (accountType == AccountType.CURRENT && (balance - amount) >= AccountType.CURRENT.getMinimumBalance()) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getMiniStatement() {
        return "Account Number: " + accountNo + "\nName: " + name + "\nArea: " + area + "\nMobile No: " + mobileNo
                + "\nAccount Type: " + accountType + "\nBalance: " + balance;
    }
}
