package com.codekata.kata.datamunging.parser;

public class FootballTeamParser extends RegexSpreadDataRowParser {
	private static final String REGEX = "^\\d+\\.\\s+(\\w+)" //
			+ repeatString("\\s+\\d+", 4) //
			+ "\\s+(\\d+)\\s+-\\s+(\\d+)\\s+\\d+$";
	
	public FootballTeamParser() {
		super(REGEX);
	}

	private static String repeatString(String s, int numTimes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numTimes; i++) {
			sb = sb.append(s);
		}
		return sb.toString();
	}
}
