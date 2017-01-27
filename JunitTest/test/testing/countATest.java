package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class countATest {

	@Test
	public void test() {
		JunitTesting testing = new JunitTesting();
		int output = testing.countA("ananas");
		assertEquals(3, output);
	}

}
