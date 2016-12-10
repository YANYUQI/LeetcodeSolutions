package nextPermutation;

public class Solution {
    //参考的是下面的方法。
    //https://soulmachine.gitbooks.io/algorithm-essentials/content/java/linear-list/array/next-permutation.html
    public void nextPermutation(int[] nums) {
        if (nums.length<2 || nums==null) return;
        
        int begin=0;
        int end=nums.length;
        
        int p = end - 2;
        while (p > -1 && nums[p] >= nums[p + 1]) --p;

        if(p == -1) {
            reverse(nums, begin, end);
            return;
        }
       
        int c = end - 1;
        while (c > 0 && nums[c] <= nums[p]) --c;

        swap(nums, p, c);

        reverse(nums, p+1, end);
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private static void reverse(int[] nums, int begin, int end) {
        end--;
        while (begin < end) {
            swap(nums, begin++, end--);
        }
    }
}