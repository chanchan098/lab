package thread;

public abstract class AbsThread extends Thread{
    public volatile boolean stop = false;
}
