package.Arrays;
import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode Problem #118: Pascal's Triangle
 * Link: https://leetcode.com/problems/pascals-triangle/
 *
 * Time Complexity: O(numRows^2)
 * Space Complexity: O(1) (excluding the result list)
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        // First row is always [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // First element of each row is always 1
            currentRow.add(1);

            // Each middle element is the sum of the two elements above it
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element of each row is always 1
            currentRow.add(1);
            triangle.add(currentRow);
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalsTriangle solution = new PascalsTriangle();
        int numRows = 5;
        
        List<List<Integer>> result = solution.generate(numRows);
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for(List<Integer> row : result) {
            System.out.println(row);
        }
    }
}