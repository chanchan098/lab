package thread;


import thread.ObjectLock.RandomFloatObjectLock;
import thread.ObjectLock.RandomIntObjectLock;
import thread.ReentrantLock.RandomFloatReentrantLock;
import thread.ReentrantLock.RandomIntReentrantLock;

import java.util.concurrent.locks.ReentrantLock;


public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        reentrantLock();
//        objectLock();

    }

    private static void reentrantLock(){
        ReentrantLock lock = new ReentrantLock(true);
//        ReentrantLock lock = new ReentrantLock(true); // like synchronized
        RandomFloatReentrantLock randomFloatReentrantLock = new RandomFloatReentrantLock(lock);
        RandomIntReentrantLock randomIntReentrantLock = new RandomIntReentrantLock(lock);

        RandomNumberD randomNumberD = new RandomNumberD(randomFloatReentrantLock, randomIntReentrantLock);
        randomNumberD.setDaemon(true);

        randomNumberD.start();
        randomNumberD.startAll();
    }

    private static void objectLock() {
        Object lock = new Object();

        RandomIntObjectLock randomIntObjectLock = new RandomIntObjectLock(lock);
        RandomFloatObjectLock randomFloatObjectLock = new RandomFloatObjectLock(lock);
        RandomNumberD randomNumberD = new RandomNumberD(randomIntObjectLock, randomFloatObjectLock);
        randomNumberD.setDaemon(true);

        randomNumberD.start();
        randomNumberD.startAll();
    }
}
