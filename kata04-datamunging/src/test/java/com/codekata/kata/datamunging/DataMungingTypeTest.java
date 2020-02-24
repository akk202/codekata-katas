package com.codekata.kata.datamunging;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.codekata.kata.datamunging.model.SpreadDataRow;

@RunWith(Parameterized.class)
public class DataMungingTypeTest {
	private final DataMungingType paramType;
	private final String paramFileNamePrefix;
	
	public DataMungingTypeTest(DataMungingType paramType, String paramFileNamePrefix) {
		this.paramType = paramType;
		this.paramFileNamePrefix = paramFileNamePrefix;
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testComputeMinSpreadEmptyFile() throws Exception {
		reflectionSetFileName(paramFileNamePrefix + "empty.dat");
		paramType.computeMinSpread();
	}
	
	@Test
	public void testComputeMinSpreadNonEmptyFile() throws Exception {
		reflectionSetFileName(paramFileNamePrefix + "nonempty.dat");
		
		final SpreadDataRow expected = paramType.equals(DataMungingType.WEATHER) ? //
				new SpreadDataRow("Day #2", 73, 74) : 
				new SpreadDataRow("Manchester_U", 87, 88);
		Assert.assertEquals(expected, paramType.computeMinSpread());	
	}
	
	private void reflectionSetFileName(String fileName) throws ReflectiveOperationException {
		final Field fileNameField = paramType.getClass().getDeclaredField("fileName");
		fileNameField.setAccessible(true);
		fileNameField.set(paramType, fileName);
	}
	
	@Parameterized.Parameters(name = "paramType={0}, paramFileNamePrefix={1}")
	public static Iterable<Object[]> testData() {
		return Arrays.asList(
			new Object[] { DataMungingType.WEATHER, "weather-test-" }, //
			new Object[] { DataMungingType.FOOTBALL, "football-test-" } //
		);
	}
}
