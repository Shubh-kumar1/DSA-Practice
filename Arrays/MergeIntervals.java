package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode Problem #56: Merge Intervals
 * Link: https://leetcode.com/problems/merge-intervals/
 *
 * Time Complexity: O(n log n) due to sorting.
 * Space Complexity: O(n) for the result list.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals based on their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) { // Overlap detected
                // Merge by updating the end of the current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // No overlap
                // Add the new interval to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        
        int[][] result = solution.merge(intervals);
        System.out.println("Merged intervals: " + Arrays.deepToString(result)); 
        // Expected: [[1, 6], [8, 10], [15, 18]]
    }
}