/*
Given a set of non-overlapping intervals[][] where intervals[i] = [starti , endi] represent the start and the end of the ith event
and intervals is sorted in ascending order by starti and a new interval, insert the interval at the correct position such that
after insertion, the intervals remain sorted. If the insertion results in overlapping intervals, then merge the overlapping intervals.
Assume that the set of non-overlapping intervals is sorted based on start time.

Examples:

Input: intervals[][] = [[1, 3], [4, 5], [6, 7], [8, 10]], newInterval[] = [5, 6]
Output: [[1, 3], [4, 7], [8, 10]]
Explanation: The intervals [4, 5] and [6, 7] are overlapping with [5, 6]. So, they are merged into one interval [4, 7].

Input: intervals[][] = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], newInterval[]  = [4, 9]
Output: [[1, 2], [3, 10], [12, 16]]
Explanation: The intervals [ [3, 5], [6, 7], [8, 10] ] are overlapping with [4, 9]. So, they are merged into one interval [3, 10].

Idea:
Since intervals is already sorted:

First, add all intervals ending before newInterval starts.

Merge all overlapping intervals with newInterval.

Add remaining intervals after newInterval.

Steps:

Create an output list.

Loop over intervals:

If the current interval ends before newInterval starts → no overlap → add it to output.

If the current interval starts after newInterval ends → no overlap, but after insertion → add newInterval, then the rest.

Otherwise → overlap → merge by updating start/end.

Append merged newInterval if not already added.

Complexity:

Time: O(n) (just one pass)

Space: O(n) (result list)
 */

import java.util.*;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals before newInterval (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge all overlapping intervals into newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // merged interval

        // Step 3: Add remaining intervals (after newInterval)
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int[] newInterval = {5, 6};
        int[][] ans = insert(intervals, newInterval);

        for (int[] in : ans) {
            System.out.println(Arrays.toString(in));
        }
    }
}
