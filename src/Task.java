
public class Task implements Runnable{
	
	private ObjectPool<Process> pool;  
    private int threadNo;  
    public Task(ObjectPool<Process> pool, int threadNo){  
        this.pool = pool;  
        this.threadNo = threadNo;  
    }  
  
    public void run() {  
        // get an object from the pool  
        Process Process = pool.borrowObject();  
        System.out.println("Thread " + threadNo + ": Object with process no. "  
                + Process.getProcessNumber() + " was borrowed");
        
           // return Process instance back to the pool  
        pool.returnObject(Process);  

        System.out.println("Thread " + threadNo +": Object with process no. "  
               + Process.getProcessNumber() + " was returned");  
    }  

}
