
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/**
 * Tests to understand the concepts of Multi-Threading in Java
 *
 * @author Z.B. Celik <celik.berkay@gmail.com>
 */
public class tests {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});

		String result = executorService.invokeAny(callables);

		System.out.println("result = " + result);
		
		List<Future<String>> futures = executorService.invokeAll(callables);

		for(Future<String> future : futures){
		    System.out.println("future.get = " + future.get());
		}

		executorService.shutdown();
	}
    public static void main1(String[] args) throws InterruptedException {
        //creating Random numbers
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("Integer random is: " + random.nextInt(10));
        }
        //semaphore , number of permits
        Semaphore sem = new Semaphore(1);
        sem.acquire();
        sem.release();
        sem.acquire();
        System.out.println("Available Permits " + sem.availablePermits());
        
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        executorService.shutdown();
    }

}
