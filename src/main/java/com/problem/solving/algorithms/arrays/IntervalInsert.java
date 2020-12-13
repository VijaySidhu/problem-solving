package com.problem.solving.algorithms.arrays;

import java.util.List;

/*
// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 */
public class IntervalInsert {

    /*
    If the intervals list is an ArrayList, we can use binary search to make the best search time
    complexity O(log(n)). However, the worst time is bounded by shifting the array list
    if a new range needs to be inserted. So time complexity is still O(n).


     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;

        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            i++;
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }

        intervals.add(i, newInterval);

        return intervals;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
