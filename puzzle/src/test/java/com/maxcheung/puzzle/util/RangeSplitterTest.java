package com.maxcheung.puzzle.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang3.Range;
import org.junit.Test;

public class RangeSplitterTest {
	RangeSplitter rangeSplitter = new RangeSplitter();

	@Test
	public void shouldSplitSmallRange() {
		Range<Integer> range = Range.between( 1,  5);
		List<Range<Integer>> splitlist = rangeSplitter.splitRange(range, 4);
		assertEquals(4, splitlist.size());
		assertEquals(1, (int) splitlist.get(0).getMinimum());
		assertEquals(5, (int) splitlist.get(3).getMaximum());
	}

	@Test
	public void shouldSplitRange() {
		Range<Integer> range = Range.between( 1,  100);
		List<Range<Integer>> splitlist = rangeSplitter.splitRange(range, 4);
		assertEquals(4, splitlist.size());
		assertEquals(1, (int) splitlist.get(0).getMinimum());
		assertEquals(100, (int) splitlist.get(3).getMaximum());
	}

}
