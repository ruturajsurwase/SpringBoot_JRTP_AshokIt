
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates 
{
	public static void main(String[] args)
	{
//	 int[] nums = {1, 2, 2, 3, 4, 4, 5};
//	 
//	 Set<Integer> ss = new LinkedHashSet<>();
//	 
//       for (Integer i :nums)
//       {
//		  ss.add(i);
//       }
//       System.out.println(ss);
//       
       
         List<Integer> l=new ArrayList<>();
                l.add(1);
               
                l.add(3);
                l.add(4);
                l.add(4);
                l.add(5);
                l.add(2);
                l.add(2);
         System.out.println(l);    
      
         Iterator<Integer> iterator = l.iterator();
         
         while(iterator.hasNext())
         {
        	 Integer i = iterator.next();
        	 System.out.print(i);
         }
      
                
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
