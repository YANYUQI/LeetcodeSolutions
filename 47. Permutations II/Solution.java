package permutationsII;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        backtrack(set, new ArrayList<>(), nums, new boolean[nums.length]);
        List<List<Integer>> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }

    private void backtrack(Set<List<Integer>> set, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            set.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i]) continue;
                used[i] = true; 
                tempList.add(nums[i]);
                backtrack(set, tempList, nums, used);
                used[i] = false; 
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}