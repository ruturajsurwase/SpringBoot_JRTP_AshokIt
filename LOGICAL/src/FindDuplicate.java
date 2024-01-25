import java.util.HashSet;
import java.util.Iterator;

public class FindDuplicate
{
	public static void main(String[] args) 
	{
	
		int[] arr = {40, 50, 30, 40, 30,30,30,40};
	
		HashSet<Integer> duplicate=new HashSet<>();
	
	
	for(int i=0; i<arr.length;i++)
	{
		int count = 0;
		
		for(int j=i+1;j<arr.length;j++)
		{
			if(arr[i]==arr[j])
			{
				count++;
			}
			
		}
		
		if(count>0)
		{
			duplicate.add(arr[i]);
		}
	}
		
	   System.out.println(duplicate);	
	

	       
	}

}
	
	
	
	
	
	
	
	
	
	
	
	




