package com.codekata.kata.datamunging.parser;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.codekata.kata.datamunging.model.SpreadDataRow;
import com.codekata.kata.datamunging.parser.FootballTeamParser;


public class FootballTeamParserTest {
	@Test
	public void testParseLineFailure() {
		final String line = "       Team            P     W    L   D    F      A     Pts ";
		Assert.assertFalse(new FootballTeamParser().parseLine(line).isPresent());
	}

	@Test
	public void testParseLineSuccess() {
		final String line = "    2. Liverpool       38    24   8   6    67  -  30    80 ";
		final Optional<SpreadDataRow> result = new FootballTeamParser().parseLine(line);
		Assert.assertTrue(result.isPresent());
		Assert.assertEquals("Liverpool", result.get().toString());
	}
}
