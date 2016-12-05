package removeDuplicatesfromSortedArrayII;

public class Solution {
    //Java为思路一、Python为思路二
    public int removeDuplicates(int[] nums) {
        if(nums.length<3) return nums.length;
        int count=1;
        int curIndex=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                if(++count>=3) continue;
            }else{
                count=1;
            }
            nums[curIndex++]=nums[i];
        }
        return curIndex;
    }
}
