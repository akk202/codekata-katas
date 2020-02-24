package com.codekata.kata.anagrams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class MainTest {
	@Test
	public void testAnagramMap() {
		final String[] args = new String[] { "one", "noe", "eon", "per", "sss", "rep", "pre" };

		final Map<Main.AnagramKey, List<String>> result = Main.anagramMap(args);

		Assert.assertEquals(Arrays.asList("one", "noe", "eon"), result.get(new Main.AnagramKey("one")));
		Assert.assertEquals(Arrays.asList("per", "rep", "pre"), result.get(new Main.AnagramKey("rep")));
		Assert.assertEquals(Collections.singletonList("sss"), result.get(new Main.AnagramKey("sss")));
	}
}
