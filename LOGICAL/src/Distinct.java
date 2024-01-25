import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Distinct {



public static void main(String[] args)
{
	
	 List<Integer> numberList = Arrays.asList(1, 2, 3, 3, 4, 4, 4);
	
	 Set<Integer> distinctSet = new HashSet<>(numberList);
	 
	 
	 System.out.println(distinctSet);
}

}
