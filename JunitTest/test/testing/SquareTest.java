package testing;

import static org.junit.Assert.*;

import org.junit.Test;



public class SquareTest {

	@Test
	public void test() {
		JunitTesting test = new JunitTesting();
		int output = test.square(10);
		assertEquals(100, output);
		
	}

}
