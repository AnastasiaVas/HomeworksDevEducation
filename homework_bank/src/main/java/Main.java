import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Bank bank = new Bank();
        Lock clientLock = new ReentrantLock(true);
        Lock timingLock = new ReentrantLock();
        Condition condition = timingLock.newCondition();

        for (int i = 0; i < 10000; i++) {
            try {
                timingLock.lock();
                condition.await(10, TimeUnit.MILLISECONDS);
                executorService.submit(new Client(bank, clientLock));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                timingLock.unlock();
            }
        }
    }
}
