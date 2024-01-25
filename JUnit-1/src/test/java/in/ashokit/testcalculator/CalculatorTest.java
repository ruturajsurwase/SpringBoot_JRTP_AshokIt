package in.ashokit.testcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import in.ashokit.calculatortask.Calculator;

public class CalculatorTest {

	@Test	
	public void testAdd()
	{
		Calculator c=new Calculator();
		  int actualResult = c.add(20, 30);
		  int expectedResult= 50;
		  
		  assertEquals(expectedResult, actualResult);
	}
	
	@Test	
	public void testMUl()
	{
		Calculator c=new Calculator();
		  int actualResult = c.mul(2,3);
		  int expectedResult= 6;
		  
		  assertEquals(expectedResult, actualResult);
	}
	
	
	
	
}
