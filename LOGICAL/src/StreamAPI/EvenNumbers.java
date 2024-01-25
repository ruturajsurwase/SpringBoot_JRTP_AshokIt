package StreamAPI;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;


public class EvenNumbers {

	public static void main(String[] args) {
		
	//List<Integer> list1 = List.of(2,4,6,78,99,100);
		
		List<Integer> list2=new ArrayList<>();
		  list2.add(4);
		  list2.add(6);
		  list2.add(5);
		  list2.add(10);
		  list2.add(12);
		  list2.add(7);
		
		  
		  
		  
		List<Integer> collect = list2.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
	    System.out.println("even" +collect);
	    
	      List<Integer> collect2 = list2.stream().filter(i->i>10).collect(Collectors.toList());
	      System.out.println("greater than 10 " +collect2);
	
	
		  
		  
	}
	
}
