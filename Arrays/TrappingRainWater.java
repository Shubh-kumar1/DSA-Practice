package Arrays;

/*
 * LeetCode Problem #42: Trapping Rain Water
 * Link: https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // The left wall is shorter, so water level is determined by leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update the max height from the left
                } else {
                    totalWater += leftMax - height[left]; // Add trapped water
                }
                left++;
            } else {
                // The right wall is shorter or equal, so water level is determined by rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update the max height from the right
                } else {
                    totalWater += rightMax - height[right]; // Add trapped water
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        int result = solution.trap(height);
        System.out.println("Total trapped water: " + result); // Expected: 6
    }
}
