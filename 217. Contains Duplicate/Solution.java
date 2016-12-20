package containsDuplicate;

public class Solution {
    // 用HashSet, 不断往里面塞元素，如果发现有重复，说明存在重复。时间O(n)，空间O(n)。
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> existedNum=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(!existedNum.contains(nums[i])){
                existedNum.add(nums[i]);
            }else return true;
        }
        return false;
    }
}