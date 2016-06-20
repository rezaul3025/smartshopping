package org.smart.shoping.persistence.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("singleton")
public class LongRunningService implements  Runnable{
	
	@Override
	public void run()
	{
		int i=0;
		for(;;){
			System.out.println("One thread running ...");
			i++;
			
		}
	}
	
	/*public void start()
	{
		executor.submit(() -> {
			for(;;){
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
			}
			
		});
	}
	
	public void stop()
	{
		try {
		    System.out.println("attempt to shutdown executor");
		    executor.shutdown();
		    executor.awaitTermination(5, TimeUnit.SECONDS);
		    
		}
		catch (InterruptedException e) {
		    System.err.println("tasks interrupted");
		}
		finally {
		    if (!executor.isTerminated()) {
		        System.err.println("cancel non-finished tasks");
		    }
		    executor.shutdownNow();
		    System.out.println("shutdown finished");
		}
	}*/
}
