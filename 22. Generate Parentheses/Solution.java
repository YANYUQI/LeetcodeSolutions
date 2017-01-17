package generateParentheses;

public class Solution {
    public List<String> generateParenthesis(int n) {
       ArrayList<String> res=new ArrayList<String>();
       String item="(";
       if(n<=0) return res;
       dfs(res,item,n-1,n);
       return res;
    }
    
    public void dfs(ArrayList<String> res,String item,int left,int right){
        if(left>right) return;
        if(left==0 & right==0){
            res.add(item);
            return;
        }
        if(left>0) {
            dfs(res,item+'(',left-1,right);
        }
        if(right>0){
            dfs(res,item+')',left,right-1);
        }   
    }
}

