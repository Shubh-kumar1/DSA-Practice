package Arrays;
import java.util.Arrays;

/*
 * LeetCode Problem #238: Product of Array Except Self
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding the result array)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // First pass: Calculate prefix products
        // result[i] will contain the product of all elements to the left of i
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        // Second pass: Calculate postfix products and multiply with prefix products
        // Multiply each element by the product of all elements to its right
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] numbers = {1, 2, 3, 4};

        int[] result = solution.productExceptSelf(numbers);
        System.out.println("Result: " + Arrays.toString(result)); // Expected: [24, 12, 8, 6]
    }
}
