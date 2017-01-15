package subsetsII;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(nums);
        //nums排序了，那么得打的结果子序列也是排序好的，然后用set就可以剔除重复的，比如防止了[1,4,4][4,1,4]同时存在的情况
        dfs(res,sol,nums,0);
        //List<List<Integer>> result = new ArrayList<>();
        //result.addAll(res);//或者使用set，然后转换为list再return
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> sol, int[] nums, int start){
        res.add(new ArrayList<Integer>(sol));
        
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            //从i大于start开始判断重复的，并且跳过（每个for循环在solution中增加一个num，所以保证一个for循环里面不会重复使用相同num即可）
            sol.add(nums[i]);
            dfs(res,sol,nums,i+1);
            sol.remove(sol.size()-1);
        }
    }
}