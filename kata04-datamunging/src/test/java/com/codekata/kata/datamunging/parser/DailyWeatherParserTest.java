package com.codekata.kata.datamunging.parser;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.codekata.kata.datamunging.model.SpreadDataRow;
import com.codekata.kata.datamunging.parser.DailyWeatherParser;

public class DailyWeatherParserTest {
	@Test
	public void testParseLineFailure() {
		final String line = "  Dy MxT   MnT   AvT   HDDay  AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP ";
		Assert.assertFalse(new DailyWeatherParser().parseLine(line).isPresent());
	}
	
	@Test
	public void testParseLineSuccess() {
		final String line = "   9  86    32*   59       6  61.5       0.00         240  7.6 220  12  6.0  78 46 1018.6";
		final Optional<SpreadDataRow> result = new DailyWeatherParser().parseLine(line);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals("Day #9", result.get().toString());
	}
}
