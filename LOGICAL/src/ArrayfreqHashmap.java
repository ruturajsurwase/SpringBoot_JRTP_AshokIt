import java.util.HashMap;
import java.util.Map;

public class ArrayfreqHashmap 
{

public static void main(String[] args)
	{
		int [] arr= {2,1,1,1,1,1,3,5,6,7,6,1,2,8,9};
		
		Map<Integer,Integer> freqMap = new HashMap<>();
		
	for (int i : arr) 
	{
	  
		if (freqMap.containsKey(i)) 
        {
			freqMap.put(i, freqMap.get(i) + 1);
        }
        else 
        {
        	freqMap.put(i, 1);
        }
		
	}
	
	for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) 
    {
        System.out.println(entry.getKey() + "|" + entry.getValue());
    }
	
	}
}
