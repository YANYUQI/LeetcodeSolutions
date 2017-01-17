package jumpGame;

public class Solution {//贪心算法——贪心算法的基本思路是从问题的某一个初始解出发一步一步地进行，根据某个优化测度，每一步都要确保能获得局部最优解。贪心算法不是对所有问题都能得到整体最优解，关键是贪心策略的选择，选择的贪心策略必须具备无后效性，即某个状态以前的过程不会影响以后的状态，只与当前状态有关。
    public boolean canJump(int[] nums) {
        int maxReach=nums[0];//目前为止最远可达的index
        for(int i=0;i<=maxReach && maxReach<nums.length;i++){
            //i要小于等于当前的最远可达，且要小于nums.length；或者说maxReach大于nums.lenth就可以结束了
            maxReach=Math.max(maxReach,nums[i]+i);
        }
        return maxReach>=nums.length-1;
    }
}