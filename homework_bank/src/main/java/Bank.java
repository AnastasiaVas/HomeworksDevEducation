import java.util.concurrent.atomic.AtomicInteger;

public class Bank {

    AtomicInteger totalCapital;
    AtomicInteger minBalance;
    AtomicInteger maxBalance;
    private static final AtomicInteger START_FUND = new AtomicInteger(50000);

    public Bank() {
        this.totalCapital = START_FUND;
        this.minBalance = new AtomicInteger(4000);
        this.maxBalance = new AtomicInteger(1000000);
    }

    public boolean giveCredit(int amount) {
        if (checkBalanceForCredit(amount)) {
            totalCapital.compareAndSet(totalCapital.get(), totalCapital.get() - amount);
            System.out.printf("Credit of %s was given. Total capital left is %s.\n", amount, totalCapital );
            return true;
        }
        return false;
    }

    public boolean takeDeposit(int amount) {
        if (checkBalanceForDeposit(amount)) {
            totalCapital.compareAndSet(totalCapital.get(), totalCapital.get() + amount);
            System.out.printf("Deposit of %s was taken. Total capital left is %s.\n", amount, totalCapital );
            return true;
        }
        return false;
    }

    private boolean checkBalanceForCredit(int amount) {
        return (totalCapital.get() - amount) > minBalance.get();
    }

    private boolean checkBalanceForDeposit(int amount) {
        return (totalCapital.get() + amount) <= maxBalance.get();
    }
}
