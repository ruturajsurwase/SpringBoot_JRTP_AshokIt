public class FibonanciSeries
{
	
	public static void main(String[] args) {
		
		int j=1;
		int k=0;
		
		for(int i=0;i<=10;i++)
		{
			int m=j+k;
			System.out.print(m+ " ");
			   k=j;
		       j=m;	
		       
		}
		
		
	}
	
}