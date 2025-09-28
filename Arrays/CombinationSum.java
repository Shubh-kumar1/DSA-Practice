package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode Problem #39: Combination Sum
 * Link: https://leetcode.com/problems/combination-sum/
 *
 * Time Complexity: O(N^(T/M + 1)) where N is number of candidates, T is target, M is min value.
 * Space Complexity: O(T/M) for the recursion stack.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int[] candidates, int remaining, int start) {
        if (remaining < 0) {
            return; // Prune the search if sum exceeds target
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(currentCombination)); // Found a valid combination
            return;
        }

        // Explore further combinations
        for (int i = start; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            // Recursive call, staying at the same index 'i' since we can reuse numbers
            backtrack(result, currentCombination, candidates, remaining - candidates[i], i);
            // Backtrack: remove the last added number to explore other paths
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println("Combinations that sum to " + target + ": " + result); 
        // Expected: [[2, 2, 3], [7]]
    }
}