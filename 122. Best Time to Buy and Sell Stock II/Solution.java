package bestTimetoBuyandSellStockII;

public class Solution {
    public int maxProfit(int[] prices) {//只要后一个大于前一个，就可以把利润算上
        int max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) {max+=(prices[i]-prices[i-1]);}
        }
        return max;
    }
}
