
public class ArrayFreqMaxCount
{
	public static void main(String[] args) 
	{
		int [] arr= {2,2,2,1,3,5,6,7,6,1,2,8,9};
		
		int maxcount=0;
		
		int element_having_max_freq=0;
		
		
		for(int i=0;i<arr.length;i++) 
		{
			int count=0;
			
			for(int j=i;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
				}
				
			}
			
			
			if(count>maxcount)
			{
				maxcount=count;
				element_having_max_freq=arr[i];
			}
			
		}
		
		System.out.println("maxcount="+maxcount+"|"+ "number="+ element_having_max_freq );
		
	}
	
	
	
}
