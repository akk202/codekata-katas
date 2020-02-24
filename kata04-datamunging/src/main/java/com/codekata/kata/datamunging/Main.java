package com.codekata.kata.datamunging;

import java.io.IOException;

public class Main {
	public static final void main(String[] args) throws IOException {
		System.out.println("Min weather spread: " + DataMungingType.WEATHER.computeMinSpread());
		System.out.println("Min goals diff for team: " + DataMungingType.FOOTBALL.computeMinSpread());
	}
}
