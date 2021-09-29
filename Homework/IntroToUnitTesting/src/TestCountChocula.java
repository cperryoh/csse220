import static org.junit.Assert.*;

import org.junit.Test;

public class TestCountChocula {

	@Test
	public void testCountChoculaNO1() {
		String testString = "Chocula Chocula";
		assertEquals(2, TestThisClass.countChocula(testString));
	}
	@Test
	public void testCountChoculaNO2() {
		String testString = "";
		assertEquals(0, TestThisClass.countChocula(testString));
	}
	@Test
	public void testCountChoculaNO3() {
		String testString = "Chocula choculaChocula";
		assertEquals(2, TestThisClass.countChocula(testString));
	}
	@Test
	public void testCountChoculaNO4() {
		String testString = "hoculachoculaChocula";
		assertEquals(1, TestThisClass.countChocula(testString));
	}
}
