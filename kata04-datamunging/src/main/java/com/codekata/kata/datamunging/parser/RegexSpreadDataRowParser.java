package com.codekata.kata.datamunging.parser;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.codekata.kata.datamunging.model.SpreadDataRow;

public class RegexSpreadDataRowParser implements SpreadDataRowParser {
	private final Pattern pattern;

	protected RegexSpreadDataRowParser(String regex) {
		this.pattern = Pattern.compile(regex);
	}

	@Override
	public Optional<SpreadDataRow> parseLine(String line) {
		final Matcher matcher = pattern.matcher(line.trim());
		return !matcher.find() ? Optional.empty() : //
				Optional.of(new SpreadDataRow(extractRowName(matcher), //
						extractValue1(matcher), //
						extractValue2(matcher)));
	}

	protected String extractRowName(Matcher matcher) {
		return matcher.group(1);
	}

	protected int extractValue1(Matcher matcher) {
		return Integer.parseInt(matcher.group(2));
	}

	protected int extractValue2(Matcher matcher) {
		return Integer.parseInt(matcher.group(3));
	}

}
