package thread.ReentrantLock;

import thread.AbsThread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RandomIntReentrantLock extends AbsThread {
    private final Random random = new Random();
    private final ReentrantLock lock;

    public RandomIntReentrantLock(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        while (!stop) {
            try {
                lock.lock();
                System.out.println(RandomIntReentrantLock.class.getName() + ": " + random.nextInt());
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        System.out.println(RandomIntReentrantLock.class.getName() + ": " + "quit");
    }
}
