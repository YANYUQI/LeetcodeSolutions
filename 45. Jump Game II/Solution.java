package jumpGameII;

public class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int maxReach=0;//目前为止最远可达的index
        int step=0;//count步能走到的最远处
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(i>step){//i一旦超过count步能走的最远距离，那么就需要count+1步
                count++;
                step=maxReach;
            }
            maxReach=Math.max(maxReach,nums[i]+i);//maxReach更新放在count更新之后
            
        }
        return count;
    }
}