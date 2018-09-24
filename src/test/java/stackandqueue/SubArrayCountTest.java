package stackandqueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubArrayCountTest {

	@Test
	public void testGetSubArrayNumber() {
		int[] array = new int[] {1,3,5,6};
		int number = 2;
		assertEquals(7, new SubArrayCount(array, number).getSubArrayNumber());
	}

}
