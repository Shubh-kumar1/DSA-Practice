/*
 * LeetCode Problem #79: Word Search
 * Link: https://leetcode.com/problems/word-search/
 *
 * Time Complexity: O(N * 3^L) where N is the number of cells and L is the length of the word.
 * Space Complexity: O(L) for the recursion stack.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        // Base case: If we've found all characters in the word.
        if (index == word.length()) {
            return true;
        }

        // Boundary checks and character match check.
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited to avoid using it again in the same path.
        char temp = board[i][j];
        board[i][j] = '#'; 

        // Explore neighbors recursively.
        boolean found = dfs(board, i + 1, j, word, index + 1) ||
                        dfs(board, i - 1, j, word, index + 1) ||
                        dfs(board, i, j + 1, word, index + 1) ||
                        dfs(board, i, j - 1, word, index + 1);
        
        // Backtrack: Un-mark the cell so it can be used in other paths.
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        
        System.out.println("Word 'ABCCED' exists: " + solution.exist(board, "ABCCED")); // Expected: true
        System.out.println("Word 'SEE' exists: " + solution.exist(board, "SEE"));    // Expected: true
        System.out.println("Word 'ABCB' exists: " + solution.exist(board, "ABCB"));    // Expected: false
    }
}