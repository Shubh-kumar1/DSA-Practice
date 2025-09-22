
package Arrays;
/*
 * LeetCode Problem #55: Jump Game
 * Link: https://leetcode.com/problems/jump-game/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        // 'reachable' stores the maximum index we can reach so far.
        int reachable = 0;
        
        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // If the current index 'i' is beyond our reach, we can't proceed.
            if (i > reachable) {
                return false;
            }
            
            // Update the farthest index we can reach from the current position.
            reachable = Math.max(reachable, i + nums[i]);
            
            // An optimization: if we can already reach the end, no need to check further.
            if (reachable >= nums.length - 1) {
                return true;
            }
        }
        
        // This line is technically unreachable due to the optimization above,
        // but it covers cases where the loop finishes.
        return reachable >= nums.length - 1;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can jump in {2, 3, 1, 1, 4}? " + solution.canJump(nums1)); // Expected: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can jump in {3, 2, 1, 0, 4}? " + solution.canJump(nums2)); // Expected: false
    }
}