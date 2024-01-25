
public class Student
{

	private Student()
	 {
		System.out.println("private const"); 
	 }
	 
	 
	 
	 private static Student s;
	 
	 
	 public static Student m1() 
	 {
		 if(s==null) 
		 {
			  s=new Student();
		 }
		 return s;
		 
	 }
	 
	 
	
	 
}
