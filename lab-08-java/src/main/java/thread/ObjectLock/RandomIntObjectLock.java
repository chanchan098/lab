package thread.ObjectLock;

import thread.AbsThread;

import java.util.Random;

public class RandomIntObjectLock extends AbsThread {
    private final Random random = new Random();
    private final Object lock;

    public RandomIntObjectLock(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (!stop) {
                try {
                    System.out.println(RandomIntObjectLock.class.getName() + ": " + random.nextInt());
                    Thread.sleep(1000);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.notifyAll();
                }
            }
        }

        System.out.println(RandomIntObjectLock.class.getName() + ": " + "quit");
    }
}
