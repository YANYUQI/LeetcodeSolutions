package threeSumClosest_3SumClosest;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiffSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int tmpSum=nums[i] + nums[j] + nums[k];
                if(Math.abs(tmpSum-target)<Math.abs(minDiffSum-target)){
                    minDiffSum=tmpSum;
                }
                if(tmpSum<target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return minDiffSum;
    }
}
