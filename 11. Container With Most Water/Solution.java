package containerWithMostWater;

public class Solution {//注意：此题只要求计算两个line和x轴形成的容器，不考虑两个line之间的line的高度
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while(i<j){
            max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[i] < height[j]){
                i++ ;
            }else{ 
                j--; 
            }
            //当左边的小于右边的时候，对面积起决定性作用的是短的左端。此时若从右端改变，容器肯定小于或者等于当前的面积。只有从左端i++来改变，才有可能产生更大的容器。
        }
        return max;
    }
}