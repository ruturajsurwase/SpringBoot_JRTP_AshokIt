
public class ReverseArray 
{

	
	public static void main(String[] args) 
	{
		int [] arr= {1,2,3,4,5,6};
		 
		int temp;
		
		int n = arr.length-1;
		
		for(int i=0;i<arr.length/2;i++)
		{
			temp=arr[i];
			arr[i]=arr[n-i];
			arr[n-i]=temp;
		}
		
		for (int i : arr) 
		{
			System.out.print(i);
		}
		
		
		
	}
	
	
}
