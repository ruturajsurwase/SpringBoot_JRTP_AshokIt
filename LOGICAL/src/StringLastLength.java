
public class StringLastLength 
{
public static void main(String[] args)
{

	String s="    ruturaj Surwase   ";
	int count=0;
	String trim = s.trim();
	
	
	for(int i=trim.length()-1;i>=0;i--)
	{
		if(trim.charAt(i)== ' ')
		{
			break;		
		}
		else
		{
			count++;
		}
		
		
	}
	
	System.out.println(count);
}
}
