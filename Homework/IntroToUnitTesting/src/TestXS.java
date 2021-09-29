import static org.junit.Assert.*;

import org.junit.Test;

public class TestXS {

	@Test
	public void testNumberOfXsNO1() {
		String testString = "xxcxXX";
		assertEquals(5, TestThisClass.numberOfXs(testString)); 
	}
	@Test
	public void testNumberOfXsNO2() {
		String testString = "c";
		assertEquals(0, TestThisClass.numberOfXs(testString)); 
	}

	@Test
	public void testNumberOfXsNO3() {
		String testString = "X";
		assertEquals(1, TestThisClass.numberOfXs(testString)); 
	}
}
