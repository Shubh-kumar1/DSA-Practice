package.Arrays;
/*
 * LeetCode Problem #11: Container With Most Water
 * Link: https://leetcode.com/problems/container-with-most-water/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the width between the two lines
            int width = right - left;
            // The height of the container is limited by the shorter of the two lines
            int h = Math.min(height[left], height[right]);
            
            // Calculate the current area and update maxArea if it's larger
            int currentArea = width * h;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that points to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        int result = solution.maxArea(height);
        System.out.println("The maximum area is: " + result); // Expected: 49
    }
}