package combinationSumII;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);//利于剪枝
        Set<List<Integer>> res=new HashSet<>();
        List<Integer> solution=new ArrayList<Integer>();
        int sum=0;
        int index=0;
        dfs(candidates,res,target,sum,solution,index);
        List<List<Integer>> result=new ArrayList<>();
        result.addAll(res);
        return result;
    }
    
    public void dfs(int[] nums,Set<List<Integer>> res,int tar,int sum,List<Integer> sol,int index){
        if(sum==tar){
            res.add(sol);
            return;
        }
        
        //if(sum>tar){
        //    return;
        //}
        
        for(int i=index;i<nums.length;i++){
            if(sum+nums[i]>tar) break;
            sol.add(nums[i]);//list.add()返回值是boolean，所以不能new ArrayList<Integer>(sol.add(nums[i]))
            dfs(nums,res,tar,sum+nums[i],new ArrayList<Integer>(sol),i+1);
            sol.remove(sol.size()-1);
            
        }
    }
}