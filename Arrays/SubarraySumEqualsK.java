package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode Problem #560: Subarray Sum Equals K
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the HashMap.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        // HashMap to store <PrefixSum, Frequency>
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: a sum of 0 has occurred once (the empty prefix)
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - k) exists in the map.
            // If it does, it means there are subarrays ending at the current position
            // whose sum is exactly k.
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Add the current prefix sum to the map, updating its frequency.
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] numbers = {1, 1, 1};
        int k = 2;
        
        int result = solution.subarraySum(numbers, k);
        System.out.println("Number of subarrays summing to " + k + ": " + result); // Expected: 2
        
        int[] numbers2 = {1, 2, 3};
        int k2 = 3;
        int result2 = solution.subarraySum(numbers2, k2);
        System.out.println("Number of subarrays summing to " + k2 + ": " + result2); // Expected: 2
    }
}
