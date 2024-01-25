import java.util.Scanner;

public class PallindromeNumber {

	public static void main(String[] args) {
	
		
			Scanner	sc=new Scanner(System.in);
			System.out.println("enter number");
			int n = sc.nextInt();
			
			int reverseNumber=0;
			
			int n1=n;
			
			while(n>0)
			{
				reverseNumber =reverseNumber * 10 +( n % 10);
				n=n/10;
			}
			
			if(n1==reverseNumber)
			{
			    System.out.println("pallindrome");	
			}
			else
			{
				System.out.println("not pallindrome");
			}
			
			
		
	}

	
	
	
	
	
	
}
