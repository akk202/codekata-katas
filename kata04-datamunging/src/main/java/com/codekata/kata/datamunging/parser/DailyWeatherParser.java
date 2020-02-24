package com.codekata.kata.datamunging.parser;

import java.util.regex.Matcher;

public class DailyWeatherParser extends RegexSpreadDataRowParser {
	public DailyWeatherParser() {
		super("^(\\d+)\\s+(\\d+)\\s+(\\d+).*");
	}
	
	@Override
	protected String extractRowName(Matcher matcher) {
		return "Day #" + super.extractRowName(matcher);
	}
}
