package majorityElement;

public class Solution {
    //由于超过⌊ n/2 ⌋次，排序后，直接返回中间那个元素，nums[n/2]
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}