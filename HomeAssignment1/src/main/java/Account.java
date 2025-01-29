public class Account {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        this.balance += amount;
    }

    public double withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (amount > this.balance) {
            return 0;
        }
        this.balance -= amount;
        return amount;
    }

    public double getBalance() {
        return this.balance;
    }
}
