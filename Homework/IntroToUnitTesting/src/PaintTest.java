import static org.junit.Assert.*;

import org.junit.Test;

public class PaintTest {

	@Test
	public void paintTestNO1() {
		int length=0, width=-1, dollarsPerSqFoot=0;
		assertEquals(-1, TestThisClass.paintCost(length, width, dollarsPerSqFoot));
	}
	@Test
	public void paintTestNO2() {
		int length=0, width=0, dollarsPerSqFoot=0;
		assertEquals(0, TestThisClass.paintCost(length, width, dollarsPerSqFoot));
	}
	@Test
	public void paintTestNO3() {
		int length=3, width=4, dollarsPerSqFoot=5;
		assertEquals(length*width*dollarsPerSqFoot, TestThisClass.paintCost(length, width, dollarsPerSqFoot));
	}
}
