import java.util.Scanner;

public class PrimeNumber
{

	public static void main(String[] args)
	{
		int count=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number");
			int n= sc.nextInt();
		  
		 for(int i=1;i<=n;i++)
		 {
			 
	       if(n%i==0)
	       {
	    	  count ++;
	       }
	       
			 
		 }
		 if(count==2)
	       {
	    	    System.out.println("prime number");
	       }
	       else
	       {
	    	   System.out.println("not prime");
	       }
	}

}
