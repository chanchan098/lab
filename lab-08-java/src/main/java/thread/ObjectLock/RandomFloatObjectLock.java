package thread.ObjectLock;

import thread.AbsThread;

import java.util.Random;

public class RandomFloatObjectLock extends AbsThread {
    private final Random random = new Random();
    private final Object lock;

    public RandomFloatObjectLock(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (!stop) {
                try {
                    System.out.println(RandomFloatObjectLock.class.getName() + ": " + random.nextFloat());
                    Thread.sleep(1000);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.notifyAll();
                }
            }
        }

        System.out.println(RandomFloatObjectLock.class.getName() + ": " + "quit");
    }
}
