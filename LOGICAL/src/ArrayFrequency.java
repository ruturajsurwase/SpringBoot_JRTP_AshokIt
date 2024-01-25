
public class ArrayFrequency
{
	
	public static void main(String[] args)
	{
		int[] arr = { 40, 50, 30, 40, 50, 30, 30,30};
	 
		int maxcount = 0;
	
		int element_having_max_freq = 0;
    
    			for (int i = 0; i < arr.length; i++)
    			{
    					int count = 0;
      
    						for (int j = i; j < arr.length; j++) 
    						{
    							if (arr[i] == arr[j])
    							{
    								count++;
    							}
    						}
  
    						if (count > maxcount) 
    						{
    							maxcount = count;
    							element_having_max_freq = arr[i];
    						}
    		  }
    
      System.out.println(element_having_max_freq+"|"+maxcount);
   
	}
	
}
