package wordSearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;
        if(word==null) return true;
        
        int m=board.length;
        int n=board[0].length;
        boolean[][] state=new boolean[m][n];
        //找到第一个相同的当做起始点
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (board[i][j]==word.charAt(0)){
                    state[i][j]=true;
                    if(dfs(board, word, state, 1, i, j)){
                        return true;
                    }
                    state[i][j]=false;
                }
            }
        }
        return false;
    }
    
    private static boolean dfs(char[][] board, String word, boolean[][] state, int start, int i, int j){
        
        if(start==word.length()) return true;
        //上面的
        if(i-1>=0 && board[i-1][j]==word.charAt(start) && state[i-1][j]==false){
            state[i-1][j]=true;
            if(dfs(board, word, state, start+1, i-1, j)){
                return true;
            }
            state[i-1][j]=false;
        }
        //下面的
        if(i+1<board.length && board[i+1][j]==word.charAt(start) && state[i+1][j]==false){
            state[i+1][j]=true;
            if(dfs(board, word, state, start+1, i+1, j)){
                return true;
            }
            state[i+1][j]=false;
        }
        //左边的
        if(j-1>=0 && board[i][j-1]==word.charAt(start) && state[i][j-1]==false){
            state[i][j-1]=true;
            if(dfs(board, word, state, start+1, i, j-1)){
                return true;
            }
            state[i][j-1]=false;
        }
        //右边的
        if(j+1<board[0].length && board[i][j+1]==word.charAt(start) && state[i][j+1]==false){
            state[i][j+1]=true;
            if(dfs(board, word, state, start+1, i, j+1)){
                return true;
            }
            state[i][j+1]=false;
        }
        
        return false;
    }
}