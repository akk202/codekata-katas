package com.codekata.kata.datamunging.model;

import org.junit.Assert;
import org.junit.Test;

import com.codekata.kata.datamunging.model.SpreadDataRow;

public class SpreadDataRowTest {
	@Test
	public void testCompareTo() {
		final SpreadDataRow minRow = new SpreadDataRow("Min", 1, 2);
		final SpreadDataRow maxRow = new SpreadDataRow("Max", 3, 9);
		
		// min < max ->SSS -1
		Assert.assertEquals(-1, minRow.compareTo(maxRow));
		// min = min -> 0
		Assert.assertEquals(0, minRow.compareTo(minRow));
		// max > min -> 1
		Assert.assertEquals(1, maxRow.compareTo(minRow));		
	}
	
	@Test
	public void testEqualsSame() {
		final SpreadDataRow obj = new SpreadDataRow("", 1, 1);
		Assert.assertTrue(obj.equals(obj));
	}
	
	@Test
	public void testEqualsNotInstance() {
		Assert.assertFalse(new SpreadDataRow("", 1, 1).equals(new Object()));
	}
	
	@Test
	public void testEqualsEqualRowNameInequalSpread() {
		Assert.assertNotEquals(new SpreadDataRow("", 1, 2), new SpreadDataRow("", 1, 4));
	}
	
	@Test
	public void testEqualsInequalRowNameEqualSpread() {
		Assert.assertNotEquals(new SpreadDataRow("row1", 1, 2), new SpreadDataRow("row2", 1, 2));
	}
	
	@Test
	public void testEqualsEqualRowNameSpread() {
		Assert.assertEquals(new SpreadDataRow("row", 1, 2), new SpreadDataRow("row", 1, 2));
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals("rowName [Spread Value: 1]", new SpreadDataRow("rowName", 1, 2).toString());
	}
}
