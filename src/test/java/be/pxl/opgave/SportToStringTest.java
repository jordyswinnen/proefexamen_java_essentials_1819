package be.pxl.opgave;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SportToStringTest {

	@Test
	public void setUp() {
		assertEquals(Sport.VOETBAL.toString(),"voe");
		assertEquals(Sport.VOLLEYBAL.toString(),"vol");
		assertEquals(Sport.TENNIS.toString(),"ten");
	}
}
