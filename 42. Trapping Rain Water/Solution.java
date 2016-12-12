package trappingRainWater;

public class Solution {
    //reference https://soulmachine.gitbooks.io/algorithm-essentials/content/java/linear-list/array/trapping-rain-water.html
    public int trap(int[] height) {
        int[] maxLeft=new int[height.length];
        for(int i=1;i<height.length;i++){
            maxLeft[i]=Math.max(height[i-1],maxLeft[i-1]);
        }
        int[] maxRight=new int[height.length];
        for(int i=height.length-2;i>=0;i--){
            maxRight[i]=Math.max(height[i+1],maxRight[i+1]);
        }
        int sum=0;
        for(int i=0;i<height.length;i++){
            if(Math.min(maxRight[i],maxLeft[i])>height[i]){
                sum+=Math.min(maxRight[i],maxLeft[i])-height[i];
            }
        }
        return sum;
    }
}
