
public class Process {
	
	private long processNo;  
	  
    public Process(long processNo)  {  
         this.processNo = processNo;    
      System.out.println("Object with process no. " + processNo + " was created");  
     }  
     
    public long getProcessNumber() {  
        return processNo;  
    }  

}
