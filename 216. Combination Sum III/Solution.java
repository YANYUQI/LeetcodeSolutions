package combinationSumIII;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(k<=0 || n<=0) return res;
        List<Integer> cur=new ArrayList<Integer>();
        helper(res,cur,k,n,1);
        return res;
    }
    
    public void helper(List<List<Integer>> res,List<Integer> cur,int k, int n,int begin){
        
        if(k==0 && n==0) {
            res.add(new ArrayList<Integer>(cur));//new new new list!!!!!
            return;
        }
        
        if(n<0 || k<0) return;
        
        for(int i=begin;i<10;i++){
            cur.add(i);
            helper(res,cur,k-1,n-i,i+1);
            //k-1 k--是有区别的，k--改变了k的值，k-1把值传递给下一个函数了但是k值没变。另外n、i都不能变，否则return返回本函数后会错。
            cur.remove(cur.size() - 1);
            //如果错误了或者已经成功了后return回来，就要把最后一个remove。而且之前的n、k、i值没变，故而可以进行下一个for循环
        }
    }
}