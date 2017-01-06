package productofArrayExceptSelf;

public class Solution {
    //note：禁止用除法，Solve it without division and in O(n).
    //参考https://soulmachine.gitbooks.io/algorithm-essentials/content/java/linear-list/array/product-of-array-except-self.html
    public int[] productExceptSelf(int[] nums) {
        final int[] result=new int[nums.length];
        if(nums.length==0||nums==null) return result;
        
        result[0]=1;
        for(int i=1;i<nums.length;i++){
            result[i]=result[i-1]*nums[i-1];
        }
        
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i]*=right;
            right*=nums[i];
        }
        return result;
    }
}