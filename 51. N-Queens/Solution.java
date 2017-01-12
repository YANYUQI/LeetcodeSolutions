package nQueens;

public class Solution {
    
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] column=new int[n];
        dfs(result,column,0,n);
        return result;
    }
    
    
    //row从0开始算，最大为n-1
    private void dfs(List<List<String>> result,int[] column,int row,int n){
        
        //到底了，可以保存结果了
        if(row==n){
            List<String> solution=new ArrayList<String>();
            for(int i=0;i<n;i++){
                char[] charArray=new char[n];
                Arrays.fill(charArray,'.');
                charArray[column[i]]='Q';
                solution.add(new String(charArray));
                
            }
            result.add(solution);
            return;
        }
        
        for(int i=0;i<n;i++){
            column[row]=i;
            if(isValid(column,row)){
                dfs(result,column,row+1,n);
            }else{
                return;
            }
        }
        
        
    }
    
    
    
    //判断第row行的queen放置位置是否可行
    private boolean isValid(int[] column,int row){
        for(int i=0;i<row;i++){
            if(column[row]==column[i]){//行和列没有重叠的
                return false;
            }
            if(Math.abs(column[row]-column[i])==row-i){//对角线没有重叠的
                return false;
            }
        }
        return true;
    }
    
    
}