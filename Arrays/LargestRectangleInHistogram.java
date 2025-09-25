package Arrays;

import java.util.Stack;

/*
 * LeetCode Problem #84: Largest Rectangle in Histogram
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the stack.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            // Use a height of 0 to clear out the rest of the stack at the end
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            
            // If the current bar is shorter than the bar at the stack's top,
            // we can calculate the area for the bars in the stack.
            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {
                int height = heights[stack.pop()];
                // The right boundary is 'i'.
                // The left boundary is the new element at the top of the stack.
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            // Push the current bar's index onto the stack
            stack.push(i);
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        
        int result = solution.largestRectangleArea(heights);