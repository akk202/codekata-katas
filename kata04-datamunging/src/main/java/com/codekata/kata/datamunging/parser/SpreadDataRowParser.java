package com.codekata.kata.datamunging.parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Stream;

import com.codekata.kata.datamunging.model.SpreadDataRow;

public interface SpreadDataRowParser {
	
	default Stream<SpreadDataRow> parseDataRows(File file) throws IOException {
		return Files.readAllLines(file.toPath()).stream() //
				.map(this::parseLine) //
				.filter(Optional::isPresent) //
				.map(Optional::get);
	}

	Optional<SpreadDataRow> parseLine(String line);
}
