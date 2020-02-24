package com.codekata.kata.datamunging;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.NoSuchElementException;

import com.codekata.kata.datamunging.model.SpreadDataRow;
import com.codekata.kata.datamunging.parser.DailyWeatherParser;
import com.codekata.kata.datamunging.parser.FootballTeamParser;
import com.codekata.kata.datamunging.parser.SpreadDataRowParser;

public enum DataMungingType {
	WEATHER("weather.dat", new DailyWeatherParser()), //
	FOOTBALL("football.dat", new FootballTeamParser());

	private final String fileName;
	private final SpreadDataRowParser parser;

	private DataMungingType(String fileName, SpreadDataRowParser parser) {
		this.fileName = fileName;
		this.parser = parser;
	}

	public SpreadDataRow computeMinSpread() throws IOException {
		return parser.parseDataRows(getFile()).min(Comparator.naturalOrder())
				.orElseThrow(() -> new NoSuchElementException("Empty stream encountered - no minimum found"));
	}

	private File getFile() {
		return new File(getClass().getClassLoader().getResource(fileName).getFile());
	}

}
