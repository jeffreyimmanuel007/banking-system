public enum AccountType {
    SAVING(0),
    CURRENT(500);

    private double minimumBalance;

    AccountType(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }
}
