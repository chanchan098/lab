package futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class SquareCalculator{
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input){
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
}

public class FTTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Integer> future = new SquareCalculator().calculate(5);
        while(!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = future.get();
        System.out.println(result);
        boolean canceled = future.cancel(true);

    }

}
