package StreamAPI;


public class PractiseString 
{
  public static void main(String[] args)
  {
	  
	  
	  
	  
	  
	  String a="rutu";
	  String b="rutu";
	  System.out.println(a==b);          //true
	  System.out.println(a.equals(b));   //true
	  
	 
	 String  s1 =new String("durga");
	 String  s2= new String("durga");
	 System.out.println(s1==s2);                //false
	 System.out.println(s1.equals(s2));         //true
	 
	 
	 
	 
	   String s="Durga";
	   
	   char charAt = s.charAt(2);
	   System.out.println(charAt);
	   
	  String concat = s.concat("Solutions");
	  System.out.println(concat);
	  
	  boolean equals = s.equals("Durga");
	  System.out.println(equals);
	  
	    boolean equalsIgnoreCase = s.equalsIgnoreCase("durga");
	   System.out.println(equalsIgnoreCase);
	   
	     boolean empty = s.isEmpty();
	     System.out.println(empty);
	     
	     int length = s.length();
	     System.out.println(length);
	     
	     String replace = s.replace('D','d');
	     System.out.println(replace);
	     
	    String substring = s.substring(2);
	    System.out.println(substring);
	    
	     String substring2 = s.substring(0, 2);
	      System.out.println(substring2);
	       
	       
	       int indexOf = s.indexOf('D');
	        System.out.println(indexOf);
	     
       int lastIndexOf = s.lastIndexOf('a');
	  System.out.println(lastIndexOf);
	 
	  
      String lowerCase = s.toLowerCase();
      System.out.println(lowerCase);
      
      String upperCase = s.toUpperCase();
      System.out.println(upperCase);
	       
	  
  }
}