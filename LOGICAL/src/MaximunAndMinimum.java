

public class MaximunAndMinimum {

	public static void main(String[] args)
	{
		int arr[]= {3,2,10,1,5};
		
		int max=0;
		int min=arr[0];
		
		
		for(int i=0;i<arr.length;i++)
		{
			
			if(arr[i]<min)
			{
				min=arr[i];
			}
			
		}
		System.out.println("minimum "+min);
		
		
		for(int i=0;i<arr.length;i++)
		{
			
			if(arr[i]>max)
			{
				max=arr[i];
			}
			
			
		}
		
		System.out.println("maximum "+max);
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
