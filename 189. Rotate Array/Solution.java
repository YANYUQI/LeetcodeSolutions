package rotateArray;

public class Solution {
    //这个方法记牢就行：前面length-k个和后面k个各自reverse，然后整个数组再reverse一次。
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    private static void reverse(int[] nums, int left, int right) {
        while(left<right) {
            int tmp=nums[left];
            nums[left]=nums[right];
            nums[right]=tmp;
            left++;
            right--;
        }
    }
}