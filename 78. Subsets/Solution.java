package subsets;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<Integer>();
        dfs(res,sol,nums,0);
        return res;
    }
    
    private void dfs( List<List<Integer>> res, List<Integer> sol, int[] nums, int start){
        res.add(new ArrayList<Integer>(sol));
        
        for(int i=start;i<nums.length;i++){
            sol.add(nums[i]);
            dfs(res,sol,nums,i+1);
            sol.remove(sol.size()-1);
        }
    }
}