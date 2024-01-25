package StreamAPI;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {

	
	public static void main(String[] args) 
	{
		
			
		//filter
		String names[]= {"aman","rututaj","raj","charu","dada","rohan"};
		
		  Stream<String> names1 = Stream.of(names);
	
	   List<String> newnames = names1.filter(e->e.startsWith("r")).collect(Collectors.toList());
	   System.out.println(newnames);
	   
	   
	   
	   
	   
	   List<Integer> list2=new ArrayList<>();
		  list2.add(4);
		  list2.add(6);
		  list2.add(5);
		  list2.add(10);
		  list2.add(12);
		  list2.add(7);
		  
		  //map
		 List<Integer> collect = list2.stream().map(i->i*i).collect(Collectors.toList());
		 System.out.println(collect);
	   
	     //sorted
	     list2.stream().sorted().forEach(System.out::println);;
	
	     //min comparator use
	       Integer integer = list2.stream().min((x,y)-> x.compareTo(y)).get();
	       System.out.println("min="+integer);
	   //max
	       Integer integer2 = list2.stream().max((x,y)->x.compareTo(y)).get();
	       System.out.println("max="+integer2);
	   
	   
	   
	   
	   
	   
	   
	   
	  
	}
	
}
