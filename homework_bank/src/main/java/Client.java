import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Client implements Runnable {

    Bank bank;
    Lock lock;
    Random random = new Random();
    Condition condition;

    enum BankOps {
        DEPOSIT,
        CREDIT
    }

    public Client(Bank bank, Lock lock) {
        this.bank = bank;
        this.lock = lock;
        this.condition = lock.newCondition();

    }

    public void creditOrDeposit() {
        int rand = random.nextInt(2);
        if (rand == 0) {
            takeCredit(randAmount(BankOps.CREDIT));
        } else {
            giveDeposit(randAmount(BankOps.DEPOSIT));
        }
    }

    private void takeCredit(int amount) {
        try {
            lock.lock();
            while (!bank.giveCredit(amount)) {
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void giveDeposit(int amount) {
        lock.lock();
        while (!bank.takeDeposit(amount)) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private int randAmount(BankOps bankOps) {
        switch (bankOps) {
            case CREDIT:
                return random.nextInt(19500) + 501;
            case DEPOSIT:
                return random.nextInt(19500) + 1001;
            default:
                return 0;
        }
    }

    @Override
    public void run() {
        creditOrDeposit();
    }
}
