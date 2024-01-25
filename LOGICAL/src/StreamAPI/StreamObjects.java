package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamObjects {

	
	public static void main(String[] args)
	{
		
		
		
		
		String names[]= {"rututaj","raj","charu","dada","rohan"};
		
		  Stream<String> stream = Stream.of(names);
		   stream.forEach(e->{
			   System.out.println(e);
		   });
		
		   
		   
		   List<Integer> list2=new ArrayList<>();
			  list2.add(4);
			  list2.add(6);
			  list2.add(5);
			  list2.add(10);
			  list2.add(12);
			  list2.add(7);
			  
			  
			  Stream<Integer> stream2 = list2.stream();
			
			  stream2.forEach(e->{
				  System.out.println(e);
			  });
		   
		   
	}
	
}
