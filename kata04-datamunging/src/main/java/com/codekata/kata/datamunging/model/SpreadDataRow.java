package com.codekata.kata.datamunging.model;

import java.util.Objects;

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
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof SpreadDataRow)) {
			return false;
		}
		final SpreadDataRow other = (SpreadDataRow) o;
		return rowName.equals(other.rowName) && spreadValue == other.spreadValue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(rowName, spreadValue);
	}
	
	@Override
	public String toString() {
		return rowName + " [Spread Value: " + spreadValue + ']';
	}
}
