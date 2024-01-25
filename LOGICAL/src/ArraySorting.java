
public class ArraySorting 
{

	public static void main(String[] args)
	{
		int[] arr = new int[] {6,9,7,8,5,4,3,2,1};
		
		
		for (int i = 0; i < arr.length; i++)   
		{  
			for (int j = i + 1; j < arr.length; j++)   
				{  
					int tmp = 0;  
					
					if (arr[i] > arr[j])   
					{  
						tmp = arr[i];  
						arr[i] = arr[j];  
						arr[j] = tmp;  
					}  
		        }  
	 
		System.out.println(arr[i]);  
		}  
		
		
		
		
	}
}
