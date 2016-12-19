package gasStation;

public class Solution {
    /*REFERENCE http://www.cnblogs.com/felixfang/p/3814463.html
    
    这种解法其实依托于一个数学命题：
        对于一个循环数组，如果这个数组整体和 SUM >= 0，那么必然可以在数组中找到这
    么一个元素：从这个数组元素出发，绕数组一圈，能保证累加和一直是出于非负状态。
    
        假设从站点 i 出发，到达站点 k 之前，依然能保证油箱里油没见底儿，从k 出发后，
    见底儿了。i 到 k 这些站点都不用作为出发点来试验了，肯定不满足条件，只需要从k+1
    站点尝试即可！
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,curSum=0,j=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            curSum+=gas[i]-cost[i];
            
            if(curSum<0){
                curSum=0;
                j=i+1;
            }
        }
        return total<0?-1:j;
    }
}