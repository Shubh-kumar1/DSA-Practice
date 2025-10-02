package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem #73: Set Matrix Zeroes
 * Link: https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean isFirstColZero = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Use first row and column as markers
        for (int i = 0; i < rows; i++) {
            // Check if the first column needs to be zeroed
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
            }
            // Start from the second column
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the row
                    matrix[0][j] = 0; // Mark the column
                }
            }
        }

        // Step 2: Zero out cells based on markers in first row and column
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Zero out the first row if needed
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Zero out the first column if needed
        if (isFirstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        System.out.println("Original Matrix:");
        for(int[] row : matrix) System.out.println(Arrays.toString(row));
        
        solution.setZeroes(matrix);
        
        System.out.println("\nMatrix after setting zeroes:");
        for(int[] row : matrix) System.out.println(Arrays.toString(row));
        // Expected:
        // [1, 0, 1]
        // [0, 0, 0]
        // [1, 0, 1]
    }
}