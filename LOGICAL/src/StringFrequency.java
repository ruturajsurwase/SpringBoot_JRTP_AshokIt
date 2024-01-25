import java.util.HashMap;
import java.util.Map;

public class StringFrequency {

	
	public static void main(String[] args)
	{
	    String str = "Hello World";
	  
	    
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : str.toCharArray()) 
        {
            if (frequencyMap.containsKey(c)) 
            {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            }
            else 
            {
                frequencyMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) 
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
		
		
		
		
		
		
		
		
	}
	

