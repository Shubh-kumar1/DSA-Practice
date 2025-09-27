package Arrays;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * LeetCode Problem #239: Sliding Window Maximum
 * Link: https://leetcode.com/problems/sliding-window-maximum/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k) for the deque.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        // Deque will store indices of elements.
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices from the front that are out of the current window's bounds.
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove indices from the back whose elements are smaller than the current element.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add the current index to the deque.
            deque.offerLast(i);

            // 4. Once the window is full, the max element's index is at the front of the deque.
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println("Sliding window maximums: " + Arrays.toString(result)); 
        // Expected: [3, 3, 5, 5, 6, 7]
    }
}