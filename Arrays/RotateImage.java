package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem #48: Rotate Image
 * Link: https://leetcode.com/problems/rotate-image/
 *
 * Time Complexity: O(n^2) - We must visit every cell.
 * Space Complexity: O(1)
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        // (Swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        solution.rotate(matrix);

        System.out.println("\nRotated Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        // Expected:
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]
    }
}