package futures.and.callables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.*;

public class FutureAndCallableExample {
    public static void main(String[] args) throws InterruptedException, java.util.concurrent.ExecutionException {
        ExecutorService executorService = newSingleThreadExecutor();

        java.util.concurrent.Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);
        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
    }
}
