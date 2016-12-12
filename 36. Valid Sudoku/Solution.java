package validSudoku;

public class Solution {
    //reference£ºhttp://www.cnblogs.com/springfor/p/3884217.html
    public boolean isValidSudoku(char[][] board) {
    
    HashSet<Character> set = new HashSet<Character>();
    
    // Check for each row
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.')
                continue;
            if (set.contains(board[i][j]))
                return false;
            set.add(board[i][j]);
        }
        set.clear();
    }

    // Check for each column
    for (int j = 0; j < 9; j++) {
        for (int i = 0; i < 9; i++) {
            if (board[i][j] == '.')
                continue;
            if (set.contains(board[i][j]))
                return false;
            set.add(board[i][j]);
        }
        set.clear();
    }

    // Check for each sub-grid
    // ****ATTENTION THE IMPLEMENT!*****
    for (int k = 0; k < 9; k++) {                       //k 0         1   2    3   4   5    6   7   8  
        for (int i = k/3*3; i < k/3*3+3; i++) {         //i 0  1  2   012 012  345 345 345  678 678 678
            for (int j = (k%3)*3; j < (k%3)*3+3; j++) { //j 012012012 345 678  012 345 678  012 345 678 
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        set.clear();
    }
    
    return true;
}
}