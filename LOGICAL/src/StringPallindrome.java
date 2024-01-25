
public class StringPallindrome {

	
	
	public static void main(String[] args)
	{
		
		String str ="MADAM";
		String rev="";
		
		for(int i=str.length()-1; i>=0; i--) 
		{
		      char c = str.charAt(i);
		            rev=rev+c;
		}
		
		 System.out.println(rev);
		
		if(str.equalsIgnoreCase(rev))
		{
			System.out.println("pallindrome");
		}
		else
		{
			System.out.println("not pallindrome");
		}
		
	  }
	
}
