package com.maxcheung.puzzle.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Range;

public class RangeSplitter {

	/*
	 * Splits
	 * 
	 * Example:
	 * 
	 * Input: range [1..100] , segments 4
	 * 
	 * Output: [[1..25], [26..50], [51..75], [76..100]]
	 * 
	 */
	public List<Range<Integer>> splitRange(Range<Integer> range, int segments) {

		int start = range.getMinimum();
		int end = range.getMaximum();
		int next = 0;
		int chunksize = end / segments;

		List<Range<Integer>> splitRanges = new ArrayList<Range<Integer>>();

		start = 1;
		for (int i = 1; i < segments; i++) {
			next = i * chunksize;
			splitRanges.add(Range.between(start, next));
			start = next + 1;
		}
		splitRanges.add(Range.between(start, end));

		return splitRanges;
	}

}
