package thread;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomNumberD extends Thread {

    private final List<AbsThread> absThreads;
    private final AtomicInteger running;

    public RandomNumberD(AbsThread... absThreads) {
        this.absThreads = Arrays.asList(absThreads);
        this.running = new AtomicInteger(this.absThreads.size());
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (this.running.get() > 0) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if ("q".equals(input)) {
                    // 如果输入的是 'q'，则设置停止标志并跳出循环
                    for (AbsThread absThread : absThreads) {
                        absThread.stop = true;
                        this.running.set(this.running.get()-1);
                    }
                }
            }
        }

    }


    public void startAll() {
        for (AbsThread absThread : absThreads) {
            absThread.start();
        }
    }
}
