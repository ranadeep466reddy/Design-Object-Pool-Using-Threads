import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.concurrent.TimeUnit;  
import java.util.concurrent.atomic.AtomicLong;  
public class Test{  
      private ObjectPool<Process> pool;  
      private AtomicLong processNo=new AtomicLong(0);  //set value of AtomicLong instance to zero initially 
      public void Create() {  
            
      pool = new ObjectPool<Process>(4, 10, 5) //create minimum 4 objects in pool, maximum 10 objects can be accommodated in pool, 5 seconds is the time in which periodical check happens to monitor minimum and maximum objects   
        {  
            protected Process createObject()  
            {    
                return new Process( processNo.incrementAndGet());  //Increments the AtomicLong type variable value
            }  
        };  
    }  
    public void Destroy() {  
        pool.shutdown();  
    }  
    public void create_object_pool() {  
        ExecutorService executor = Executors.newFixedThreadPool(8);  
  
        // execute 8 tasks in separate threads  
          
        executor.execute((Runnable) new Task(pool, 1));  
        executor.execute((Runnable) new Task(pool, 2));  
        executor.execute((Runnable) new Task(pool, 3));  
        executor.execute((Runnable) new Task(pool, 4));  
        executor.execute((Runnable) new Task(pool, 5));  
        executor.execute((Runnable) new Task(pool, 6));  
        executor.execute((Runnable) new Task(pool, 7));  
        executor.execute((Runnable) new Task(pool, 8));  
  
        executor.shutdown();  
        try {  
            executor.awaitTermination(30, TimeUnit.SECONDS);  
            } catch (InterruptedException e)  
              
              {  
               e.printStackTrace();  
              }  
    }  
    public static void main(String args[])  {   
        Test obj = new Test();  
        obj.Create();  
        obj.Destroy();  
        obj.create_object_pool();  
   }   
}  