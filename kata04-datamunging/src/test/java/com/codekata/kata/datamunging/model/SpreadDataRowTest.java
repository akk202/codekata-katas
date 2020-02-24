package com.codekata.kata.datamunging.model;

import org.junit.Assert;
import org.junit.Test;

import com.codekata.kata.datamunging.model.SpreadDataRow;

public class SpreadDataRowTest {
	@Test
	public void testCompareTo() {
		final SpreadDataRow minRow = new SpreadDataRow("Min", 1, 2);
		final SpreadDataRow maxRow = new SpreadDataRow("Max", 3, 9);
		
		// min < max -> -1
		Assert.assertEquals(-1, minRow.compareTo(maxRow));
		// min = min -> 0
		Assert.assertEquals(0, minRow.compareTo(minRow));
		// max > min -> 1
		Assert.assertEquals(1, maxRow.compareTo(minRow));		
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals("rowName", new SpreadDataRow("rowName", 1, 2).toString());
	}
}
