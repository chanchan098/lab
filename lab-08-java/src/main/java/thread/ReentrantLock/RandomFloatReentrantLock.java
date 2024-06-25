package thread.ReentrantLock;

import thread.AbsThread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RandomFloatReentrantLock extends AbsThread {
    private final Random random = new Random();
    private final ReentrantLock lock;

    public RandomFloatReentrantLock(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        while (!stop) {
            try {
                lock.lock();
                System.out.println(RandomFloatReentrantLock.class.getName() + ": " + random.nextFloat());
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        System.out.println(RandomFloatReentrantLock.class.getName() + ": " + "quit");
    }
}
