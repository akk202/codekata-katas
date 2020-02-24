package com.codekata.kata.datamunging.model;

public class SpreadDataRow implements Comparable<SpreadDataRow> {
	private final String rowName;
	private final int spreadValue;
	
	public SpreadDataRow(String rowName, int value1, int value2) {
		this.rowName = rowName;
		this.spreadValue = Math.abs(value1 - value2);
	}
	
	@Override
	public int compareTo(SpreadDataRow other) {
		return Integer.compare(spreadValue, other.spreadValue);
	}
	
	@Override
	public String toString() {
		return rowName + " [Spread Value: " + spreadValue + ']';
	}
}
