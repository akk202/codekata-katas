package com.codekata.kata.anagrams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		// Was unable to open the file containing all words, so instead
		// using arguments passed to the main method.
		anagramMap(args).values().forEach(v -> System.out.println(v.toString()));

	}

	public static Map<AnagramKey, List<String>> anagramMap(String[] strings) {
		return Arrays.stream(strings) //
				.distinct() // distinct string values to avoid repetitions
				.collect(Collectors.groupingBy(AnagramKey::new));
	}
	
	public static class AnagramKey {
		private final String sortedString;
		
		public AnagramKey(String str) {
			// anagram means chars re-arranged words are equal
			// hence we store a sorted string and use it as a key for hashmap
			this.sortedString = sortString(str);
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if (!(o instanceof AnagramKey)) {
				return false;
			}
			final AnagramKey other = (AnagramKey) o;
			return sortedString.equals(other.sortedString);
		}
		
		@Override
		public int hashCode() {
			return sortedString.hashCode();
		}
		
		private String sortString(String s) {
			final char[] chars = s.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}
	}

}
